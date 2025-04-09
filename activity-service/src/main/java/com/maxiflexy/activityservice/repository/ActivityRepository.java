package com.maxiflexy.activityservice.repository;

import com.maxiflexy.activityservice.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, String> {
}
