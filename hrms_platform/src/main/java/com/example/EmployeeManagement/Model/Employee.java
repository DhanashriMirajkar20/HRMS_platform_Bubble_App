
package com.example.EmployeeManagement.Model;

<<<<<<< HEAD
import com.example.EmployeeManagement.audit.entity.AuditableEntity;
import com.example.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
=======
import com.example.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

<<<<<<< HEAD
@Entity
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true,
        callSuper = false
)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends AuditableEntity {

//    private Long dummy_id;
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_generator"
    )
    @SequenceGenerator(
            name = "employee_id_generator",
            sequenceName = "employee_id_seq",
            allocationSize = 1
    )
    @Column(name = "employee_id")
=======
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeId")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String companyEmail;
    private LocalDate dateOfJoining;
    private String status;
    private String employeeType;
    private Long phoneNumber;
    private String currentBand;
    private double currentExperience;
    private String designation;
    private int ctc;
    private String department;

<<<<<<< HEAD
    @Column(name = "created_by_hr_user_id", nullable = false)
    private Long createdByHrUserId;

=======
//    relation yet to establish
    @Column(name = "created_by_hr_user_id", nullable = false)
    private Long createdByHrUserId;


    @Column(columnDefinition = "BYTEA")
    private byte[] photo;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonIgnore
<<<<<<< HEAD
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeePersonal employeePersonal;

    @JsonIgnore
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;

    @JsonIgnore
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private JobDetails jobDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeAddress> employeeAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeEducation> employeeEducations;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeSkill> employeeSkills;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeBand> employeeBands;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeManagerHistory> employeeManagerHistories;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmploymentContract> employmentContracts;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeEmergency> employeeEmergencies;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
=======
//    @JsonManagedReference
    @OneToOne(mappedBy = "employee" ,
              cascade = CascadeType.ALL)
    private EmployeePersonal employeePersonal;

    @JsonIgnore
//    @JsonManagedReference
    @OneToOne(mappedBy = "employee" ,
              cascade = CascadeType.ALL)
    private Account account;

    @JsonIgnore
//    @JsonManagedReference
    @OneToOne(mappedBy = "employee" ,
              cascade = CascadeType.ALL)
    private JobDetails jobDetails;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
               cascade = CascadeType.ALL ,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private Set<EmployeeAddress> employeeAddress;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
               cascade = CascadeType.ALL ,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private Set<EmployeeEducation> employeeEducations;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
               cascade = CascadeType.ALL ,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private Set<EmployeeSkill> employeeSkills;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
               cascade = CascadeType.ALL ,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private Set<EmployeeBand> employeeBands;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
              cascade = CascadeType.ALL ,
              orphanRemoval = true,
              fetch = FetchType.LAZY)
    private Set<EmployeeManagerHistory> employeeManagerHistories;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<EmploymentContract> employmentContracts;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<EmployeeEmergency> employeeEmergencies;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "employee" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private Set<Experience> employeeExperiences;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

<<<<<<< HEAD
=======
    //    current manager of the employee
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

<<<<<<< HEAD
    @JsonIgnore
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
=======
//    Set of employees who are reporting to this employee
    @JsonIgnore
    @OneToMany(mappedBy = "manager",
               fetch = FetchType.LAZY)
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private Set<Employee> subordinates;
}
