package com.maxiflexy.aiservice.service;

import com.maxiflexy.aiservice.model.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getUserRecommendation(String userId);

    Recommendation getActivityRecommendation(String activityId);
}
