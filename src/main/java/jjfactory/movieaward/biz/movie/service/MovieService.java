package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.CompanyCreate;
import jjfactory.movieaward.biz.movie.dto.req.MovieCreate;
import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.biz.movie.entity.Movie;
import jjfactory.movieaward.biz.movie.repository.CompanyRepository;
import jjfactory.movieaward.biz.movie.repository.MovieActorRepository;
import jjfactory.movieaward.biz.movie.repository.MovieRepository;
import jjfactory.movieaward.global.util.DbUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieActorRepository movieActorRepository;
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public void findAll(){

    }

    @Transactional(readOnly = true)
    public void findOne(){

    }

    public void save(Long companyId, MovieCreate dto){
        Company company = DbUtils.getOrThrow(companyRepository, companyId);

        Movie movie = Movie.create(company, dto);
        movieRepository.save(movie);
    }

    public void delete(){

    }

    public void modify(){

    }
}
