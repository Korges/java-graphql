package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.service.LectureService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LectureResolver implements GraphQLResolver<Lecture> {

    private final LectureService lectureService;

    public Subject subject(Lecture lecture) {
        return this.lectureService.findSubjectByGivenLecture(lecture);
    }
}
