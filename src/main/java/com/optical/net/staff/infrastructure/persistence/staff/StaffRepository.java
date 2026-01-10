package com.optical.net.staff.infrastructure.persistence.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByEmail(String email);

    List<Staff> findByUsername(String username);
}
