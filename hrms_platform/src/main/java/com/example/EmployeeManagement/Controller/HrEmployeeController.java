package com.example.EmployeeManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagement.DTO.EmployeeCreateResponse;
import com.example.EmployeeManagement.DTO.EmployeeDTO;
import com.example.EmployeeManagement.Model.Employee;
import com.example.EmployeeManagement.Service.EmployeeService;
import com.example.security.dto.RegisterRequest;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import com.example.security.service.EmailService;
import com.example.security.service.UserService;
import com.example.security.util.PasswordGenerator;
import com.example.notifications.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/hr/employees")
@RequiredArgsConstructor
public class HrEmployeeController {

    private final EmployeeService employeeService;
    private final UserRepository userRepository;

    private final  UserService userService;
    private final  PasswordGenerator passwordGenerator;
    private final EmailService emailService;
    private final NotificationService notificationService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_HR','ROLE_HR_MANAGER','ROLE_HR_OPERATIONS', 'ROLE_HR_PAYROLL', 'ROLE_HR_BP', 'ROLE_TALENT_ACQUISITION','ROLE_ADMIN') or @securityUtil.isHrUser()")
    public ResponseEntity<EmployeeCreateResponse> createEmployee(
            @RequestBody EmployeeDTO dto) {

        String hrUsername = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User hrUser = userRepository.findByUsername(hrUsername)
                .orElseThrow(() -> new RuntimeException("HR not found"));

        //  Save Employee
        Employee employee = employeeService.toEntity(dto, hrUser.getId());
        EmployeeDTO savedEmployee = employeeService.addEmployee(employee);

        //  Create Employee Login: use HR-provided temp password or auto-generate
        String tempPassword = (dto.getTempPassword() != null && !dto.getTempPassword().isBlank())
                ? dto.getTempPassword()
                : passwordGenerator.generateTempPassword();

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(savedEmployee.getCompanyEmail());
        registerRequest.setPassword(tempPassword);
        registerRequest.setEmployeeId(savedEmployee.getEmployeeId());

        userService.registerNewUser(registerRequest);

        // Send credentials to personal email if provided
        if (dto.getPersonalEmail() != null && !dto.getPersonalEmail().isBlank()) {
            emailService.sendEmployeeOnboardingEmail(
                    dto.getPersonalEmail().trim(),
                    savedEmployee.getCompanyEmail(),
                    tempPassword
            );
        }

        // Return credentials
        String fullName = (savedEmployee.getFirstName() + " " + savedEmployee.getLastName()).trim();
        String displayName = fullName.isBlank() ? savedEmployee.getCompanyEmail() : fullName;
        String message = "Employee " + displayName + " (ID: " + savedEmployee.getEmployeeId() + ") was created.";
        notificationService.create("Employee created", message, "EMPLOYEE_CREATED", "HR");
        notificationService.create("Employee created", message, "EMPLOYEE_CREATED", "ADMIN");

        return ResponseEntity.ok(
                new EmployeeCreateResponse(
                        savedEmployee.getEmployeeId(),
                        savedEmployee.getCompanyEmail(),
                        tempPassword
                )
        );
    }

}


