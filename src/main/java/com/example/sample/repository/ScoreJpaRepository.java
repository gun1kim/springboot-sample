package com.example.sample.repository;

import com.example.sample.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreJpaRepository extends JpaRepository<Score, Integer>  {
}
