package com.example.hrms_platform_document.service;

<<<<<<< HEAD
import com.example.EmployeeManagement.Model.Employee;
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import com.example.hrms_platform_document.entity.Document;
import com.example.hrms_platform_document.entity.DocumentAccessLog;
import com.example.hrms_platform_document.enums.DocumentAccessAction;
import com.example.hrms_platform_document.repository.DocumentAccessLogRepository;
<<<<<<< HEAD
=======
import com.example.security.util.SecurityUtil;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.stereotype.Service;

@Service
public class DocumentAccessLogService {

    private final DocumentAccessLogRepository logRepository;
<<<<<<< HEAD

    public DocumentAccessLogService(DocumentAccessLogRepository logRepository) {
        this.logRepository = logRepository;
=======
    private final SecurityUtil securityUtil;

    public DocumentAccessLogService(
            DocumentAccessLogRepository logRepository,
            SecurityUtil securityUtil
    ) {
        this.logRepository = logRepository;
        this.securityUtil = securityUtil;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    }

    public void logAccess(
            Document document,
<<<<<<< HEAD
            Employee employee,
            DocumentAccessAction action,
            String ipAddress
    ) {
=======
            DocumentAccessAction action,
            String ipAddress
    ) {
        var employee = securityUtil.getLoggedInEmployee();
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        DocumentAccessLog log = new DocumentAccessLog();
        log.setDocument(document);
        log.setEmployee(employee);
        log.setAction(action);
        log.setIpAddress(ipAddress);

        logRepository.save(log);
    }
<<<<<<< HEAD
=======

    public void deleteByDocumentId(Long documentId) {
        logRepository.deleteByDocumentDocumentId(documentId);
        logRepository.flush();
    }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
