package com.example.security.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {

    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;
<<<<<<< HEAD

    @NotBlank
    private String confirmNewPassword;
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}

