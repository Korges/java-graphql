package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.korges.javagraphql.pojo.Student;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentResolver implements GraphQLResolver<Student> {

    private final StudentService studentService;

    public List<Subject> subjectList(Student student) {
            return studentService.findSubjectListByGivenStudent(student);
    }
}
