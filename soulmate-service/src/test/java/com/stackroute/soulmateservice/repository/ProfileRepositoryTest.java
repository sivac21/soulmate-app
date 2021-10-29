package com.stackroute.soulmateservice.repository;

import com.stackroute.soulmateservice.model.Profile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProfileRepositoryTest {
    @Autowired
    private ProfileRepository profileRepository;
    private Profile profile;

    @BeforeEach
    void setUp(){
        profile = new Profile();
        profile.setEmail("siva@gmail.com");
        profile.setName("Siva");
        profile.setAge(24);
        profile.setGender("Male");
        profile.setCity("Chennai");
    }

    @AfterEach
    void tearDown(){
        profileRepository.deleteAll();
        profile = null;
    }

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        profileRepository.save(profile);
        Profile profile1 = profileRepository.findById(profile.getEmail()).get();
        assertEquals("siva@gmail.com", profile1.getEmail(), profile1.getEmail());
    }

    @Test
    public void givenGetAllUsersThenShouldReturnListOfAllUsers(){
        Profile profile = new Profile("bala@gmail.com","Bala",43,"Male","US");
        Profile profile1 = new Profile("kishore@gmail.com","Kishore",14,"Male","TVM");
        profileRepository.save(profile);
        profileRepository.save(profile1);

        List<Profile> profileList = (List<Profile>) profileRepository.findAll();
        assertEquals("kishore@gmail.com", profileList.get(1).getEmail());
    }

    @Test
    public void givenEmailThenShouldReturnRespectiveUser(){
        Profile profile = new Profile("bharathi@gmail.com","Bharathi",22,"Female","Ooty");
        Profile profile1 = profileRepository.save(profile);
        Optional<Profile> optional = profileRepository.findById(profile1.getEmail());
        assertEquals(profile1.getName(),optional.get().getName());
        assertEquals(profile1.getGender(),optional.get().getGender());
        assertEquals(profile1.getAge(),optional.get().getAge());
        assertEquals(profile1.getCity(),optional.get().getCity());
    }

    @Test
    public void givenEmailToDeleteThenShouldReturnDeleteUser(){
        Profile profile = new Profile("vishva@gmail.com","Vishva",21,"Female","VPM");
        profileRepository.save(profile);
        profileRepository.deleteById(profile.getEmail());
        Optional optional = profileRepository.findById(profile.getEmail());
        assertEquals(Optional.empty(), optional);
    }

}