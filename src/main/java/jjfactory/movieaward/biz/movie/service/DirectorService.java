package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.DirectorCreate;
import jjfactory.movieaward.biz.movie.dto.res.DirectorDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.DirectorRes;
import jjfactory.movieaward.biz.movie.entity.Director;
import jjfactory.movieaward.biz.movie.repository.DirectorQueryRepository;
import jjfactory.movieaward.biz.movie.repository.DirectorRepository;
import jjfactory.movieaward.global.dto.res.PagingRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorQueryRepository directorQueryRepository;

    @Transactional(readOnly = true)
    public DirectorDetailRes findOne(Long directorCode){
        return directorQueryRepository.findDirector(directorCode);
    }

    @Transactional(readOnly = true)
    public PagingRes<DirectorRes> findAll(Pageable pageable){
        return new PagingRes<>(directorQueryRepository.findAllDirectors(pageable));
    }

    public Long save(DirectorCreate dto){
        Director director = Director.create(dto);
        return directorRepository.save(director).getPeopleCode();
    }

    public String delete(Long directorId){
        directorRepository.deleteById(directorId);
        return "ok";
    }
}
