package jjfactory.movieaward.biz.movie.service;

import jjfactory.movieaward.biz.movie.dto.req.CompanyCreate;
import jjfactory.movieaward.biz.movie.dto.req.CompanyModify;
import jjfactory.movieaward.biz.movie.dto.res.CompanyDetailRes;
import jjfactory.movieaward.biz.movie.dto.res.CompanyRes;
import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.biz.movie.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public List<CompanyRes> findAll(){
        return companyRepository.findAll().stream()
                .map(CompanyRes::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CompanyDetailRes findOne(Long companyId){
        Company company = getCompany(companyId);
        return new CompanyDetailRes(company);
    }

    public Long save(CompanyCreate dto){
        Company company = Company.create(dto);

        companyRepository.save(company);
        return company.getId();
    }

    public String delete(Long companyId){
        companyRepository.deleteById(companyId);
        return "ok";
    }

    public String modify(Long companyId, CompanyModify dto){
        Company company = getCompany(companyId);
        company.modify(dto);
        return "ok";
    }

    public String changeBizNum(Long companyId,String bizNum){
        Company company = getCompany(companyId);
        company.changeBizNum(bizNum);
        return "ok";
    }

    private Company getCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() ->{
            throw new NoSuchElementException();
        });
        return company;
    }
}
