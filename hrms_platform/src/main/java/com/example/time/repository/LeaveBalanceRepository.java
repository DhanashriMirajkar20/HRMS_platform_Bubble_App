package com.example.time.repository;

import com.example.EmployeeManagement.Model.Employee;
import com.example.time.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

    Optional<LeaveBalance> findByEmployeeAndLeaveTypeId(Employee employee, Long leaveTypeId);

<<<<<<< HEAD
=======
    List<LeaveBalance> findByEmployee(Employee employee);

    void deleteByEmployeeEmployeeId(Long employeeId);

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
