package com.example.demoaop.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class Address  implements Serializable {
    private String street;
    private String zipCode;
    private String country;

}
