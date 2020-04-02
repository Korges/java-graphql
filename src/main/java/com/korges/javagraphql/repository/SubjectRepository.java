package com.korges.javagraphql.repository;

import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Subject;
import com.korges.javagraphql.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT subject.lectureList FROM Subject subject WHERE subject.id = :id")
    List<Lecture> findLectureListByGivenSubject(Long id);

    @Query("SELECT subject.teacher FROM Subject subject WHERE subject.id = :id")
    Teacher findTeacherByGivenSubject(Long id);

}
