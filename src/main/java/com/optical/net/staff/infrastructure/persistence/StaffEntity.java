package com.optical.net.staff.infrastructure.persistence;

import com.optical.net.recipe.infrastructure.persistence.Recipe;
import com.optical.net.role.infrastructure.persistence.RoleEntity;
import com.optical.net.sale.infrastructure.persistence.Sale;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private boolean accountNonExpired = true;

    @Column(nullable = false)
    private boolean accountNonLocked = true;

    @Column(nullable = false)
    private boolean credentialsNonExpired = true;

    @Column(nullable = false)
    private boolean enabled = true;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roleEntities;


    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private List<Sale> sales;

    @OneToMany(mappedBy = "optometrist", fetch = FetchType.LAZY)
    private List<Recipe> recipes;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }
}
