package com.example.sample.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Score {
    @Id
    private int id;
    @Column(name = "sPoint")
    private float sPoint;
}
