//package com.stackroute.soulmateservice.service;
//
//import com.stackroute.soulmateservice.exception.ProfileAlreadyExistsException;
//import com.stackroute.soulmateservice.exception.ProfileNotFoundException;
//import com.stackroute.soulmateservice.model.Profile;
//import com.stackroute.soulmateservice.repository.ProfileRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProfileServiceTest {
//    @Mock
//    private ProfileRepository profileRepository;
//
//    @InjectMocks
//    private ProfileServiceImpl userService;
//    private List<Profile> userlist;
//    private Profile profile;
//    private Optional optional;
//
//    @BeforeEach
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        Profile profile = new Profile("hari@gmail.com","Hari",24,"Male","CSK");
//        optional = Optional.of(profile);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        profile = null;
//    }
//
//    @Test
//    public void givenUserToSaveShouldReturnSavedUser() throws ProfileAlreadyExistsException {
//        when(profileRepository.save(any())).thenReturn(profile);
//        assertEquals(profile,userService.saveUser(profile));
//        verify(profileRepository,times(1)).save(any());
//    }
//
//    @Test
//    public void givenGetAllUsersThenShouldReturnListOfAllUsers() throws Exception {
//        profileRepository.save(profile);
//        when(profileRepository.findAll()).thenReturn(userlist);
//        List<Profile> list = userService.getAllUsers();
//        assertEquals(list, userlist);
//        verify(profileRepository, times(1)).save(profile);
//        verify(profileRepository, times(1)).findAll();
//
//    }
//
//    @Test
//    public void givenEmailToDeleteThenShouldDeleteRespectiveUser() throws ProfileNotFoundException {
//        when(profileRepository.findById(profile.getEmail())).thenReturn(optional);
//        Profile deleteProfile = userService.deleteUser("hari@gmail.com");
//        assertEquals("hari@gmail.com", deleteProfile.getEmail());
//        verify(profileRepository, times(2)).findById(profile.getEmail());
//        verify(profileRepository, times(1)).deleteById(profile.getEmail());
//    }
//
//    @Test
//    public void givenUserToUpdateThenShouldReturnUpdatedUSer() throws ProfileNotFoundException, ProfileAlreadyExistsException {
//        when(profileRepository.existsById(profile.getEmail())).thenReturn(true);
//        when(profileRepository.save(profile)).thenReturn(profile);
//        profile.setEmail("hari@gmail.com");
//        Profile profile1 = userService.updateUser(profile);
//        assertEquals(profile1.getEmail(),"hari@gmail.com");
//        verify(profileRepository, times(1)).save(profile);
//        verify(profileRepository, times(1)).existsById(profile.getEmail());
//    }
//
//}