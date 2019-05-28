package com.reactLogin.login.controller;

import com.reactLogin.login.model.Education;
import com.reactLogin.login.model.Experience;
import com.reactLogin.login.model.Profile;
import com.reactLogin.login.payload.EducationRequest;
import com.reactLogin.login.payload.ExprieneceRequest;
import com.reactLogin.login.payload.ProfileRequest;
import com.reactLogin.login.repository.ProfileRepository;
import com.reactLogin.login.service.EducationService;
import com.reactLogin.login.service.ExperienceService;
import com.reactLogin.login.service.MapValidationErrorService;
import com.reactLogin.login.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private EducationService educationService;

    @PostMapping("/profile")
    public ResponseEntity<?> saveProfile(@Valid @RequestBody ProfileRequest profileRequest, BindingResult result, Principal principal){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        Profile profile = profileService.saveProfile(profileRequest, principal.getName());

        return  new ResponseEntity<Profile>(profile, HttpStatus.CREATED);

    }
    @GetMapping("/profile")
    public ResponseEntity<?> showProfile(Principal principal){

        Profile profile = profileService.findByuser(principal.getName());
        return  new ResponseEntity<Profile>(profile, HttpStatus.CREATED);
    }

    @PostMapping("/experience")
    public ResponseEntity<?> addExperience(@Valid @RequestBody ExprieneceRequest exprieneceRequest, BindingResult result, Principal principal){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        Experience exprienece = experienceService.addExperience(exprieneceRequest, principal.getName());
        return  new ResponseEntity<Experience>(exprienece, HttpStatus.CREATED);
    }

    @PostMapping("/education")
    public ResponseEntity<?> addEducation(@Valid @RequestBody EducationRequest educationRequest, BindingResult result, Principal principal){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        Education education = educationService.addEducation(educationRequest, principal.getName());
        return  new ResponseEntity<Education>(education, HttpStatus.CREATED);
    }

    @DeleteMapping("/experience/{pt_id}")
    public void deleteProjectTask(@PathVariable String pt_id, Principal principal){
        experienceService.deleteExperience( pt_id, principal.getName());

//        return new ResponseEntity<String>("Experience "+pt_id+" was deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/profile/all")
    public ResponseEntity<?> AllProfiles(){

        List<Profile> profile = profileService.getAll();
        return  new ResponseEntity<List>(profile, HttpStatus.CREATED);
    }

    @GetMapping("/profile/handle/{handle}")
    public ResponseEntity<?> getProfileByHandler(@PathVariable String handle){

        Profile profile = profileService.getProfile(handle);
        return  new ResponseEntity<Profile>(profile, HttpStatus.CREATED);
    }




}
