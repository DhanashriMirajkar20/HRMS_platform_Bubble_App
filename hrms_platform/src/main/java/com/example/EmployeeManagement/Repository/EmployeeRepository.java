package com.example.EmployeeManagement.Repository;


import com.example.EmployeeManagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Modifying;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    find employee by partial name
//    List<Employee> findByNameContainingIgnoreCase(String name);

    @Query("""
    SELECT e
    FROM Employee e
    WHERE
        LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%'))
        OR
        LOWER(e.lastName) LIKE LOWER(CONCAT('%', :name, '%'))
        OR
        LOWER(CONCAT(e.firstName, ' ', e.lastName)) LIKE LOWER(CONCAT('%', :name, '%'))
    """)
    List<Employee> searchByFullName(@Param("name") String name);

    Optional<Employee> findByUserId(Long userId);

    List<Employee> findByManager_EmployeeId(Long managerId);

    Optional<Employee> findByCompanyEmail(String username);
<<<<<<< HEAD

    Optional<Employee> findByEmployeeId(Long employeeId);

    Optional<Employee> findByUser_Username(String username);

=======
    @Query("SELECT e FROM Employee e WHERE LOWER(e.companyEmail) = LOWER(:email)")
    Optional<Employee> findByCompanyEmailIgnoreCase(@Param("email") String email);

    long countByStatus(String status);

    long countByDateOfJoiningAfter(java.time.LocalDate date);

    @Modifying
    @Query("update Employee e set e.manager = null where e.manager.employeeId = :managerId")
    void clearManagerForSubordinates(@Param("managerId") Long managerId);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
