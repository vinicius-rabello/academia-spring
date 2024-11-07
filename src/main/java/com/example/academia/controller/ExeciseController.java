package com.example.academia.controller;

import com.example.academia.exercise.Exercise;
import com.example.academia.exercise.ExerciseRepository;
import com.example.academia.exercise.ExerciseRequestDTO;
import com.example.academia.exercise.ExerciseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("exercise")
public class ExeciseController {

    @Autowired
    private ExerciseRepository repository;

    @GetMapping
    public List<ExerciseResponseDTO> getAll() {
        List<ExerciseResponseDTO> exerciseList = repository.findAll()
                                                           .stream()
                                                           .map(ExerciseResponseDTO::new)
                                                           .toList();
        return exerciseList;
    }

    @PostMapping
    public void saveExercise(@RequestBody ExerciseRequestDTO data) {
        Exercise exerciseData = new Exercise(data);
        repository.save(exerciseData);
        return;
    }
}