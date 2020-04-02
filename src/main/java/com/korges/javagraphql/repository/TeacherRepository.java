package com.korges.javagraphql.repository;

import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT teacher.subjectList FROM Teacher teacher WHERE teacher.id = :id")
    List<Subject> findSubjectListByGivenTeacher(Long id);

}
