package com.kryha.springjwt.models;


import com.kryha.springjwt.payload.response.EUserAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersistenceChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_activity",nullable = false)
    private Activity activity;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EUserAction action;

}
