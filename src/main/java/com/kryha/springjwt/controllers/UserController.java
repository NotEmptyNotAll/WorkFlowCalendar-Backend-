package com.kryha.springjwt.controllers;

import com.kryha.springjwt.payload.request.ActivityRequest;
import com.kryha.springjwt.payload.request.AdminRequest;
import com.kryha.springjwt.payload.request.HomeRequest;
import com.kryha.springjwt.payload.response.ActivityResponse;
import com.kryha.springjwt.payload.response.MessageSuccessfullyResponse;
import com.kryha.springjwt.payload.response.UserActivityCategResponse;
import com.kryha.springjwt.payload.response.UserResponse;
import com.kryha.springjwt.service.ActivityService;
import com.kryha.springjwt.service.DailyStatisticsService;
import com.kryha.springjwt.service.PersistenceChoiceService;
import com.kryha.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserController {
    @Autowired
    private DailyStatisticsService dailyStatisticsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private PersistenceChoiceService persistenceChoiceService;


    @RequestMapping(value = "/getStatUser", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<UserResponse> updateUser(@RequestBody HomeRequest request) {

        return dailyStatisticsService.getUsersStatisticsByName(request.getUserName());
    }

    @RequestMapping(value = "/getAllActivityByUser", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<UserActivityCategResponse> getAllActivityByUser(@RequestBody HomeRequest request) {

        return userService.getAllActivityByUser(request.getUserName());
    }

    @RequestMapping(value = "/addActForUser", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public  List<UserActivityCategResponse> addActForUser(@RequestBody ActivityRequest request) {
        persistenceChoiceService.save(request);
        return userService.getAllActivityByUser(request.getUserName());
    }


    @GetMapping("/getAllAct")
    public List<ActivityResponse> getAllAct() {
        return activityService.getAllActivity();
    }

    @RequestMapping(value = "/getUserAct", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<ActivityResponse> getUserAct(@RequestBody HomeRequest request) {
        return userService.getUserActivitiesResponseByName(request.getUserName());
    }

}
