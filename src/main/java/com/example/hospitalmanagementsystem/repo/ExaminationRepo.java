package com.example.hospitalmanagementsystem.repo;

import com.example.hospitalmanagementsystem.models.entities.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExaminationRepo extends JpaRepository<Examination,Integer> {
    Optional<Examination>findTurnByBarCode(String barCode);
}
