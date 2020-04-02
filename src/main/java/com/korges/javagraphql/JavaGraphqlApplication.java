package com.korges.javagraphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.korges.javagraphql.resolver.LectureResolver;
import com.korges.javagraphql.resolver.Query;
import com.korges.javagraphql.resolver.StudentResolver;
import com.korges.javagraphql.resolver.SubjectResolver;
import com.korges.javagraphql.resolver.TeacherResolver;
import com.korges.javagraphql.service.LectureService;
import com.korges.javagraphql.service.StudentService;
import com.korges.javagraphql.service.SubjectService;
import com.korges.javagraphql.service.TeacherService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaGraphqlApplication {

    @Autowired
    LectureService lectureService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    public static void main(String[] args) {
        SpringApplication.run(JavaGraphqlApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean graphQLServlet() {
        return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(buildSchema(
                lectureService,
                studentService,
                subjectService,
                teacherService)
        ).build(),"/graphql");
    }

    private static GraphQLSchema buildSchema(LectureService lectureService,
                                             StudentService studentService,
                                             SubjectService subjectService,
                                             TeacherService teacherService) {
        return SchemaParser
                .newParser()
                .file("graphql/schema.graphqls")
//                .dictionary()
                .resolvers(
                        new Query(lectureService, studentService, subjectService, teacherService),
                        new LectureResolver(lectureService),
                        new StudentResolver(studentService),
                        new SubjectResolver(subjectService),
                        new TeacherResolver(teacherService)
                )
                .build()
                .makeExecutableSchema();
    }

}
