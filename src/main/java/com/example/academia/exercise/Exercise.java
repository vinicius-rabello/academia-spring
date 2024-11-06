package com.example.academia.exercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "exercises")
@Entity(name = "exercises")
public class Exercise {
    @Id
    private Long id;
    private String name;
    private String muscle_group;
    private String description;
    private String difficulty;
}
