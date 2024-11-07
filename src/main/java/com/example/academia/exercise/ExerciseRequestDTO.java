package com.example.academia.exercise;

/**
 * Data Transfer Object (DTO) representing an exercise request.
 * This DTO is used to transfer exercise data from the client to the server.
 * It contains fields for the name, muscle group, description, and difficulty of the exercise.
 */
public record ExerciseRequestDTO(
        String name,
        String muscle_group,
        String description,
        String difficulty)
{
}
