package com.korges.javagraphql.service;

import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository repository;

    public List<Lecture> findAll() {
        return repository.findAll();
    }

    public Subject findSubjectByGivenLecture(Lecture lecture) {
        return this.repository.findSubjectByGivenLecture(lecture.getId());
    }
}
