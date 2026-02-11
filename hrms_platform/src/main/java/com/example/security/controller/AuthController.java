package com.example.security.controller;

import com.example.security.dto.*;
import com.example.security.jwt.JwtService;
import com.example.security.model.User;
<<<<<<< HEAD
import com.example.security.repository.UserRepository;
import com.example.security.service.UserService;
import jakarta.annotation.security.PermitAll;
=======
import com.example.security.model.Role;
import com.example.security.repository.UserRepository;
import com.example.security.service.UserService;
import com.example.EmployeeManagement.Repository.EmployeeRepository;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
<<<<<<< HEAD
=======
import java.util.stream.Collectors;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

<<<<<<< HEAD
=======
    @Autowired
    private EmployeeRepository employeeRepository;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    /**
     * Login endpoint: checks username/password and returns JWT
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

<<<<<<< HEAD
=======
        // Auto-link employee if missing before token generation
        user = userService.autoLinkEmployee(user);

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        String jwtToken = jwtService.generateToken(user);

        return ResponseEntity.ok(
                new AuthResponse(jwtToken, user.isMustChangePassword())
        );
    }

<<<<<<< HEAD
=======
    /**
     * Get profile for logged-in user
     */
    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> me(Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new BadCredentialsException("User not found"));

        user = userService.autoLinkEmployee(user);
        Long employeeId = user.getEmployeeId();

        UserProfileResponse profile = new UserProfileResponse(
                user.getUsername(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()),
                employeeId
        );

        return ResponseEntity.ok(profile);
    }

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    /**
     * Change password for logged-in user
     */
    @PostMapping("/me/password")
<<<<<<< HEAD
    @PermitAll
    public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordRequest request,
                                               Principal principal) {
        userService.changePassword(principal.getName(), request);
        return ResponseEntity.ok("Password updated");
=======
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request,
                                               Principal principal) {
        userService.changePassword(principal.getName(), request);
        return ResponseEntity.noContent().build();
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    }

    /**
     * Stateless JWT logout
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.noContent().build();
    }

<<<<<<< HEAD

    @PostMapping("/forgot-password")
    @PermitAll
=======
    @PostMapping("/forgot-password")
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    public ResponseEntity<String> forgotPassword(
            @RequestBody ForgotPasswordRequest request) {

        userService.generateResetToken(request.getUsername());
<<<<<<< HEAD
=======

        // Always return same response (security best practice)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        return ResponseEntity.ok(
                "If the account exists, a password reset email has been sent"
        );
    }


<<<<<<< HEAD

    @PostMapping("/reset-password")
    @PermitAll
    public ResponseEntity<String> resetPassword(
            @RequestBody ResetPasswordRequest request) {

        userService.resetPassword(request);
        return ResponseEntity.ok("Password reset successful");
=======
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestBody ResetPasswordRequest request) {
        try {
            userService.resetPassword(request);
            return ResponseEntity.ok("Password reset successful");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    }

}
