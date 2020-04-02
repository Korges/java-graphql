package com.korges.javagraphql.service;

import com.korges.javagraphql.pojo.Student;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public List<Subject> findSubjectListByGivenStudent(Student student) {
        return repository.findSubjectListByStudent(student.getId());
    }
}
