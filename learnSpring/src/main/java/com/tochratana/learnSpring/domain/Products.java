package com.tochratana.learnSpring.domain;

import lombok.Data;

@Data
public class Products {
    private String id;
    private Integer code;
    private String name;
    private Integer price;
    private String description;
}
