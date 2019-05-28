package com.reactLogin.login.repository;

import com.reactLogin.login.model.Profile;
import com.reactLogin.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


    Profile findByUser(User user);

    Profile findByHandle(String handle);
}
