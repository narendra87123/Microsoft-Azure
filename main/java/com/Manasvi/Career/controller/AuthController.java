package com.Manasvi.Career.controller;


import com.Manasvi.Career.model.User;
import com.Manasvi.Career.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5500")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email already registered.";
        }
        userRepository.save(user);
        return "Registration successful!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User login) {
        User user = userRepository.findByEmail(login.getEmail());
        return (user != null && user.getPassword().equals(login.getPassword())) ?
            "Login successful!" : "Invalid credentials.";
    }

@GetMapping("/profile")
public User getUserProfile(@RequestParam String email) {
    System.out.println("Looking for user with email: " + email);
    User user = userRepository.findByEmail(email); // Use ignore case
    if (user == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
    user.setPassword(null);
    return user;
}
}
/*public User getUserProfile(@RequestParam(required = false) String email, @RequestParam(required = false) String name) {
    
    if (email == null && name == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
            "Either email or username must be provided");
    }
    
    User user = null;
    
    if (email != null) {
        System.out.println("Looking for user with email: " + email);
        user = userRepository.findByEmail(email);
    } else if (name != null) {
        System.out.println("Looking for user with username: " + name);
        user = userRepository.findByuserName(name);
    }
    
    if (user == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
    
    user.setPassword(null);
    return user;
  }
}
  */