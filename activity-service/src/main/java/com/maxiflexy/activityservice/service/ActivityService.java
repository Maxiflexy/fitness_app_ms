package com.maxiflexy.activityservice.service;

import com.maxiflexy.activityservice.dto.request.ActivityRequest;
import com.maxiflexy.activityservice.dto.response.ActivityResponse;

import java.util.List;

public interface ActivityService {

    ActivityResponse trackActivity(ActivityRequest request);
    List<ActivityResponse> getUserActivities(String userId);
    ActivityResponse getActivityById(String activityId);
}
