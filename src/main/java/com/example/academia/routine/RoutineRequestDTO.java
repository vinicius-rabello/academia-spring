package com.example.academia.routine;

/**
 * Data Transfer Object (DTO) representing a routine request.
 * This DTO is used to transfer routine data from the client to the server.
 * It contains fields for the name, muscle group, description, and difficulty of the routine.
 */
public record RoutineRequestDTO(
        Long created_by,
        String name)
{
}
