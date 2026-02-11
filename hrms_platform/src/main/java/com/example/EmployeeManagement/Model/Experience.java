package com.example.EmployeeManagement.Model;


<<<<<<< HEAD
import com.example.EmployeeManagement.audit.entity.AuditableEntity;
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "experience")
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true,
        callSuper = false
)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "experienceId")

public class Experience extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
=======
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "experienceId")

public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private Long experienceId;

    // FK → employee.employee_id (Phase-1: keep flat)
//    private Long employeeId;

    private String company;
    private String designation;

    private LocalDate fromDate;
    private LocalDate toDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonIgnore
//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

