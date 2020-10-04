package com.backend;

import com.backend.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController   
public class UserController {
    @Autowired
    private UserRepository userRepository;

    List<User> users = new ArrayList<>(Arrays.asList(
        new User("001", "Yanika"),
        new User("002", "another Yanika")
    ));
    
    @RequestMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user", method=RequestMethod.POST)
        public void addUser(@RequestBody User user) {
            userRepository.save(user);
         }
    
}
