package com.example.security.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
public class AuthRequest {
    private String username;
    private String password;

<<<<<<< HEAD

=======
    public AuthRequest() {}

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
