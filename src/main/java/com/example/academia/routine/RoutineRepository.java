package com.example.academia.routine;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the Routine entity.
 * This interface extends JpaRepository, providing CRUD operations and basic database queries for Routine.
 */
public interface RoutineRepository extends JpaRepository<Routine, Long> {
}
