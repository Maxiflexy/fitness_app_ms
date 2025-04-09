package com.maxiflexy.activityservice.controller;

import com.maxiflexy.activityservice.dto.request.ActivityRequest;
import com.maxiflexy.activityservice.dto.response.ActivityResponse;
import com.maxiflexy.activityservice.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
            @RequestHeader("X-User-ID") String userId){

        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getUserActivityById(@PathVariable String activityId){

        return ResponseEntity.ok(activityService.getActivityById(activityId));
    }
}
