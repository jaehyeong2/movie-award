package jjfactory.movieaward.global.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {
    private String city;
    private String zipCode;
    private String street;

    @Builder
    public Address(String city, String zipCode, String street) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
    }
}
