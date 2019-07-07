package com.reactLogin.login.controller;

import com.reactLogin.login.model.Education;
import com.reactLogin.login.model.Experience;
import com.reactLogin.login.model.Profile;
import com.reactLogin.login.payload.EducationRequest;
import com.reactLogin.login.payload.ExprieneceRequest;
import com.reactLogin.login.payload.ProfileRequest;
import com.reactLogin.login.repository.ProfileRepository;
import com.reactLogin.login.service.*;
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

    @Autowired
    private UserService userService;



    @PostMapping("/profile")
    public ResponseEntity<?> saveProfile(@Valid @RequestBody ProfileRequest profileRequest, BindingResult result, Principal principal){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        Profile profile = profileService.saveProfile(profileRequest, principal.getName());

        return  new ResponseEntity<Profile>(profile, HttpStatus.CREATED);

    }
    @GetMapping("/profileshow")
    public ResponseEntity<?> showProfile(Principal principal){

        Profile profile = profileService.findByuser(principal.getName());

        if(profile==null){
            return  new ResponseEntity<Profile>(profile, HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<Profile>(profile, HttpStatus.CREATED);
    }


    @GetMapping("/testing")
    public String testing(Principal principal){


        return  principal.getName();
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

   /* @DeleteMapping("/experience/{pt_id}")
    public void deleteProjectTask(@PathVariable String pt_id, Principal principal){
        experienceService.deleteExperience( pt_id, principal.getName());

//        return new ResponseEntity<String>("Experience "+pt_id+" was deleted successfully", HttpStatus.OK);
    }*/

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

    //delete profile
    @DeleteMapping("/profile")
    public void deleteUserAccount(Principal principal){


        userService.deleteAccount(principal.getName());

    }


    @DeleteMapping("/experience/{pt_id}")
    public Profile deleteProjectTask(@PathVariable Long pt_id, Principal principal){
        return  experienceService.deleteExperience(pt_id, principal.getName());
        //        return new ResponseEntity<String>("Experience "+pt_id+" was deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/education/{education_id}")
    public Profile deleteEducation(@PathVariable Long education_id, Principal principal){
        return  educationService.deleteEducation(education_id, principal.getName());
        //        return new ResponseEntity<String>("Experience "+pt_id+" was deleted successfully", HttpStatus.OK);
    }


}
