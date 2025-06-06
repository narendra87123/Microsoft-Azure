package com.Manasvi.Career;


import java.util.List;

public class SkillAnalysisResult {
    private String goal;
    private List<String> userSkills;
    private List<String> requiredSkills;
    private List<String> matchingSkills;
    private List<String> missingSkills;

    // Constructor
    public SkillAnalysisResult(String goal, List<String> userSkills, 
                             List<String> requiredSkills, 
                             List<String> matchingSkills, 
                             List<String> missingSkills) {
        this.goal = goal;
        this.userSkills = userSkills;
        this.requiredSkills = requiredSkills;
        this.matchingSkills = matchingSkills;
        this.missingSkills = missingSkills;
    }

    // Getters (required for JSON serialization)
    public String getGoal() {
        return goal;
    }

    public List<String> getUserSkills() {
        return userSkills;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public List<String> getMatchingSkills() {
        return matchingSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}