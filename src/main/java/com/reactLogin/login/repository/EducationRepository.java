package com.reactLogin.login.repository;

import com.reactLogin.login.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    @Transactional
    @Modifying
    @Query(value ="delete  from education where id = :id", nativeQuery = true)
    void deleteEducation(@Param("id") Long id);
}
