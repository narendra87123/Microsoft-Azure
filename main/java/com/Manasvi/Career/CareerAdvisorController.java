/*package com.Manasvi.Career;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/Career")
public class CareerAdvisorController {

    @PostMapping("/advice")
    public Map<String, String> getCareerAdvice(@RequestBody Map<String, String> payload) {
        String skills = payload.get("skills");
        String advice = "Based on your skills in " + skills + ", we suggest exploring Software Engineering or Data Science.";
        return Map.of("advice", advice);
    }
}*/
/* 
package com.Manasvi.Career;

import com.Manasvi.Career.service.CareerAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
@CrossOrigin(origins = "*")
public class CareerAdvisorController {

    @Autowired
    private CareerAdviceService careerAdviceService;

    // Define a DTO class to receive JSON from frontend
    public static class AdviceRequest {
        public String email;
        public String skills;
        public String interests;

        // getters and setters or public fields
    }

    @PostMapping("/advice")
    public String getAdvice(@RequestBody AdviceRequest request) {
        return careerAdviceService.getAdvice(request.interests);
    }
}
*/
package com.Manasvi.Career;

import com.Manasvi.Career.service.CareerAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
@CrossOrigin(origins = "*")  // Allow frontend to call backend from any origin
public class CareerAdvisorController {

    @Autowired
    private CareerAdviceService careerAdviceService;

    // DTO to receive JSON request
    public static class AdviceRequest {
        public String email;
        public String skills;
        public String interests;
    }

   /*  @PostMapping("/advice")
    public String getAdvice(@RequestBody AdviceRequest request) {
        return careerAdviceService.getAdvice(request.skills,request.interests);
    } */
}
