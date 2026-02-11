package com.example.security.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
<<<<<<< HEAD
=======

    // Optional: link this login to an Employee record
    private Long employeeId;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}

