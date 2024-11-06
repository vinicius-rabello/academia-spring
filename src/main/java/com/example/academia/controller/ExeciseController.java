package com.example.academia.controller;

import com.example.academia.exercise.Exercise;
import com.example.academia.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exercise")
public class ExeciseController {

    @Autowired
    private ExerciseRepository repository;

    @GetMapping
    public List<Exercise> getAll() {
        List<Exercise> exerciseList = repository.findAll();
        return exerciseList;
    }
}