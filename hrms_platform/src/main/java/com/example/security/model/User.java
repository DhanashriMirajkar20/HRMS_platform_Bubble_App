package com.example.security.model;

<<<<<<< HEAD
import com.example.EmployeeManagement.Model.Employee;
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled = true;

    // Link to employee (ownership checks)
<<<<<<< HEAD
    @Column(unique = true)
    private Long employeeId;



    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Employee employee;


=======
    @Column(name = "employee_id")
    private Long employeeId;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    // EMPLOYEE + optional ONE HR role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "must_change_password")
<<<<<<< HEAD
    private boolean mustChangePassword = false;
=======
    private Boolean mustChangePassword = false;
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "reset_token_expiry")
    private LocalDateTime resetTokenExpiry;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

<<<<<<< HEAD
    public boolean hasRole(String roleName) {
        return roles != null && roles.stream()
                .anyMatch(role -> roleName.equalsIgnoreCase(role.getName()));
    }

=======
    public boolean isMustChangePassword() {
        return Boolean.TRUE.equals(mustChangePassword);
    }
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
