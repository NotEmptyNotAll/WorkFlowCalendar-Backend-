package com.kryha.springjwt.service;

import com.kryha.springjwt.models.DailyStatistics;
import com.kryha.springjwt.payload.response.DailyStatisticResponse;
import com.kryha.springjwt.payload.response.UserResponse;
import com.kryha.springjwt.repository.DailyStatisticsRepository;
import com.kryha.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DailyStatisticsService {

    @Autowired
    private DailyStatisticsRepository dailyStatisticsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityService activityService;



    public List<UserResponse> getUsersStatisticsByName(String name) {

        List<DailyStatistics> dailyStatistics = getDailyStatistics(name);
        List<UserResponse> userResponseList = new ArrayList<>();
        for (DailyStatistics d :
                dailyStatistics) {
            userResponseList.add(new UserResponse(d
                    .getActivity()
                    .getName(), d
                    .getTime(), d
                    .getDate().toString()));
        }
        return userResponseList;
    }


    private List<DailyStatistics> getDailyStatistics(String name) {

        List<DailyStatistics> dailyStatistics =userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + name))
                .getDailyStatistics();
               // .stream().filter(daily -> daily.getDate().equals(date))
               // .collect(Collectors.toList());
        System.out.println(dailyStatistics);
        return dailyStatistics;


    }

    public void save(DailyStatisticResponse dailyStatisticResponse){
        DailyStatistics dailyStatistics = new DailyStatistics();
        dailyStatistics.setActivity(activityService
                .getActivityByName(dailyStatisticResponse
                        .getNameActivity()));
        dailyStatistics.setTime(dailyStatisticResponse
                        .getTime());
        dailyStatistics.setUser_id(userRepository
                .findByUsername(dailyStatisticResponse.getNameUser())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " +dailyStatisticResponse.getNameUser()))
                .getId());
        dailyStatistics.setDate(new Date(new java.util.Date().getTime()));
        dailyStatisticsRepository.save(dailyStatistics);
    }

}
