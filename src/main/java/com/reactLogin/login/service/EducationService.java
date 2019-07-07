package com.reactLogin.login.service;

import com.reactLogin.login.model.Education;
import com.reactLogin.login.model.Profile;
import com.reactLogin.login.model.User;
import com.reactLogin.login.payload.EducationRequest;
import com.reactLogin.login.repository.EducationRepository;
import com.reactLogin.login.repository.ProfileRepository;
import com.reactLogin.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public Education addEducation(EducationRequest educationRequest, String name) {
        User user = userRepository.findByUsername(name);
        Profile profile = profileRepository.findByUser(user);

        Education education = new Education();
        education.setSchool(educationRequest.getSchool());
        education.setDescription(educationRequest.getDescription());
        education.setFrom(educationRequest.getFrom());
        education.setDegree(educationRequest.getDegree());
        education.setFieldofstudy(educationRequest.getFieldofstudy());
        education.setTo(educationRequest.getTo());
        education.setProfile(profile);

        return educationRepository.save(education);

    }


    public Profile  deleteEducation(Long pt_id,  String username){
        educationRepository.deleteEducation(pt_id);
        User user = userRepository.findByUsername(username);
        Profile profile = profileRepository.findByUser(user);
        return  profile;
    }
}

