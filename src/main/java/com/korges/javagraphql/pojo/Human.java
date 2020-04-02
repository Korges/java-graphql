package com.korges.javagraphql.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class Human {

    private String firstName;
    private String lastName;

}
