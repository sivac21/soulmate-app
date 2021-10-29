package com.stackroute.soulmateservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.soulmateservice.model.User;
import com.stackroute.soulmateservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;
    private User user;
    private List<User> userList;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp(){
        user = new User("hari@gmail.com","Hari",24,"Male","CSK");
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void givenUserToSaveShouldReturnSavedUser() throws Exception{
        when(userService.saveUser(any())).thenReturn(user);
        mockMvc.perform(post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isCreated());
        verify(userService,times(1)).saveUser(any());
    }

    @Test
    public void getAllUsersThenShouldReturnListOfAllUsers() throws Exception{
        when(userService.getAllUsers()).thenReturn(userList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andDo(MockMvcResultHandlers.print());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void givenEmailToDeleteThenShouldReturnDeletedUser() throws Exception {
        when(userService.deleteUser(user.getEmail())).thenReturn(user);
        mockMvc.perform(delete("/api/v1/user/hari@gmail.com")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void givenUserToUpdateThenShouldReturnUpdatedUser() throws Exception {
        when(userService.updateUser(any())).thenReturn(user);
        mockMvc.perform(put("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}