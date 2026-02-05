package com.example.hrms_platform_document.repository;


import com.example.hrms_platform_document.entity.DocumentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentAuditRepository extends JpaRepository<DocumentAudit, Long> {

    List<DocumentAudit> findByDocumentDocumentIdOrderByPerformedAtDesc(Long documentId);
}
