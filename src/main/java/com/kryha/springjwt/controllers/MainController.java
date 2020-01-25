package com.kryha.springjwt.controllers;

import com.kryha.springjwt.payload.response.ActivityResponse;
import com.kryha.springjwt.payload.response.DailyStatisticResponse;
import com.kryha.springjwt.payload.response.MessageSuccessfullyResponse;
import com.kryha.springjwt.service.DailyStatisticsService;
import com.kryha.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class MainController {

    @Autowired
    private DailyStatisticsService dailyStatisticsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addStatistics", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<ActivityResponse> addStat(@RequestBody DailyStatisticResponse request) {
        Date date = new Date(new java.util.Date().getTime());
        dailyStatisticsService.save(request);
        return userService.getUserActivitiesResponseByName(request.getNameUser());
    }


    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
