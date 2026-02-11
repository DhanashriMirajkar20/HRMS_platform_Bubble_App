package com.example.hrms_platform_document.repository;


import com.example.hrms_platform_document.entity.DocumentAccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentAccessLogRepository extends JpaRepository<DocumentAccessLog, Long> {
<<<<<<< HEAD
=======

    void deleteByEmployeeEmployeeId(Long employeeId);

    void deleteByDocumentDocumentId(Long documentId);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
