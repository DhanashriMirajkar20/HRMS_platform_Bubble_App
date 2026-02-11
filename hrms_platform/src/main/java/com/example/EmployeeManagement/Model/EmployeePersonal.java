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
<<<<<<< HEAD
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

import java.time.LocalDate;
import java.time.LocalDateTime;


<<<<<<< HEAD
=======
@Data
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_personal")
<<<<<<< HEAD
@Getter
@Setter
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true,
        callSuper = false
)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personalId")

public class EmployeePersonal extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
=======
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personalId")

public class EmployeePersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private Long personalId;

//    private Long employeeId;     // FK but as plain field
    private LocalDate dob;
    private String gender;
    private String bloodGroup;
    private String nationality;
    private String maritalStatus;
    private String fatherName;
    private String spouseName;

    private String personalMail;
    private String alternatePhoneNumber;

    private Long approvedBy;     // employee_id of the approver


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonIgnore
//    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id" , unique = true)
    private Employee employee;
}
