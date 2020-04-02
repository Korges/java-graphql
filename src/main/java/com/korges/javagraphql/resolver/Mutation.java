package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.korges.javagraphql.pojo.Student;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.input.StudentInput;
import com.korges.javagraphql.service.LectureService;
import com.korges.javagraphql.service.StudentService;
import com.korges.javagraphql.service.SubjectService;
import com.korges.javagraphql.service.TeacherService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final LectureService lectureService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public Student addStudent(StudentInput input) {
        Student student = Student.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .subjectList(input.getSubjectList())
                .build();

        return studentService.save(student);
    }

    public Subject addSubject(String title) {
        Subject subject = new Subject();
        subject.setTitle(title);

        return subjectService.save(subject);
    }
}
