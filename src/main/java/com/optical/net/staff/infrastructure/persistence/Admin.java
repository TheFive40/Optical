package com.optical.net.staff.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Staff {

    @Column(name = "access_level")
    private Integer accessLevel;

    @Column(name = "department", length = 100)
    private String department;

    @Override
    public String getStaffType() {
        return "ADMIN";
    }
}

