package jjfactory.movieaward.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.config.AuditingBeanDefinitionParser;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingBeanDefinitionParser.class)
@MappedSuperclass
@Getter
public class BaseEntity {

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedBy
    private LocalDateTime modifyDate;

}
