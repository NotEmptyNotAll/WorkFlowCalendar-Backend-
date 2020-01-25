package com.kryha.springjwt.controllers;

import com.kryha.springjwt.payload.request.HomeRequest;
import com.kryha.springjwt.payload.response.ActivityResponse;
import com.kryha.springjwt.payload.request.AdminActionRequest;
import com.kryha.springjwt.payload.response.AllUserPersistenceResponse;
import com.kryha.springjwt.payload.response.EUserAction;
import com.kryha.springjwt.service.PersistenceChoiceService;
import com.kryha.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersistenceChoiceService persistenceChoiceService;

    @RequestMapping(value = "/getUserActForAdmin", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<ActivityResponse> getUserStat(@RequestBody HomeRequest request) {
        return userService.getUserActivitiesResponseByName(request.getUserName());
    }

    @GetMapping(value = "/getUserPerActivity") //
    public List<AllUserPersistenceResponse> getUserPerActivity() {
        return persistenceChoiceService.getAllUserChoice();
    }

    @RequestMapping(value = "/addUserActForAdmin", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<AllUserPersistenceResponse> adminAction(@RequestBody AdminActionRequest request) {
        System.out.println(request.getAction().equals(EUserAction.ADD.toString()));
        if (request.getAgree()) {
            if (request.getAction().equals(EUserAction.ADD.toString()))
                userService.addActivityToUser(request);
            else if (request.getAction().equals(EUserAction.DELETE.toString()))
                userService.deleteActivityToUser(request);
        } else
            persistenceChoiceService.deletePerChoice(request.getId());
        return persistenceChoiceService.getAllUserChoice();
    }

}
