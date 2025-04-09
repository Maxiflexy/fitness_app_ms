package com.maxiflexy.activityservice.repository;

import com.maxiflexy.activityservice.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {

    List<Activity> findByUserId(String userId);
}
