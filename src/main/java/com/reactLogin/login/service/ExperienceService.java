package com.reactLogin.login.service;

import com.reactLogin.login.model.Experience;
import com.reactLogin.login.model.Profile;
import com.reactLogin.login.model.User;
import com.reactLogin.login.payload.ExprieneceRequest;
import com.reactLogin.login.repository.ExperienceRepository;
import com.reactLogin.login.repository.ProfileRepository;
import com.reactLogin.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public Experience addExperience(ExprieneceRequest exprieneceRequest, String name) {
        User user = userRepository.findByUsername(name);

        Profile profile = profileRepository.findByUser(user);

        Experience experience = new Experience();
        experience.setCompany(exprieneceRequest.getCompany());
        experience.setDescription(exprieneceRequest.getDescription());
        experience.setFrom(exprieneceRequest.getFrom());
        experience.setLocation(exprieneceRequest.getLocation());
        experience.setTitle(exprieneceRequest.getTitle());
        experience.setTo(exprieneceRequest.getTo());
        experience.setProfile(profile);

        return experienceRepository.save(experience);

    }

    public void deleteExperience(String pt_id, String username){
        User user = userRepository.findByUsername(username);
        Profile profile = profileRepository.findByUser(user);
        Experience experience = experienceRepository.findByIdAndProfile(Long.valueOf(pt_id),profile);
        experienceRepository.delete(experience);
    }
}
