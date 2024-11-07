package com.example.academia.exercise;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "exercises")
@Entity(name = "exercises")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String muscle_group;
    private String description;
    private String difficulty;

    public Exercise(ExerciseRequestDTO data) {
        this.name = data.name();
        this.muscle_group = data.muscle_group();
        this.description = data.description();
        this.difficulty = data.difficulty();
    }
}
