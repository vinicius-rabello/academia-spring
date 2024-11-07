package com.example.academia.exercise;

public record ExerciseRequestDTO(
        String name,
        String muscle_group,
        String description,
        String difficulty)
{
}
