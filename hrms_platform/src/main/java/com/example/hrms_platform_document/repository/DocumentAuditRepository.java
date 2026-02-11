package com.example.hrms_platform_document.repository;


import com.example.hrms_platform_document.entity.DocumentAudit;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
=======
import com.example.hrms_platform_document.enums.DocumentAuditAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

public interface DocumentAuditRepository extends JpaRepository<DocumentAudit, Long> {

    List<DocumentAudit> findByDocumentDocumentIdOrderByPerformedAtDesc(Long documentId);
<<<<<<< HEAD
=======

    Optional<DocumentAudit> findTopByDocumentDocumentIdOrderByPerformedAtDesc(Long documentId);

    Optional<DocumentAudit> findTopByDocumentDocumentIdAndActionOrderByPerformedAtDesc(
            Long documentId,
            DocumentAuditAction action
    );

    void deleteByDocumentDocumentId(Long documentId);

    void deleteByPerformedByEmployeeId(Long employeeId);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
