package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.models.Activity;

import com.sabrysolutions.voyager.backend.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;


    public List<Activity> loadActivities() {
        List<Activity> All_Activities = activityRepository.findAll();

        List<Activity> activities =new ArrayList<>();
        for (Activity activity :All_Activities){

            activities.add(activity);
        }
        return activities;
    }

    public List<Activity> activities(String countyName){
        List<Activity> All_Activities = activityRepository.findByPlaceName(countyName);

        List<Activity> activities =new ArrayList<>();
        for (Activity activity :All_Activities){

            activities.add(activity);
        }
        return activities;
    }

}