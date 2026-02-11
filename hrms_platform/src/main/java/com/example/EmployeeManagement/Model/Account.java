package com.example.EmployeeManagement.Model;


<<<<<<< HEAD
import com.example.EmployeeManagement.audit.entity.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "account")
<<<<<<< HEAD
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true,
        callSuper = false
)

public class Account extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long accountId;

=======
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    // FK → employee.employee_id (Phase-1: keep flat)
//    private Long employeeId;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private String accountNumber;
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String accountType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonIgnore
<<<<<<< HEAD
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;
}


=======
//    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id" , unique = true)
    private Employee employee;
}

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
