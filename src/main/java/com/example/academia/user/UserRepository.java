package com.example.academia.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the User entity.
 * This interface extends JpaRepository, providing CRUD operations and basic database queries for User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
