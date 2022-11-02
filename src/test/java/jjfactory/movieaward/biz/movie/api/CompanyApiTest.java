package jjfactory.movieaward.biz.movie.api;

import jjfactory.movieaward.biz.movie.entity.Company;
import jjfactory.movieaward.biz.movie.repository.CompanyRepository;
import jjfactory.movieaward.global.entity.Address;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Transactional
@SpringBootTest
class CompanyApiTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    void setUp(){
        Company companyA = Company.builder()
                .name("companyA")
                .bizNum("01234567890")
                .address(Address.builder()
                        .street("test street")
                        .zipCode("zip")
                        .city("busan")
                        .build())
                .build();

        Company companyB = Company.builder()
                .name("companyB")
                .bizNum("0123456785")
                .address(Address.builder()
                        .street("test street")
                        .zipCode("zip")
                        .city("seoul")
                        .build())
                .build();
        companyRepository.save(companyB);
        companyRepository.save(companyA);
    }

    @Test
    @DisplayName("단건 조회 성공")
    void find() throws Exception {
        mockMvc.perform(get("/company"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result[0].name").value("companyB"))
                .andExpect(jsonPath("$.result[1].city").value("busan"))
                .andDo(print());
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void modifyBizNum() {
    }
}