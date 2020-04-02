package com.korges.javagraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Student;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import com.korges.javagraphql.service.LectureService;
import com.korges.javagraphql.service.StudentService;
import com.korges.javagraphql.service.SubjectService;
import com.korges.javagraphql.service.TeacherService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final LectureService lectureService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public List<Lecture> allLectures() {
        return this.lectureService.findAll();
    }

    public List<Student> allStudents() {
         return this.studentService.findAll();
    }

    public List<Subject> allSubjects() {
        return this.subjectService.findAll();
    }

    public List<Teacher> allTeachers() {
        return this.teacherService.findAll();
    }

    public List<Object> allSubjectsAndLectures() {
        List personList = this.subjectService.findAll();
        personList.addAll(this.lectureService.findAll());
        return personList;
    }
}
