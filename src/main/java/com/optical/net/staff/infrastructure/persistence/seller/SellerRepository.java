package com.optical.net.staff.infrastructure.persistence.seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
    List<Seller> findByUsername(String username);
}
