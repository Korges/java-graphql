package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import com.korges.javagraphql.service.TeacherService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TeacherResolver implements GraphQLResolver<Teacher> {

    private final TeacherService teacherService;

    public List<Subject> subjectList(Teacher teacher) {
        return teacherService.findSubjectListByGivenTeacher(teacher);
    }
}
