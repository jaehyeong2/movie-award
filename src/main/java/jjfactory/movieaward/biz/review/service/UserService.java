package jjfactory.movieaward.biz.review.service;

import jjfactory.movieaward.biz.review.dto.req.UserCreate;
import jjfactory.movieaward.biz.review.dto.req.UserModify;
import jjfactory.movieaward.biz.review.entity.User;
import jjfactory.movieaward.biz.review.repository.UserRepository;
import jjfactory.movieaward.global.util.DbUtils;
import jjfactory.movieaward.global.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public Long join(UserCreate dto, MultipartFile image){
        User user = User.create(dto);
        userRepository.save(user);

        if(image!= null && !image.isEmpty()){
            String folderPath = user.getId()+"/";
            String filePath = folderPath + image.getOriginalFilename();

            try {
                ImageUtil.saveFile(image,filePath,folderPath);
                user.addProfileImagePath(filePath);
            } catch (IOException e) {
                log.error("프로필 이미지 첨부 에러 : {}",e.getMessage(),e);
                //TODO custom exception
            }
        }

        return user.getId();
    }

    public String withdraw(Long userId){
        User user = DbUtils.getOrThrow(userRepository,userId);
        user.withdraw();
        return "ok";
    }

    public String updateInfo(Long userId, UserModify dto){
        User user = DbUtils.getOrThrow(userRepository, userId);
        user.changeNameAndEmail(dto);
        return "ok";
    }
}
