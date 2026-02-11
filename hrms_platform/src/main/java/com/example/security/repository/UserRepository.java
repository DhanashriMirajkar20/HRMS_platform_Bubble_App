package com.example.security.repository;

import com.example.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
<<<<<<< HEAD
=======
    Optional<User> findByUsernameIgnoreCase(String username);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    boolean existsByUsername(String username);

    Optional<User> findByResetToken(String resetToken);

<<<<<<< HEAD

    @Query(value = "SELECT nextval('employee_id_seq')", nativeQuery = true)
    Long getNextEmployeeId();

    Optional<User> findByEmployeeId(Long employeeId);
=======
    void deleteByEmployeeId(Long employeeId);

    @Query("""
            select distinct u
            from User u
            join u.roles r
            where r.name like 'ROLE_HR%' or r.name = 'ROLE_TALENT_ACQUISITION'
            """)
    List<User> findAllWithHrRole();


>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}


