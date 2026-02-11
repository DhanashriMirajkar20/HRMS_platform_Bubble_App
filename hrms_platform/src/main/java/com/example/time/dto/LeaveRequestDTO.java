package com.example.time.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestDTO {

<<<<<<< HEAD
=======
    private Long leaveRequestId;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private long employeeId;
    private long leaveTypeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int totalDays;
<<<<<<< HEAD
=======
    private String status;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

}
