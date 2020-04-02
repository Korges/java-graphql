package com.korges.javagraphql.service;

import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import com.korges.javagraphql.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;

    public List<Subject> findAll() {
        return repository.findAll();
    }

    public List<Lecture> findLectureListByGivenSubject(Subject subject) {
        return this.repository.findLectureListByGivenSubject(subject.getId());
    }

    public Teacher findTeacherByGivenSubject(Subject subject) {
        return this.repository.findTeacherByGivenSubject(subject.getId());
    }
}
