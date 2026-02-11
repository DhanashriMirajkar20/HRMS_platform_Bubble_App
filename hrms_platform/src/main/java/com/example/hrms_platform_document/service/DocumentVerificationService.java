package com.example.hrms_platform_document.service;


import com.example.EmployeeManagement.Model.Employee;
import com.example.hrms_platform_document.entity.Document;
import com.example.hrms_platform_document.entity.DocumentVersion;
import com.example.hrms_platform_document.enums.DocumentAuditAction;
import com.example.hrms_platform_document.enums.DocumentStatus;
import com.example.hrms_platform_document.exception.DocumentNotFoundException;
import com.example.hrms_platform_document.exception.InvalidDocumentStateException;
import com.example.hrms_platform_document.repository.DocumentRepository;
import com.example.hrms_platform_document.service.storage.StorageService;
<<<<<<< HEAD
=======
import com.example.security.util.SecurityUtil;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentVerificationService {

    private final DocumentRepository documentRepository;
    private final StorageService storageService;
    private final DocumentAuditService auditService;
<<<<<<< HEAD
=======
    private final SecurityUtil securityUtil;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    public DocumentVerificationService(
            DocumentRepository documentRepository,
            StorageService storageService,
<<<<<<< HEAD
            DocumentAuditService auditService
=======
            DocumentAuditService auditService,
            SecurityUtil securityUtil
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    ) {
        this.documentRepository = documentRepository;
        this.storageService = storageService;
        this.auditService = auditService;
<<<<<<< HEAD
=======
        this.securityUtil = securityUtil;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    }

    /**
     * APPROVE document
     */
    @Transactional
    public void verifyDocument(Long documentId, Employee verifier) {

<<<<<<< HEAD
        System.out.println("**************VERIFY START******************");

        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new DocumentNotFoundException(documentId));

        System.out.println("DOCUMENT FOUND: " + document.getDocumentId());
=======
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new DocumentNotFoundException(documentId));

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

        if (document.getStatus() != DocumentStatus.PENDING_VERIFICATION) {
            throw new InvalidDocumentStateException(
                    "Only PENDING documents can be verified"
            );
        }

<<<<<<< HEAD

        DocumentVersion version = document.getCurrentVersion();
        System.out.println("VERSION OBJECT: " + version);
=======
        DocumentVersion version = document.getCurrentVersion();
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

        // 1️⃣ Build verified S3 key
        String verifiedKey = buildVerifiedKey(
                document.getEmployee().getEmployeeId(),
                document.getDocumentId(),
                version.getVersionNumber()
        );

<<<<<<< HEAD
        System.out.println("TARGET KEY: " + verifiedKey);

=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        // 2️⃣ Move file in S3 (staging → verified)
        storageService.moveToVerified(version.getS3Key(), verifiedKey);

        // 3️⃣ Update version with verified key
        version.setS3Key(verifiedKey);

        // 4️⃣ Update document status
        document.setStatus(DocumentStatus.VERIFIED);
        document.setApprovedBy(verifier);

        documentRepository.save(document);

        // 5️⃣ Audit
        auditService.log(
                document,
                version,
                DocumentAuditAction.VERIFY,
                verifier,
                "Document verified successfully"
        );
<<<<<<< HEAD

        System.out.println("*******************VERIFY END************************");
=======
    }

    /**
     * APPROVE document (logged-in employee)
     */
    @Transactional
    public void verifyDocument(Long documentId) {
        Employee verifier = securityUtil.getLoggedInEmployee();
        verifyDocument(documentId, verifier);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    }

    /**
     * REJECT document
     */
    @Transactional
    public void rejectDocument(
            Long documentId,
            Employee verifier,
            String reason
    ) {

        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        if (document.getStatus() != DocumentStatus.PENDING_VERIFICATION) {
            throw new IllegalStateException(
                    "Only PENDING documents can be rejected"
            );
        }

        document.setStatus(DocumentStatus.REJECTED);
        document.setApprovedBy(verifier);

        documentRepository.save(document);

        auditService.log(
                document,
                document.getCurrentVersion(),
                DocumentAuditAction.REJECT,
                verifier,
                reason
        );
    }

<<<<<<< HEAD
=======
    /**
     * REJECT document (logged-in employee)
     */
    @Transactional
    public void rejectDocument(Long documentId, String reason) {
        Employee verifier = securityUtil.getLoggedInEmployee();
        rejectDocument(documentId, verifier, reason);
    }

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private String buildVerifiedKey(
            Long employeeId,
            Long documentId,
            Integer version
    ) {
        return "verified/employee/"
                + employeeId + "/"
                + documentId + "/v" + version;
    }
}
