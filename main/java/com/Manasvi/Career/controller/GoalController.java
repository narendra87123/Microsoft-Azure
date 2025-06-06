package com.Manasvi.Career.controller;


import com.Manasvi.Career.SkillAnalysisResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GoalController {

    private static final List<String> AVAILABLE_GOALS = Arrays.asList(
            "Java Developer",
            "Frontend Developer",
            "Full Stack Developer",
            "DevOps Engineer",
            "Data Scientist"
    );

    @GetMapping("/goals")
    public List<String> getAvailableGoals() {
        return AVAILABLE_GOALS;
    }

    @PostMapping("/analyze")
    public SkillAnalysisResult analyzeSkills(@RequestBody SkillAnalysisRequest request) {
        String goal = request.getGoal();
        String skillsInput = request.getSkills();
         if (request.getGoal() == null || request.getSkills() == null) {
        throw new IllegalArgumentException("Goal and skills must not be null");
    }
        
        // Process user skills (split by comma and trim)
        List<String> userSkills = Arrays.stream(skillsInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        
        // Get required skills for the selected goal (in a real app, this would come from a database)
        List<String> requiredSkills = getRequiredSkillsForGoal(goal);
        
        // Find matching skills (case insensitive comparison)
        List<String> matchingSkills = userSkills.stream()
                .filter(userSkill -> requiredSkills.stream()
                        .anyMatch(reqSkill -> reqSkill.equalsIgnoreCase(userSkill)))
                .collect(Collectors.toList());
        
        // Find missing skills
        List<String> missingSkills = requiredSkills.stream()
                .filter(reqSkill -> !matchingSkills.stream()
                        .anyMatch(matchSkill -> matchSkill.equalsIgnoreCase(reqSkill)))
                .collect(Collectors.toList());
        
        return new SkillAnalysisResult(goal, userSkills, requiredSkills, matchingSkills, missingSkills);
    }

    private List<String> getRequiredSkillsForGoal(String goal) {
        // In a real application, this would come from a database
        // Here's a simplified hardcoded version
        switch (goal) {
            case "Java Developer":
                return Arrays.asList("Java", "Spring Boot", "Hibernate", "SQL", "Maven", "REST APIs");
            case "Frontend Developer":
                return Arrays.asList("HTML", "CSS", "JavaScript", "React", "Angular", "TypeScript");
            case "Full Stack Developer":
                return Arrays.asList("Java", "Spring Boot", "HTML", "CSS", "JavaScript", "React", "SQL", "REST APIs");
            case "DevOps Engineer":
                return Arrays.asList("Docker", "Kubernetes", "AWS", "CI/CD", "Linux", "Scripting");
            case "Data Scientist":
                return Arrays.asList("Python", "Pandas", "NumPy", "Machine Learning", "SQL", "Data Visualization");
            default:
                return Arrays.asList();
        }
    }
}

class SkillAnalysisRequest {
    private String goal;
    private String skills;

    // Getters and setters
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
