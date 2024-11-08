package com.example.academia.user;

/**
 * Data Transfer Object (DTO) representing a user response.
 * This DTO is used to send user data from the server to the client.
 * It includes the fields of a user along with its ID.
 */
public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String hash_password)
{
    /**
     * Constructor to create an UserResponseDTO from a User entity.
     * This is used when converting a User entity to a DTO for the response.
     *
     * @param user The User entity to convert.
     */
    public UserResponseDTO(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getHash_password());
    }
}
