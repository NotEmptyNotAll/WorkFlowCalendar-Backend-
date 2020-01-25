package com.kryha.springjwt.service;

import com.kryha.springjwt.models.Activity;
import com.kryha.springjwt.models.PersistenceChoice;
import com.kryha.springjwt.payload.request.ActivityRequest;
import com.kryha.springjwt.payload.response.*;
import com.kryha.springjwt.repository.PersistenceChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersistenceChoiceService {

    @Autowired
    private PersistenceChoiceRepository persistenceChoiceRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    public void deletePerChoice(Integer id) {
        persistenceChoiceRepository.deleteById(id);
    }

    public void save(ActivityRequest activityRequest) {
        PersistenceChoice persistenceChoice = new PersistenceChoice();
        persistenceChoice.setActivity(activityService
                .getActivityByName(activityRequest.getNameAct()));
        persistenceChoice.setUser(userService
                .getUserByName(activityRequest.getUserName()));
        persistenceChoice.setAction(EUserAction
                .valueOf(activityRequest.getAction()));
        persistenceChoiceRepository.save(persistenceChoice);
    }

    public List<AllUserPersistenceResponse> getAllUserChoice() {
        List<AllUserPersistenceResponse> listResponse = new ArrayList<>();
        List<PersistenceChoice> persistenceChoices = persistenceChoiceRepository.findAll();
        userService.getAllUser().forEach(user ->
                listResponse.add(new AllUserPersistenceResponse(user.getUsername(), new ArrayList<PersistenceResponse>() {{
                    persistenceChoices.stream()
                            .filter(persistenceChoice -> persistenceChoice
                                    .getUser().getUsername().equals(user.getUsername()))
                            .collect(Collectors.toList()).forEach(pChoice ->
                            add(new PersistenceResponse(pChoice.getId(), pChoice.getActivity().getName()
                                    , pChoice.getAction()))
                    );
                }}
                ))
        );
        return listResponse;
    }

    public List<PersistenceChoice> getPersistenceResponseByUser(String name) {
        return persistenceChoiceRepository.findAll()
                .stream().filter(persistenceChoice -> persistenceChoice
                        .getUser()
                        .getUsername()
                        .equals(name))
                .collect(Collectors.toList());
    }
}
