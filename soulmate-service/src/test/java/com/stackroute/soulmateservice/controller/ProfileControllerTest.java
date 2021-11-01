//package com.stackroute.soulmateservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.soulmateservice.model.Profile;
//import com.stackroute.soulmateservice.service.ProfileService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class ProfileControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private ProfileService profileService;
//    private Profile profile;
//    private List<Profile> profileList;
//
//    @InjectMocks
//    private ProfileController profileController;
//
//    @BeforeEach
//    public void setUp(){
//        profile = new Profile("hari@gmail.com","Hari",24,"Male","CSK");
//        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
//    }
//
//    @Test
//    public void givenUserToSaveShouldReturnSavedUser() throws Exception{
//        when(profileService.saveUser(any())).thenReturn(profile);
//        mockMvc.perform(post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(profile)))
//                .andExpect(status().isCreated());
//        verify(profileService,times(1)).saveUser(any());
//    }
//
//    @Test
//    public void getAllUsersThenShouldReturnListOfAllUsers() throws Exception{
//        when(profileService.getAllUsers()).thenReturn(profileList);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(profile)))
//                .andDo(MockMvcResultHandlers.print());
//        verify(profileService, times(1)).getAllUsers();
//    }
//
//    @Test
//    public void givenEmailToDeleteThenShouldReturnDeletedUser() throws Exception {
//        when(profileService.deleteUser(profile.getEmail())).thenReturn(profile);
//        mockMvc.perform(delete("/api/v1/user/hari@gmail.com")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(profile)))
//                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void givenUserToUpdateThenShouldReturnUpdatedUser() throws Exception {
//        when(profileService.updateUser(any())).thenReturn(profile);
//        mockMvc.perform(put("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(asJsonString(profile)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//
//    public static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}