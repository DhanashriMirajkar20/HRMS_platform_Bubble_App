package com.example.EmployeeManagement.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogDTO {

    private Long auditId;

    private String tableName;
    private String fieldName;

    private String oldValue;
    private String newValue;

    private String actionType;

<<<<<<< HEAD
    private String changedBy;
=======
    private Long changedBy;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private LocalDateTime changedAt;

    private Boolean approvalRequired;
    private Long approvedBy;
    private LocalDateTime approvedAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
