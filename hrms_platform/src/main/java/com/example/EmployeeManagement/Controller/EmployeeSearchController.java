package com.example.EmployeeManagement.Controller;


import com.example.EmployeeManagement.DTO.EmployeeSearchDTO;
import com.example.EmployeeManagement.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeSearchController {

    private final EmployeeService employeeService;

    @PostMapping("/search")
    public ResponseEntity<List<EmployeeSearchDTO>> searchEmployees(
            @RequestBody EmployeeSearchDTO searchDTO) {

        List<EmployeeSearchDTO> result =
                employeeService.searchEmployees(searchDTO);

        return ResponseEntity.ok(result);
    }
}

