package com.example.hrms_platform_document.controller;

import com.example.EmployeeManagement.Model.Employee;
import com.example.hrms_platform_document.dto.DocumentResponse;
import com.example.hrms_platform_document.entity.Document;
import com.example.hrms_platform_document.enums.DocumentAccessAction;
import com.example.hrms_platform_document.service.DocumentAccessLogService;
import com.example.hrms_platform_document.service.DocumentMapper;
import com.example.hrms_platform_document.service.DocumentService;
import com.example.hrms_platform_document.service.DocumentVerificationService;
import com.example.hrms_platform_document.service.storage.StorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final DocumentVerificationService verificationService;
    private final DocumentAccessLogService accessLogService;
    private final StorageService storageService;

    // TEMP dummy employee
    private Employee dummyEmployee() {
        Employee e = new Employee();
        e.setEmployeeId(1L);
        return e;
    }

    public DocumentController(
            DocumentService documentService,
            DocumentVerificationService verificationService,
            DocumentAccessLogService accessLogService,
            StorageService storageService
    ) {
        this.documentService = documentService;
        this.verificationService = verificationService;
        this.accessLogService = accessLogService;
        this.storageService = storageService;
    }

    // 1️⃣ Upload
    @PostMapping("/upload")
    public DocumentResponse upload(
            @RequestParam MultipartFile file,
            @RequestParam String documentType,
            @RequestParam String documentName
    ) {
        Document doc = documentService.uploadDocument(
                dummyEmployee(),
                file,
                documentType,
                documentName,
                false
        );
        return DocumentMapper.toResponse(doc);
    }


    // 2️⃣ Re-upload
    @PostMapping("/{id}/reupload")
    public Document reupload(
            @PathVariable Long id,
            @RequestParam MultipartFile file
    ) {
        return documentService.reuploadDocument(
                id,
                dummyEmployee(),
                file
        );
    }

    // 3️⃣ Verify
    @PostMapping("/{id}/verify")
    public void verify(@PathVariable Long id) {
        verificationService.verifyDocument(id, dummyEmployee());
    }

    // 4️⃣ Reject
    @PostMapping("/{id}/reject")
    public void reject(
            @PathVariable Long id,
            @RequestParam String reason
    ) {
        verificationService.rejectDocument(id, dummyEmployee(), reason);
    }

    // 5️⃣ Download
    @GetMapping("/{id}/download")
    public String download(
            @PathVariable Long id,
            @RequestHeader(value = "X-IP", required = false) String ip
    ) {
        Document doc = documentService.getDocumentById(id);

        accessLogService.logAccess(
                doc,
                dummyEmployee(),
                DocumentAccessAction.DOWNLOAD,
                ip != null ? ip : "UNKNOWN"
        );

        return storageService.generatePresignedUrl(
                doc.getCurrentVersion().getS3Key()
        );
    }

}
