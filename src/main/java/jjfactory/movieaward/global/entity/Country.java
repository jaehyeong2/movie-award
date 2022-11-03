package jjfactory.movieaward.global.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum Country {
    KOREA(1),
    NORTH_KOREA(2),
    AMERICA(3),
    JAPAN(4);
    int code;

    Country(int code) {
        this.code = code;
    }
}
