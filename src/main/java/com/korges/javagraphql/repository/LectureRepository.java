package com.korges.javagraphql.repository;

import com.korges.javagraphql.pojo.Lecture;
import com.korges.javagraphql.pojo.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("SELECT lecture.subject FROM Lecture lecture WHERE lecture.id = :id")
    Subject findSubjectByGivenLecture(@Param("id") Long id);

}
