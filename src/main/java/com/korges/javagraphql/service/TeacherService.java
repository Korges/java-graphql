package com.korges.javagraphql.service;

import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import com.korges.javagraphql.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;

    public List<Teacher> findAll() {
        return repository.findAll();
    }

    public List<Subject> findSubjectListByGivenTeacher(Teacher teacher) {
        return this.repository.findSubjectListByGivenTeacher(teacher.getId());
    }

    public Teacher save(Teacher teacher) {
        return this.repository.save(teacher);
    }
}
