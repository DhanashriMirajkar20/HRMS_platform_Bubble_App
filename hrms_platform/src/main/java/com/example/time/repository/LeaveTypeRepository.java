package com.example.time.repository;

import com.example.time.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
=======
import java.util.Optional;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    Optional<LeaveType> findByLeaveNameIgnoreCase(String leaveName);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
