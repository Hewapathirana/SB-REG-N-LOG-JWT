package com.reactLogin.login.repository;

import com.reactLogin.login.model.Experience;
import com.reactLogin.login.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    Experience findByIdAndProfile(Long valueOf, Profile profile);
}
