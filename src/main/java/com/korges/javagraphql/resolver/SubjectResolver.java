package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import com.korges.javagraphql.service.SubjectService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubjectResolver implements GraphQLResolver<Subject> {

    private final SubjectService subjectService;

    public List<Lecture> lectureList(Subject subject) {
        return this.subjectService.findLectureListByGivenSubject(subject);
    }

    public Teacher teacher(Subject subject) {
        return this.subjectService.findTeacherByGivenSubject(subject);
    }
}
