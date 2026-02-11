package com.example.EmployeeManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeCreateResponse {

    private Long employeeId;
    private String username;
<<<<<<< HEAD
    private String status;
=======
    private String tempPassword;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}

