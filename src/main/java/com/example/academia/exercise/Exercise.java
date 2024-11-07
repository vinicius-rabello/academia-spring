package com.example.academia.exercise;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents an Exercise entity in the system.
 * This class is mapped to the "exercises" table in the database and contains
 * attributes related to an exercise, such as its name, muscle group, description, and difficulty.
 * It also includes a constructor for creating an exercise from an ExerciseRequestDTO object.
 */
@Table(name = "exercises")
@Entity(name = "exercises")
@Getter
@Setter
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

    /**
     * Constructor to create a new Exercise instance from an ExerciseRequestDTO.
     * This constructor allows for creating an Exercise entity from the data
     * provided in a request body when creating or updating an exercise.
     *
     * @param data The ExerciseRequestDTO containing the data for the new exercise.
     */
    public Exercise(ExerciseRequestDTO data) {
        this.name = data.name();
        this.muscle_group = data.muscle_group();
        this.description = data.description();
        this.difficulty = data.difficulty();
    }
}
