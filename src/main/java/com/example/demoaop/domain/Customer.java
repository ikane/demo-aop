package com.example.demoaop.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class Customer implements Serializable {
    private String id;
    private String name;
    private String email;

    private Address address;
}
