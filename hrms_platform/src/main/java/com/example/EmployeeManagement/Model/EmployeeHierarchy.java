package com.example.EmployeeManagement.Model;


<<<<<<< HEAD
import com.example.EmployeeManagement.audit.entity.AuditableEntity;
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_hierarchy")
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
=======
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "hierarchyId"
//)

<<<<<<< HEAD
public class EmployeeHierarchy extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
=======
public class EmployeeHierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private Long hierarchyId;

    // FK → employee.employee_id (manager)
    private Long managerId;

    private String level;          // L1, L2, L3 or Reporting Level

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}

