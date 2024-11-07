package com.example.academia.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the Exercise entity.
 * This interface extends JpaRepository, providing CRUD operations and basic database queries for Exercise.
 */
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
