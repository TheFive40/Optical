package com.optical.net.staff.infrastructure.persistence.optometrist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptometristRepository extends CrudRepository<OptometristStaff, Long> {
}
