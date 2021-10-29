package com.stackroute.userservice.bootstrap;

import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author Siva
 * @Date 10/29/2021 12:31 PM
 */
@Component
@Slf4j
public class BootstrapUserData implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public BootstrapUserData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Inside run method");
        User user1 = new User("sivasankaran@abc.com", "sanjay");
        User user2 = new User("rohit@abc.com", "rohit");
        userRepository.save(user1);
        userRepository.save(user2);
        log.debug("Saved 2 users");
    }
}
