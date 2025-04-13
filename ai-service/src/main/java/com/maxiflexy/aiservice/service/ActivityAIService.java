package com.maxiflexy.aiservice.service;

import com.maxiflexy.aiservice.model.Activity;
import com.maxiflexy.aiservice.model.Recommendation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityAIService {

    private final GerminiService germiniService;

    public String generateRecommendation(Activity activity){
        String prompt = createPromptForActivity(activity);

        String aiResponse = germiniService.getAnswer(prompt);

        log.info("Response from AI: {}", aiResponse);
        return aiResponse;
    }

    private String createPromptForActivity(Activity activity) {
        return String.format("""
                Analyze the fitness activity and provide detailed recommendations in the following format
                {
                    "analysis": {
                        "overall": "Overall analysis here",
                        "pace": "Pace analysis here",
                        "heartRate": "Heart rate analysis here",
                        "caloriesBurned": "Calories analysis here"
                    },
                    "improvements": [
                      {
                        "area" : "Area name",
                        "recommendation": "Detailed recommendation"
                      }
                    ],
                    "suggestions": [
                      {
                        "workout": "Workout name",
                        "description": "Detailed workout description" 
                      }
                    ],
                    "safety": [
                      "safety point 1",
                      "safety point 2"
                    ]
                }
                
                Analyze this activity:
                Activity Type: %s
                Duration: %d minutes
                Calories Burned: %d
                Additional Metrics: %s
                
                Provide detailed analysis focusing on performance, improvements, next workout suggestions , and safety guidelines.
                Ensure the response follows the EXACT JSON format shown above
                """,
                activity.getType(),
                activity.getDuration(),
                activity.getCaloriesBurned(),
                activity.getAdditionalMetrics()

        );
    }
}
