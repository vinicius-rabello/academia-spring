package com.example.academia.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String hash_password;

    /**
     * Constructor to create a new User instance from an UserRequestDTO.
     * This constructor allows for creating a User entity from the data
     * provided in a request body when creating or updating a user.
     *
     * @param data The UserRequestDTO containing the data for the new user.
     */
    public User(UserRequestDTO data) {
        this.username = data.username();
        this.email = data.email();
        this.hash_password = data.hash_password();
    }
}
