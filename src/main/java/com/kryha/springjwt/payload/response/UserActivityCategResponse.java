package com.kryha.springjwt.payload.response;

import com.kryha.springjwt.models.Activity;
import com.kryha.springjwt.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserActivityCategResponse {
    private List<ActivityResponse> activities;

    private String nameCategory;

    public UserActivityCategResponse(String nameCategory,List<ActivityResponse> activities) {
        this.activities = activities;
        this.nameCategory = nameCategory;
    }
}
