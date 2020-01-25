package com.kryha.springjwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class AllUserPersistenceResponse {

    private String userName;

    private List<PersistenceResponse> activities;

    public AllUserPersistenceResponse(String userName, List<PersistenceResponse> activities) {
        this.userName = userName;
        this.activities = activities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<PersistenceResponse> getActivities() {
        return activities;
    }

    public void setActivities(List<PersistenceResponse> activities) {
        this.activities = activities;
    }

}
