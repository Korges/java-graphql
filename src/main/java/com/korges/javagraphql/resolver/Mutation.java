package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.korges.javagraphql.pojo.Student;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import com.korges.javagraphql.pojo.input.HumanInput;
import com.korges.javagraphql.pojo.input.SubjectInput;
import com.korges.javagraphql.service.LectureService;
import com.korges.javagraphql.service.StudentService;
import com.korges.javagraphql.service.SubjectService;
import com.korges.javagraphql.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final LectureService lectureService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public Student addStudent(HumanInput input) {
        Student student = new Student();
        student.setFirstName(input.getFirstName());
        student.setLastName(input.getLastName());

        return studentService.save(student);
    }

    public Teacher addTeacher(HumanInput input) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(input.getFirstName());
        teacher.setLastName(input.getLastName());

        return teacherService.save(teacher);
    }

    public Subject addSubject(SubjectInput input) {
        Subject subject = new Subject();
        subject.setTitle(input.getTitle());

        return subjectService.save(subject);
    }
}
