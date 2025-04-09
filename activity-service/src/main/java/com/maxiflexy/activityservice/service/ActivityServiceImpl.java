package com.maxiflexy.activityservice.service;

import com.maxiflexy.activityservice.repository.ActivityRepository;
import com.maxiflexy.activityservice.dto.request.ActivityRequest;
import com.maxiflexy.activityservice.dto.response.ActivityResponse;
import com.maxiflexy.activityservice.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;

    @Override
    public ActivityResponse trackActivity(ActivityRequest request) {
        var activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        var savedActivity = activityRepository.save(activity);

        return mapTpResponse(savedActivity);

    }

    private ActivityResponse mapTpResponse(Activity activity){
        var response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());

        return response;
    }
}
