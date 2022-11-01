package jjfactory.movieaward.global.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {
    private String city;
    private String zipCode;
    private String street;
}
