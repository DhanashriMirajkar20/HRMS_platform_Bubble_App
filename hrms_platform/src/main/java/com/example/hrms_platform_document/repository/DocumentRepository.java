package com.example.hrms_platform_document.repository;


<<<<<<< HEAD
import com.example.EmployeeManagement.Model.Employee;
import com.example.hrms_platform_document.entity.Document;
import com.example.hrms_platform_document.enums.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
=======
import com.example.hrms_platform_document.entity.Document;
import com.example.hrms_platform_document.enums.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByEmployeeEmployeeId(Long employeeId);

    List<Document> findByStatus(DocumentStatus status);

<<<<<<< HEAD
    List<Document> findByEmployee(Employee employee);
=======
    long countByStatus(DocumentStatus status);

    List<Document> findByUploadedByEmployeeId(Long employeeId);

    List<Document> findByApprovedByEmployeeId(Long employeeId);

    void deleteByEmployeeEmployeeId(Long employeeId);

    void deleteByUploadedByEmployeeId(Long employeeId);

    @Modifying
    @Query("update Document d set d.approvedBy = null where d.approvedBy.employeeId = :employeeId")
    void clearApprovedByEmployeeId(@Param("employeeId") Long employeeId);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}

