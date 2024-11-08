package com.example.academia.routine;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents an Routine entity in the system.
 * This class is mapped to the "routines" table in the database and contains
 * attributes related to an routine, such as its name and who created it.
 * It also includes a constructor for creating an routine from an RoutineRequestDTO object.
 */
@Table(name = "routines")
@Entity(name = "routines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Routine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long created_by;
    private String name;

    /**
     * Constructor to create a new Routine instance from an RoutineRequestDTO.
     * This constructor allows for creating a Routine entity from the data
     * provided in a request body when creating or updating a routine.
     *
     * @param data The RoutineRequestDTO containing the data for the new routine.
     */
    public Routine(RoutineRequestDTO data) {
        this.created_by = data.created_by();
        this.name = data.name();
    }
}
