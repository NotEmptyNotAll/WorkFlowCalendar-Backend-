package com.kryha.springjwt.repository;

import com.kryha.springjwt.models.PersistenceChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersistenceChoiceRepository extends JpaRepository<PersistenceChoice , Integer> {



}
