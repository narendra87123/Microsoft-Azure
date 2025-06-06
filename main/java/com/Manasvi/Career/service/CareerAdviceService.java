/*package com.Manasvi.Career.service;


import org.springframework.stereotype.Service;
import java.util.*;
 
@Service
public class CareerAdviceService {

    private static final Map<String, String> trie = new HashMap<>();

    static {
        trie.put("programming", "Software Developer, Data Scientist");
        trie.put("design", "UI/UX Designer, Graphic Designer");
        trie.put("math", "Data Analyst, Quantitative Researcher");
        trie.put("writing", "Content Writer, Technical Writer");
    }

    public String getAdvice(String skills, String interests) {
        String[] tokens = (skills + " " + interests).toLowerCase().split("[ ,]+");
        Set<String> result = new HashSet<>();

        for (String word : tokens) {
            if (trie.containsKey(word)) {
                result.add(trie.get(word));
            }
        }

        return result.isEmpty() ? "Explore more skills to find suitable careers!" : String.join(", ", result);
    }
}
*/
/* 
@Service
public class CareerAdviceService {
    private static final Map<String, String> adviceMap = new HashMap<>();

    static {
        adviceMap.put("data", "Data Scientist, Data Analyst");
        adviceMap.put("ai", "AI Researcher, Machine Learning Engineer");
        adviceMap.put("web", "Frontend Developer, Backend Developer");
        adviceMap.put("mobile", "Mobile App Developer");
        adviceMap.put("design", "UI/UX Designer, Graphic Designer");
    }

    public String getAdvice(String interests) {
        if (interests == null) return "No interests provided.";

        String[] tokens = interests.toLowerCase().split("[ ,]+");
        Set<String> results = new HashSet<>();

       /*  for (String token : tokens) {
            if (adviceMap.containsKey(token)) {
                results.add(adviceMap.get(token));
            }
        }

        return results.isEmpty() ? "Explore more skills to find suitable careers!" : String.join(", ", results);
    }
}
*//* 
 for (Map.Entry<String, String> entry : adviceMap.entrySet()) {
            if (interests.contains(entry.getKey())) {
                results.add(entry.getValue());
            }
        }

        return results.isEmpty() ? "Explore more skills to find suitable careers!" : String.join(", ", results);
    }
}*/
/* 
package com.Manasvi.Career.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CareerAdviceService {

    private static final Map<String, String> adviceMap = new HashMap<>();

    static {
        adviceMap.put("data", "Software Developer, Data Scientist");
        adviceMap.put("ai", "AI Engineer, Machine Learning Specialist");
        adviceMap.put("web", "Frontend Developer, Backend Developer, Fullstack Developer");
        adviceMap.put("mobile", "iOS Developer, Android Developer");
        adviceMap.put("design", "UI/UX Designer, Graphic Designer");
    }

    public String getAdvice(String interests) {
        if (interests == null) return "No interests provided.";

        interests = interests.toLowerCase();

        Set<String> results = new HashSet<>();

        for (Map.Entry<String, String> entry : adviceMap.entrySet()) {
            if (interests.contains(entry.getKey())) {
                results.add(entry.getValue());
            }
        }

        return results.isEmpty() ? "Explore more skills to find suitable careers!" : String.join(", ", results);
    }
}
*/
package com.Manasvi.Career.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CareerAdviceService {

    private static final Map<String, String> adviceMap = new HashMap<>();

    static {
        adviceMap.put("programming", "Software Developer, Data Scientist");
        adviceMap.put("design", "UI/UX Designer, Graphic Designer");
        adviceMap.put("math", "Data Analyst, Quantitative Researcher");
        adviceMap.put("writing", "Content Writer, Technical Writer");
        adviceMap.put("data", "Data Scientist, Database Administrator");
        adviceMap.put("ai", "AI Engineer, Machine Learning Specialist");
        adviceMap.put("web", "Frontend Developer, Backend Developer");
        adviceMap.put("mobile", "Android Developer, iOS Developer");
    }

    public String getAdvice(String skills, String interests) {
        String[] tokens = (skills + " " + interests).toLowerCase().split("[ ,]+");
        Set<String> result = new HashSet<>();

        for (String word : tokens) {
            if (adviceMap.containsKey(word)) {
                result.add(adviceMap.get(word));
            }
        }

        if (result.isEmpty()) {
            return "Explore more skills to find suitable careers!";
        } else {
            return String.join(", ", result);
        }
    }
}
