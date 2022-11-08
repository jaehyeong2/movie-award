package jjfactory.movieaward.biz.movie.dto.res;

import jjfactory.movieaward.biz.movie.entity.Casting;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.entity.MovieGenre;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@NoArgsConstructor
@Getter
public class MovieDetailRes {
    private String name;
    private String releaseYear;
    private String companyName;
    private List<MovieGenre> genres;
    private Long movieSeq;
    private List<CastingInfo> castingInfoList = new ArrayList<>();
    private List<String> directorNames;


    public void addCastingInfo(List<CastingInfo> castingInfoList) {
        this.castingInfoList.addAll(castingInfoList);
    }

    @NoArgsConstructor
    @Getter
    public static class CastingInfo{
        private String actorNames;
        private String castNames;

        @Builder
        public CastingInfo(String actorNames, String castNames) {
            this.actorNames = actorNames;
            this.castNames = castNames;
        }

        public CastingInfo(Casting casting) {
            this.actorNames = casting.getActor().getName();
            this.castNames = casting.getRoleName();
        }
    }

    public MovieDetailRes(String name, String releaseYear, String companyName, List<MovieGenre> genres) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.companyName = companyName;
        this.genres = genres;
    }

    public MovieDetailRes(Movie movie) {
        this.movieSeq = movie.getId();
        this.name = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.companyName = movie.getCompany().getName();
        this.genres = movie.getGenres();
//        this.castingInfoList =
        this.directorNames = movie.getDirectorNames();
    }
}
