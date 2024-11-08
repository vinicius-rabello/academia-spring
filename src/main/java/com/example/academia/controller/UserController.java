package com.example.academia.controller;

import com.example.academia.exception.ResourceNotFoundException;
import com.example.academia.user.User;
import com.example.academia.user.UserRepository;
import com.example.academia.user.UserRequestDTO;
import com.example.academia.user.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing User resources.
 * Provides endpoints for CRUD operations on User entities.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    /**
     * Retrieves a list of all users.
     *
     * @return List of all users in the database, converted to UserResponseDTO format.
     */
    @GetMapping
    public List<UserResponseDTO> getAll() {
        List<UserResponseDTO> userList = repository.findAll()
                                                         .stream()
                                                         .map(UserResponseDTO::new)
                                                         .toList();
        return userList;
    }

    /**
     * Retrieves a single user by its ID.
     *
     * @param id ID of the user to retrieve.
     * @return The user data as an UserResponseDTO.
     * @throws ResourceNotFoundException if the user with the specified ID does not exist.
     */
    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        User data = repository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found."));
        UserResponseDTO userData = new UserResponseDTO(data);
        return userData;
    }

    /**
     * Creates a new user in the database.
     *
     * @param data Data of the user to be created, provided in the request body as an UserRequestDTO.
     */
    @PostMapping
    public void saveUser(@RequestBody UserRequestDTO data) {
        User userData = new User(data);
        repository.save(userData);
        return;
    }

    /**
     * Updates an existing user.
     *
     * @param id   ID of the user to update.
     * @param data Updated user data provided in the request body as an UserRequestDTO.
     * @throws ResourceNotFoundException if the user with the specified ID does not exist.
     */
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserRequestDTO data) {
        User existingUser = repository.findById(id)
                                            .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found."));
        existingUser.setUsername(data.username());
        existingUser.setEmail(data.email());
        existingUser.setHash_password(data.hash_password());
        repository.save(existingUser);
        return;
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id ID of the user to delete.
     * @throws ResourceNotFoundException if the user with the specified ID does not exist.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
        return;
    }
}