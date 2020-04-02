package com.korges.javagraphql.pojo.input;

import com.korges.javagraphql.pojo.Subject;
import lombok.Data;

import java.util.List;

@Data
public class StudentInput {
    private String firstName;
    private String lastName;
    private List<Subject> subjectList;
}
