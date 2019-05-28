package com.reactLogin.login.service;

import com.reactLogin.login.model.Profile;
import com.reactLogin.login.model.User;
import com.reactLogin.login.payload.ProfileRequest;
import com.reactLogin.login.repository.ProfileRepository;
import com.reactLogin.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    public Profile saveProfile(ProfileRequest profileRequest, String username) {


        User user = userRepository.findByUsername(username);
        Profile profile = new Profile();
        Profile profile1 = profileRepository.findByUser(user);

        if(profile1 != null){
             profile = profile1;
        }


        profile.setHandle(profileRequest.getHandle());
        profile.setBio(profileRequest.getBio());
        profile.setCompany(profileRequest.getCompany());
        profile.setFacebook(profileRequest.getFacebook());
        profile.setGithubusername(profileRequest.getGithubusername());
        profile.setInstagram(profileRequest.getInstagram());
        profile.setLinkedin(profileRequest.getLinkedin());
        profile.setLocation(profileRequest.getLocation());
        profile.setSkills(profileRequest.getSkills());
        profile.setStatus(profileRequest.getStatus());
        profile.setTwitter(profileRequest.getTwitter());
        profile.setWebsite(profileRequest.getWebsite());
        profile.setUser(user);
        profile.setYoutube(profileRequest.getYoutube());

        return profileRepository.save(profile);
    }

    public Profile findByuser(String name) {
        User user = userRepository.findByUsername(name);
        Profile profile = profileRepository.findByUser(user);
        return profile;
    }

    public List<Profile> getAll() {

        List<Profile> profiles = profileRepository.findAll();
        return profiles;
    }

    public Profile getProfile(String handle) {
        Profile profile = profileRepository.findByHandle(handle);
        return profile;
    }
}
