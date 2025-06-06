
package com.Manasvi.Career.controller;

import com.Manasvi.Career.model.User;
import com.Manasvi.Career.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5500")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get user profile by email
    @GetMapping("/profile")
    public User getProfile(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

}

