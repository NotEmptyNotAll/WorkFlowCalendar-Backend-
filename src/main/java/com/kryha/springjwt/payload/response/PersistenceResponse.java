package com.kryha.springjwt.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersistenceResponse {
    private Integer id;

    private String nameAct;

    private EUserAction action;

    public PersistenceResponse(Integer id, String nameAct, EUserAction action) {
        this.id = id;
        this.nameAct = nameAct;
        this.action = action;
    }
}
