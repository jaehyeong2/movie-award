package jjfactory.movieaward.global.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class ImageUtil {
    private static String PATH;
    private static final String LIVE_PHOTO_EXE = "HEIC";

    @Value("${app.filePath}")
    public void setUploadPath(String path) {
        PATH = path;
    }

    public static String saveFile(MultipartFile file, String location, String folderPath) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        String loc = PATH + location;

        File targetFile = new File(Objects.equals(extension, LIVE_PHOTO_EXE) ? loc.replace(LIVE_PHOTO_EXE, "jpg") : loc);

        File folder = new File(PATH + "/" + folderPath);

        if (!folder.exists()) {
            log.info(folder.getAbsolutePath());
            folder.mkdirs();
        }

        file.transferTo(targetFile);

        return loc;
    }
}
