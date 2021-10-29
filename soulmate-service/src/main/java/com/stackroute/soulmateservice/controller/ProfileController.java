package com.stackroute.soulmateservice.controller;

import com.stackroute.soulmateservice.exception.ProfileAlreadyExistsException;
import com.stackroute.soulmateservice.exception.ProfileNotFoundException;
import com.stackroute.soulmateservice.model.Profile;
import com.stackroute.soulmateservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {
    private ProfileService profileService;
    private ResponseEntity responseEntity;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/user")
    public ResponseEntity<Profile> saveUser(@RequestBody Profile profile) throws ProfileAlreadyExistsException {
        try {
            Profile savedProfile = profileService.saveUser(profile);
            //TODO call ProfileMessageProducer to publish savedProfile into rabbitmq
            responseEntity = new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
        }
        catch (ProfileAlreadyExistsException e)
        {
            throw new ProfileAlreadyExistsException();
        }
        return responseEntity;

    }

    @GetMapping("/users")
    public ResponseEntity<List<Profile>> getAllUsers() throws Exception {
        responseEntity = new ResponseEntity<List<Profile>>((List<Profile>) profileService.getAllUsers(),HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("user/{email}")
    public ResponseEntity<Profile> deleteUser(@PathVariable("email") String email) throws ProfileNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(profileService.deleteUser(email),HttpStatus.OK);
        }
        catch (ProfileNotFoundException e)
        {
            throw new ProfileNotFoundException();
        }
        return responseEntity;
    }

    @PutMapping("user")
    public ResponseEntity<Profile> updateUser(@RequestBody Profile profile) throws ProfileNotFoundException, ProfileAlreadyExistsException {
        try {
            Profile updatedProfile = profileService.updateUser(profile);
            if (profileService.updateUser(profile) != null) {
                responseEntity = new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (ProfileNotFoundException e)
        {
            throw new ProfileNotFoundException();
        }catch (Exception e){
            throw new ProfileAlreadyExistsException();
        }
        return responseEntity;
    }

    @GetMapping("users/{email}")
    public ResponseEntity<Profile> getUserByEmail(@PathVariable("email") String email) throws ProfileNotFoundException {
        responseEntity = new ResponseEntity<>(profileService.getUserByemail(email),HttpStatus.OK);
        return responseEntity;
    }
}
