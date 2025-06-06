/*package com.Manasvi.Career.controller;


import com.Manasvi.Career.model.CareerInput;
import com.Manasvi.Career.repository.CareerInputRepository;
import com.Manasvi.Career.repository.UserRepository;
import com.Manasvi.Career.service.CareerAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class CareerController {

    @Autowired
    private CareerAdviceService adviceService;

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private CareerInputRepository inputRepo;

    @PostMapping("/advice")
    public String getAdvice(@RequestBody CareerInput input) {
        inputRepo.save(input);
        return adviceService.getAdvice( input.getInterests());
    }
}
    */
    package com.Manasvi.Career.controller;

import com.Manasvi.Career.service.CareerAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
@CrossOrigin(origins = "http://localhost:5500")
public class CareerController {

    @Autowired
    private CareerAdviceService careerAdviceService;

    public static class AdviceRequest {
        public String email;
        public String skills;
        public String interests;
    }

    @PostMapping("/advice")
    public String getCareerAdvice(@RequestBody AdviceRequest request) {
        return careerAdviceService.getAdvice(request.skills, request.interests);
    }
}
