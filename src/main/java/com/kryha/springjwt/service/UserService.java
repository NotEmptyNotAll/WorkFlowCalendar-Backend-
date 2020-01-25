package com.kryha.springjwt.service;


import com.kryha.springjwt.models.Activity;
import com.kryha.springjwt.models.DailyStatistics;
import com.kryha.springjwt.models.PersistenceChoice;
import com.kryha.springjwt.models.User;
import com.kryha.springjwt.payload.response.ActivityResponse;
import com.kryha.springjwt.payload.request.AdminActionRequest;
import com.kryha.springjwt.payload.response.AllUserPersistenceResponse;
import com.kryha.springjwt.payload.response.PersistenceResponse;
import com.kryha.springjwt.payload.response.UserActivityCategResponse;
import com.kryha.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PersistenceChoiceService persistenceChoiceService;



    public User getUserByName(String name) {
        return userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + name));
    }

    public List<ActivityResponse> getUserActivitiesResponseByName(String name) {
        User user =getUserByName(name);
        Set<Activity> userActivitiesResponseSet = user
                .getActivities();
        List<DailyStatistics> dailyStatisticsList= user.getDailyStatistics();
        dailyStatisticsList.stream().filter(dailyStatistics -> dailyStatistics.getDate().equals(new Date(new java.util.Date().getTime())));
        List<ActivityResponse> userActivitiesResponseList = new ArrayList<>();
        for (Activity activity :
                userActivitiesResponseSet) {
            userActivitiesResponseList.
                    add(new ActivityResponse(activity.getName()
                            , activity.getCategory().getName()));
        }

        userActivitiesResponseList.forEach(userActivity->
                dailyStatisticsList.forEach(dailyStatistics ->{
                    if(dailyStatistics.getActivity().getName().equals(userActivity.getNameAct()))
                        userActivity.setStatus("WAIT");
                }));

        return userActivitiesResponseList;
    }

    private List<ActivityResponse> filterActivityByUser(String name) {
        List<ActivityResponse> userActivityResponse = getUserActivitiesResponseByName(name);
        List<ActivityResponse> activityList = activityService.getAllActivity();
        activityList.forEach(activityResponse ->
                userActivityResponse.forEach(activity -> {
                            if (activityResponse.getNameAct().equals(activity.getNameAct()))
                                activityResponse.setUserHas(true);
                        }
                )
        );
        return activityList;
    }

    private List<ActivityResponse> filterActivityByStatus(String name , List<ActivityResponse> activityList) {
        List<PersistenceChoice> userPersistenceChoice = persistenceChoiceService
                .getPersistenceResponseByUser(name);
        activityList.forEach(activityResponse ->
                userPersistenceChoice.forEach(persistenceChoice -> {
                            if (activityResponse.getNameAct().equals(persistenceChoice.getActivity().getName()))
                                activityResponse.setStatus("WAIT");
                        }
                )
        );
        activityList.forEach(activity->System.out.println(activity.getStatus()));
        return activityList;
    }

    public List<UserActivityCategResponse> getAllActivityByUser(String name) {
        List<UserActivityCategResponse> responseList = new ArrayList<>();
        List<ActivityResponse> activityList = filterActivityByStatus(name,filterActivityByUser(name));
        categoryService.getAllCategory().forEach(category -> {
            responseList.add(new UserActivityCategResponse(category.getName(), activityList.stream()
                    .filter(activity -> activity.getNameCateg().equals(category.getName()))
                    .collect(Collectors.toList())));
        });
        return responseList;
    }

    public void addActivityToUser(AdminActionRequest adminActionRequest) {
        User user = getUserByName(adminActionRequest.getUsername());
        user.getActivities().add(activityService
                .getActivityByName(adminActionRequest.getNameActivity()));
        userRepository.save(user);
        persistenceChoiceService.deletePerChoice(adminActionRequest.getId());
    }

    public void deleteActivityToUser(AdminActionRequest adminActionRequest) {
        User user = userRepository.findByUsername(adminActionRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + adminActionRequest.getUsername()));
        user.getActivities().remove(activityService
                .getActivityByName(adminActionRequest.getNameActivity()));

        userRepository.save(user);
        persistenceChoiceService.deletePerChoice(adminActionRequest.getId());
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
