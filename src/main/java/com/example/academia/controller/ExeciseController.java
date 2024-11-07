package com.example.academia.controller;

import com.example.academia.exception.ResourceNotFoundException;
import com.example.academia.exercise.Exercise;
import com.example.academia.exercise.ExerciseRepository;
import com.example.academia.exercise.ExerciseRequestDTO;
import com.example.academia.exercise.ExerciseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Exercise resources.
 * Provides endpoints for CRUD operations on Exercise entities.
 */

@RestController
@RequestMapping("exercise")
public class ExeciseController {

    @Autowired
    private ExerciseRepository repository;

    /**
     * Retrieves a list of all exercises.
     *
     * @return List of all exercises in the database, converted to ExerciseResponseDTO format.
     */
    @GetMapping
    public List<ExerciseResponseDTO> getAll() {
        List<ExerciseResponseDTO> exerciseList = repository.findAll()
                                                           .stream()
                                                           .map(ExerciseResponseDTO::new)
                                                           .toList();
        return exerciseList;
    }

    /**
     * Retrieves a single exercise by its ID.
     *
     * @param id ID of the exercise to retrieve.
     * @return The exercise data as an ExerciseResponseDTO.
     * @throws ResourceNotFoundException if the exercise with the specified ID does not exist.
     */
    @GetMapping("/{id}")
    public ExerciseResponseDTO getById(@PathVariable Long id) {
        Exercise data = repository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found."));
        ExerciseResponseDTO exerciseData = new ExerciseResponseDTO(data);
        return exerciseData;
    }

    /**
     * Creates a new exercise in the database.
     *
     * @param data Data of the exercise to be created, provided in the request body as an ExerciseRequestDTO.
     */
    @PostMapping
    public void saveExercise(@RequestBody ExerciseRequestDTO data) {
        Exercise exerciseData = new Exercise(data);
        repository.save(exerciseData);
        return;
    }

    /**
     * Updates an existing exercise.
     *
     * @param id   ID of the exercise to update.
     * @param data Updated exercise data provided in the request body as an ExerciseRequestDTO.
     * @throws ResourceNotFoundException if the exercise with the specified ID does not exist.
     */
    @PutMapping("/{id}")
    public void updateExercise(@PathVariable Long id, @RequestBody ExerciseRequestDTO data) {
        Exercise existingExercise = repository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found."));
        existingExercise.setName(data.name());
        existingExercise.setMuscle_group(data.muscle_group());
        existingExercise.setDescription(data.description());
        existingExercise.setDifficulty(data.difficulty());
        repository.save(existingExercise);
        return;
    }

    /**
     * Deletes an exercise by its ID.
     *
     * @param id ID of the exercise to delete.
     * @throws ResourceNotFoundException if the exercise with the specified ID does not exist.
     */
    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id) {
        repository.deleteById(id);
        return;
    }
}