package com.example.academia.exercise;

/**
 * Data Transfer Object (DTO) representing an exercise response.
 * This DTO is used to send exercise data from the server to the client.
 * It includes the fields of an exercise along with its ID.
 */
public record ExerciseResponseDTO(
        Long id,
        String name,
        String muscle_group,
        String description,
        String difficulty)
{
    /**
     * Constructor to create an ExerciseResponseDTO from an Exercise entity.
     * This is used when converting an Exercise entity to a DTO for the response.
     *
     * @param exercise The Exercise entity to convert.
     */
    public ExerciseResponseDTO(Exercise exercise) {
        this(exercise.getId(), exercise.getName(), exercise.getMuscle_group(), exercise.getDescription(), exercise.getDifficulty());
    }
}
