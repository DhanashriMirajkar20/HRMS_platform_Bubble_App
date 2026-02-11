package com.example.EmployeeManagement.Model;

<<<<<<< HEAD
import com.example.EmployeeManagement.audit.entity.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

import java.time.LocalDateTime;


<<<<<<< HEAD
@Entity
@Table(name = "employee_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true,
        callSuper = false
)
public class EmployeeAddress extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long addressId;

=======
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_address")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "addressId")

public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

//    include employee_id to establish relation

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    private String houseNumber;
    private String country;
    private String state;
    private String city;
    private String street;
    private String pincode;
    private String landmark;

    private Boolean isPermanent;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonIgnore
<<<<<<< HEAD
=======
//    @JsonBackReference
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
