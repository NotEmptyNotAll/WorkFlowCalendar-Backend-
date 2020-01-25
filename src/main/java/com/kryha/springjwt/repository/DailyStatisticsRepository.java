package com.kryha.springjwt.repository;

import com.kryha.springjwt.models.DailyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DailyStatisticsRepository extends JpaRepository<DailyStatistics , Integer> {


}
