package com.example.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.constants.RoleConstants;
import com.example.security.dto.CreateHrRequest;
import com.example.security.dto.HrListResponse;
import com.example.security.dto.UpdateHrRequest;
import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminHrService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createHr(CreateHrRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Mandatory EMPLOYEE role
        Role employeeRole = roleRepository.findByName(RoleConstants.ROLE_EMPLOYEE)
                .orElseThrow(() -> new RuntimeException("ROLE_EMPLOYEE not found"));

        // HR role validation
        Role hrRole = roleRepository.findByName(request.getHrRole())
                .orElseThrow(() -> new RuntimeException("Invalid HR role"));

        if (!request.getHrRole().startsWith("ROLE_HR") && !RoleConstants.ROLE_TALENT_ACQUISITION.equals(request.getHrRole())) {
            throw new IllegalArgumentException("Invalid HR role assignment");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(employeeRole);
        roles.add(hrRole);

        User hrUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getTempPassword()))
                .enabled(true)
                .roles(roles)
                .mustChangePassword(true)
                .build();

        return userRepository.save(hrUser);
    }

    public List<HrListResponse> getAllHrUsers() {
        return userRepository.findAllWithHrRole().stream()
                .map(u -> new HrListResponse(
                        u.getId(),
                        u.getUsername(),
                        u.isEnabled(),
                        u.getRoles().stream().map(Role::getName).collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());
    }

    public HrListResponse getHrById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HR user not found"));
        return new HrListResponse(
                user.getId(),
                user.getUsername(),
                user.isEnabled(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet())
        );
    }

    @Transactional
    public HrListResponse updateHr(UpdateHrRequest request) {
        if (request.getId() == null) {
            throw new IllegalArgumentException("HR id is required");
        }
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("HR user not found"));

        if (request.getEnabled() != null) {
            user.setEnabled(request.getEnabled());
        }

        if (request.getHrRole() != null && !request.getHrRole().isBlank()) {
            String hrRoleName = request.getHrRole().trim();
            if (!hrRoleName.startsWith("ROLE_HR") &&
                    !RoleConstants.ROLE_TALENT_ACQUISITION.equals(hrRoleName)) {
                throw new IllegalArgumentException("Invalid HR role assignment");
            }

            Role employeeRole = roleRepository.findByName(RoleConstants.ROLE_EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("ROLE_EMPLOYEE not found"));

            Role hrRole = roleRepository.findByName(hrRoleName)
                    .orElseThrow(() -> new RuntimeException("Invalid HR role"));

            Set<Role> roles = new HashSet<>();
            roles.add(employeeRole);
            roles.add(hrRole);
            user.setRoles(roles);
        }

        User saved = userRepository.save(user);
        return new HrListResponse(
                saved.getId(),
                saved.getUsername(),
                saved.isEnabled(),
                saved.getRoles().stream().map(Role::getName).collect(Collectors.toSet())
        );
    }

    @Transactional
    public void deleteHr(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HR user not found"));
        boolean hasHrRole = user.getRoles().stream()
                .anyMatch(r -> r.getName().startsWith("ROLE_HR") || RoleConstants.ROLE_TALENT_ACQUISITION.equals(r.getName()));
        if (!hasHrRole) {
            throw new IllegalArgumentException("User is not an HR");
        }
        userRepository.delete(user);
    }
}


