package com.example.EmployeeManagement.audit.listener;

import com.example.EmployeeManagement.Repository.AuditLogRepository;
import com.example.EmployeeManagement.Model.AuditLog;
import com.example.security.util.ApplicationContextProvider.ApplicationContextProvider;
import com.example.security.util.SecurityUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.time.LocalDateTime;

public class AuditEntityListener {

    private static AuditLogRepository auditLogRepository;

    // Called by Spring injector
    public static void setAuditLogRepository(AuditLogRepository repository) {
        auditLogRepository = repository;
    }

    @PrePersist
    public void onInsert(Object entity) {
        log(entity, "INSERT");
    }

    @PreUpdate
    public void onUpdate(Object entity) {
        log(entity, "UPDATE");
    }

    @PreRemove
    public void onDelete(Object entity) {
        log(entity, "DELETE");
    }

    private void log(Object entity, String action) {

        SecurityUtil securityUtil = ApplicationContextProvider.getApplicationContext()
                .getBean(SecurityUtil.class);
        Long changedBy = securityUtil.getApproverIdFallbackToUser();

        AuditLog audit = AuditLog.builder()
                .tableName(entity.getClass().getSimpleName())
                .actionType(action)
                .changedBy(changedBy)
                .changedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .oldValue(action.equals("UPDATE") ? "PREVIOUS_STATE" : null)
                .newValue(toJson(entity))
                .approvalRequired(false)
                .build();
        auditLogRepository.save(audit);
    }


    private String toJson(Object entity) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(entity);
        } catch (Exception e) {
            return null;
        }
    }

}
