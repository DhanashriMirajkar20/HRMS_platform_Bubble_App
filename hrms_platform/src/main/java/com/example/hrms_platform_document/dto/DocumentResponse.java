package com.example.hrms_platform_document.dto;

import com.example.hrms_platform_document.enums.DocumentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentResponse {

    private Long documentId;
    private String documentType;
    private String documentName;
    private DocumentStatus status;
    private Integer currentVersion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
<<<<<<< HEAD
=======
    private String rejectionReason;
    private String approvalReason;
    private String statusMessage;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    // getters and setters
}
