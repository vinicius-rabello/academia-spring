package com.example.academia.controller;

import com.example.academia.exception.ResourceNotFoundException;
import com.example.academia.routine.Routine;
import com.example.academia.routine.RoutineRepository;
import com.example.academia.routine.RoutineRequestDTO;
import com.example.academia.routine.RoutineResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Routine resources.
 * Provides endpoints for CRUD operations on Routine entities.
 */

@RestController
@RequestMapping("routine")
public class RoutineController {

    @Autowired
    private RoutineRepository repository;

    /**
     * Retrieves a list of all routines.
     *
     * @return List of all routines in the database, converted to RoutineResponseDTO format.
     */
    @GetMapping
    public List<RoutineResponseDTO> getAll() {
        List<RoutineResponseDTO> routineList = repository.findAll()
                                                           .stream()
                                                           .map(RoutineResponseDTO::new)
                                                           .toList();
        return routineList;
    }

    /**
     * Retrieves a single routine by its ID.
     *
     * @param id ID of the routine to retrieve.
     * @return The routine data as an RoutineResponseDTO.
     * @throws ResourceNotFoundException if the routine with the specified ID does not exist.
     */
    @GetMapping("/{id}")
    public RoutineResponseDTO getById(@PathVariable Long id) {
        Routine data = repository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found."));
        RoutineResponseDTO routineData = new RoutineResponseDTO(data);
        return routineData;
    }

    /**
     * Creates a new routine in the database.
     *
     * @param data Data of the routine to be created, provided in the request body as an RoutineRequestDTO.
     */
    @PostMapping
    public void saveRoutine(@RequestBody RoutineRequestDTO data) {
        Routine routineData = new Routine(data);
        repository.save(routineData);
        return;
    }

    /**
     * Updates an existing routine.
     *
     * @param id   ID of the routine to update.
     * @param data Updated routine data provided in the request body as an RoutineRequestDTO.
     * @throws ResourceNotFoundException if the routine with the specified ID does not exist.
     */
    @PutMapping("/{id}")
    public void updateRoutine(@PathVariable Long id, @RequestBody RoutineRequestDTO data) {
        Routine existingRoutine = repository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found."));
        existingRoutine.setCreated_by(data.created_by());
        existingRoutine.setName(data.name());
        repository.save(existingRoutine);
        return;
    }

    /**
     * Deletes a routine by its ID.
     *
     * @param id ID of the routine to delete.
     * @throws ResourceNotFoundException if the routine with the specified ID does not exist.
     */
    @DeleteMapping("/{id}")
    public void deleteRoutine(@PathVariable Long id) {
        repository.deleteById(id);
        return;
    }
}