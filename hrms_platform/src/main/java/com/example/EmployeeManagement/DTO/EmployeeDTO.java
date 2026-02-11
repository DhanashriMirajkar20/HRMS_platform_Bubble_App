package com.example.EmployeeManagement.DTO;


<<<<<<< HEAD
=======
import java.time.LocalDate;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.time.LocalDate;

=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String companyEmail;
<<<<<<< HEAD
=======
    private String personalEmail;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private String designation;
    private String status;
    private String currentBand;
    private String department;
    private String managerName;
<<<<<<< HEAD
=======
    private Long managerId;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private LocalDate dateOfJoining;
    private String employeeType;
    private Long phoneNumber;
    private double currentExperience;
    private int ctc;
<<<<<<< HEAD
=======

    /** Optional: temporary password for employee login. If null/blank, one is auto-generated. */
    private String tempPassword;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}


