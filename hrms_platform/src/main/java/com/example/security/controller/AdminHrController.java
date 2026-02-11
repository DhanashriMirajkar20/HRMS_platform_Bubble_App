package com.example.security.controller;

<<<<<<< HEAD
import com.example.EmployeeManagement.DTO.EmployeeCreateResponse;
import com.example.security.dto.CreateHrRequest;
import com.example.security.dto.CreateHrRequestDTO;
import com.example.security.service.AdminHrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
=======
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import com.example.security.dto.CreateHrRequest;
import com.example.security.dto.HrListResponse;
import com.example.security.dto.UpdateHrRequest;
import com.example.security.service.AdminHrService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
@RestController
@RequestMapping("/api/v1/admin/hr")
@RequiredArgsConstructor
public class AdminHrController {

    private final AdminHrService adminHrService;

<<<<<<< HEAD
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeCreateResponse> createHr(@Valid @RequestBody CreateHrRequestDTO request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("**************************************************************");
        System.out.println("AUTH NAME = " + auth.getName());
        System.out.println("AUTHORITIES = " + auth.getAuthorities());
        EmployeeCreateResponse response = adminHrService.createHr(request);
        return ResponseEntity.ok(response);
=======
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<HrListResponse>> getAllHr() {
        return ResponseEntity.ok(adminHrService.getAllHrUsers());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createHr(@Valid @RequestBody CreateHrRequest request) {
        adminHrService.createHr(request);
        return ResponseEntity.ok("HR created successfully");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HrListResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(adminHrService.getHrById(id));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HrListResponse> update(@RequestBody UpdateHrRequest request) {
        return ResponseEntity.ok(adminHrService.updateHr(request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteHr(@PathVariable Long id) {
        adminHrService.deleteHr(id);
        return ResponseEntity.noContent().build();
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    }
}

