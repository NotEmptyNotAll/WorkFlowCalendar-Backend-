package com.kryha.springjwt.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DailyStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String time;


    //@ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_activity_daily_statistics",nullable = false)
    private Activity activity;


}
