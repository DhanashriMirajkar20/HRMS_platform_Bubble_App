package com.example.hrms_platform_document.service;

import com.example.EmployeeManagement.Model.Employee;
import com.example.hrms_platform_document.entity.Document;
import com.example.hrms_platform_document.entity.DocumentAccessLog;
import com.example.hrms_platform_document.enums.DocumentAccessAction;
import com.example.hrms_platform_document.repository.DocumentAccessLogRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentAccessLogService {

    private final DocumentAccessLogRepository logRepository;

    public DocumentAccessLogService(DocumentAccessLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void logAccess(
            Document document,
            Employee employee,
            DocumentAccessAction action,
            String ipAddress
    ) {
        DocumentAccessLog log = new DocumentAccessLog();
        log.setDocument(document);
        log.setEmployee(employee);
        log.setAction(action);
        log.setIpAddress(ipAddress);

        logRepository.save(log);
    }
}
