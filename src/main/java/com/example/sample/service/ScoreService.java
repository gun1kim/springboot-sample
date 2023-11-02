package com.example.sample.service;

import com.example.sample.domain.Score;
import com.example.sample.repository.ScoreJpaRepository;
import com.example.sample.repository.ScoreRepository;
import com.example.sample.repository.StudentJpaRepository;
import com.example.sample.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {

    private final StudentJpaRepository studentRepository;

    private final ScoreJpaRepository scoreRepository;
    public ScoreService(StudentJpaRepository studentRepository, ScoreJpaRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public Optional<Score> findById(int id) {
        Optional<Score> score = scoreRepository.findById(id);
        if (score == null) {
            score.get().setSPoint(0);
        }
//        return scoreRepository.findById(id);
        return score;
    }

    public void addScore(Score score) {
        scoreRepository.save(score);
    }

}
