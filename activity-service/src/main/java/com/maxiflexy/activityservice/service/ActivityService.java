package com.maxiflexy.activityservice.service;

import com.maxiflexy.activityservice.dto.request.ActivityRequest;
import com.maxiflexy.activityservice.dto.response.ActivityResponse;

public interface ActivityService {
    ActivityResponse trackActivity(ActivityRequest request);
}
