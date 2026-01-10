package com.optical.net.staff.application;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.domain.StaffDomain;
import com.optical.net.staff.infrastructure.persistence.admin.Admin;

import java.util.List;

public interface StaffCase {

    AdminDomain registerAdmin(AdminDomain staffDomain);
    SellerDomain registerSeller(SellerDomain sellerDomain);
    OptometristDomain registerOptometrist(OptometristDomain optometristDomain);
    List<OptometristDomain> readAllOptometrist();
    List<SellerDomain> readAllSeller();
    List<AdminDomain> readAllAdmin();
    List<StaffDomain> readAllStaff();
    StaffDomain findByEmail(String email);
    StaffDomain findStaff(Long id);
    AdminDomain findAdmin(Long id);
    OptometristDomain findOptometrist(Long id);
    SellerDomain findSeller(Long id);

    boolean validateCredentials(String email, String password);
}
