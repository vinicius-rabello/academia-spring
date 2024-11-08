package com.example.academia.routine;

/**
 * Data Transfer Object (DTO) representing a routine response.
 * This DTO is used to send routine data from the server to the client.
 * It includes the fields of a routine along with its ID.
 */
public record RoutineResponseDTO(
        Long id,
        Long created_by,
        String name)
{
    /**
     * Constructor to create an RoutineResponseDTO from a Routine entity.
     * This is used when converting a Routine entity to a DTO for the response.
     *
     * @param routine The Routine entity to convert.
     */
    public RoutineResponseDTO(Routine routine) {
        this(routine.getId(), routine.getCreated_by(), routine.getName());
    }
}
