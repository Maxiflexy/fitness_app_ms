package com.maxiflexy.aiservice.service;

import com.maxiflexy.aiservice.model.Activity;
import com.maxiflexy.aiservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

    private final ActivityAIService aiService;
    private final RecommendationRepository recommendationRepository;

    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity){
        log.info("Received activity for processing: {}", activity.getId());
        //log.info("Generated Recommendation: {}", aiService.generateRecommendation(activity));

        var recommendation = aiService.generateRecommendation(activity);
        recommendationRepository.save(recommendation);
    }
}
