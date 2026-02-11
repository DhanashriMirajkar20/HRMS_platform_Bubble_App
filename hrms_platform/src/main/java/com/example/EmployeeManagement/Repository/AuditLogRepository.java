package com.example.EmployeeManagement.Repository;

<<<<<<< HEAD
//import com.example.EmployeeManagement.Model.AuditLog;
import com.example.EmployeeManagement.audit.entity.AuditLog;
=======
import com.example.EmployeeManagement.Model.AuditLog;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    @Query("""
        SELECT a
        FROM AuditLog a
        WHERE a.tableName = :tableName
    """)
    List<AuditLog> findByTableName(@Param("tableName") String tableName);

    @Query("""
        SELECT a
        FROM AuditLog a
        WHERE a.changedBy = :changedBy
    """)
    List<AuditLog> findByChangedBy(@Param("changedBy") Long changedBy);

    @Query("""
        SELECT a
        FROM AuditLog a
        WHERE a.approvalRequired = true
    """)
    List<AuditLog> findPendingApprovals();
}
