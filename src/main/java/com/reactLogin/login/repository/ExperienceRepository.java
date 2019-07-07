package com.reactLogin.login.repository;

import com.reactLogin.login.model.Experience;
import com.reactLogin.login.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    Experience findByIdAndProfile(Long valueOf, Profile profile);


    @Transactional
    @Modifying
    @Query(value ="delete  from experience where id = :id", nativeQuery = true)
    void deleteExperience(@Param("id") Long id);
}
