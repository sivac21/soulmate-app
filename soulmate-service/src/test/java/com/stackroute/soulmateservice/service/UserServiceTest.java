package com.stackroute.soulmateservice.service;

import com.stackroute.soulmateservice.model.User;
import com.stackroute.soulmateservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;
    private List<User> userlist;
    private User user;
    private Optional optional;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        User user = new User("hari@gmail.com","Hari",24,"Male","CSK");
        optional = Optional.of(user);
    }

    @AfterEach
    public void tearDown(){
        user = null;
    }

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        when(userRepository.save(any())).thenReturn(user);
        assertEquals(user,userService.saveUser(user));
        verify(userRepository,times(1)).save(any());
    }

    @Test
    public void givenGetAllUsersThenShouldReturnListOfAllUsers() {
        userRepository.save(user);
        when(userRepository.findAll()).thenReturn(userlist);
        List<User> list = userService.getAllUsers();
        assertEquals(list, userlist);
        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).findAll();

    }

    @Test
    public void givenEmailToDeleteThenShouldDeleteRespectiveUser(){
        when(userRepository.findById(user.getEmail())).thenReturn(optional);
        User deleteUser = userService.deleteUser("hari@gmail.com");
        assertEquals("hari@gmail.com", deleteUser.getEmail());
        verify(userRepository, times(2)).findById(user.getEmail());
        verify(userRepository, times(1)).deleteById(user.getEmail());
    }

    @Test
    public void givenUserToUpdateThenShouldReturnUpdatedUSer(){
        when(userRepository.existsById(user.getEmail())).thenReturn(true);
        when(userRepository.save(user)).thenReturn(user);
        user.setEmail("hari@gmail.com");
        User user1 = userService.updateUser(user);
        assertEquals(user1.getEmail(),"hari@gmail.com");
        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).existsById(user.getEmail());
    }

}