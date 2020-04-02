package com.korges.javagraphql.pojo;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Human {

    private String firstName;
    private String lastName;

}
