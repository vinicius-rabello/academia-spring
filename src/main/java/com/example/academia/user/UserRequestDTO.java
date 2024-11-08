package com.example.academia.user;

/**
 * Data Transfer Object (DTO) representing a user request.
 * This DTO is used to transfer user data from the client to the server.
 * It contains fields for the username, email and hash password.
 */
public record UserRequestDTO(
        String username,
        String email,
        String hash_password)
{
}
