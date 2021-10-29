package com.stackroute.soulmateservice.repository;

import com.stackroute.soulmateservice.model.User;
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
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setEmail("siva@gmail.com");
        user.setName("Siva");
        user.setAge(24);
        user.setGender("Male");
        user.setCity("Chennai");
    }

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
        user = null;
    }

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        userRepository.save(user);
        User user1 = userRepository.findById(user.getEmail()).get();
        assertEquals("siva@gmail.com", user1.getEmail(),user1.getEmail());
    }

    @Test
    public void givenGetAllUsersThenShouldReturnListOfAllUsers(){
        User user = new User("bala@gmail.com","Bala",43,"Male","US");
        User user1 = new User("kishore@gmail.com","Kishore",14,"Male","TVM");
        userRepository.save(user);
        userRepository.save(user1);

        List<User> userList = (List<User>) userRepository.findAll();
        assertEquals("kishore@gmail.com", userList.get(1).getEmail());
    }

    @Test
    public void givenEmailThenShouldReturnRespectiveUser(){
        User user = new User("bharathi@gmail.com","Bharathi",22,"Female","Ooty");
        User user1 = userRepository.save(user);
        Optional<User> optional = userRepository.findById(user1.getEmail());
        assertEquals(user1.getName(),optional.get().getName());
        assertEquals(user1.getGender(),optional.get().getGender());
        assertEquals(user1.getAge(),optional.get().getAge());
        assertEquals(user1.getCity(),optional.get().getCity());
    }

    @Test
    public void givenEmailToDeleteThenShouldReturnDeleteUser(){
        User user = new User("vishva@gmail.com","Vishva",21,"Female","VPM");
        userRepository.save(user);
        userRepository.deleteById(user.getEmail());
        Optional optional = userRepository.findById(user.getEmail());
        assertEquals(Optional.empty(), optional);
    }

}