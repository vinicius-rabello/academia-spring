package com.example.academia.exercise;

public record ExerciseResponseDTO(
        Long id,
        String name,
        String muscle_group,
        String description,
        String difficulty)
{
    public ExerciseResponseDTO(Exercise exercise) {
        this(exercise.getId(), exercise.getName(), exercise.getMuscle_group(), exercise.getDescription(), exercise.getDifficulty());
    }
}
