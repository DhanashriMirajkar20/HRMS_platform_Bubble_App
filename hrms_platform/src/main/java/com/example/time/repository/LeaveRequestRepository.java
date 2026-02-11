package com.example.time.repository;

import com.example.time.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
=======
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByEmployee_Manager_EmployeeIdAndStatus(Long managerId, String status);

    long countByStatus(String status);

    List<LeaveRequest> findByStatus(String status);

    void deleteByEmployeeEmployeeId(Long employeeId);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
