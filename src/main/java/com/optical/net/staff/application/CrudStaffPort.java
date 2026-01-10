package com.optical.net.staff.application;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.domain.StaffDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudStaffPort {

    AdminDomain registerAdmin(AdminDomain admin);

    SellerDomain registerSeller(SellerDomain sellerDomain);

    OptometristDomain registerOptometrist(OptometristDomain optometristDomain);

    StaffDomain findStaff(Long id);
    AdminDomain findAdmin(Long id);
    OptometristDomain findOptometrist(Long id);
    SellerDomain findSeller(Long id);

    StaffDomain findByEmail(String email);

    List<OptometristDomain> readAllOptometrist();
    List<SellerDomain> readAllSeller();
    List<AdminDomain> readAllAdmin();
    List<StaffDomain> readAllStaffs();

    void deleteStaff(Long id);

}
