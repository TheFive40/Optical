package com.optical.net.staff.application;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;

public interface RegisterStaffPort {
    AdminDomain registerAdmin(AdminDomain admin);

    SellerDomain registerSeller(SellerDomain sellerDomain);

    OptometristDomain registerOptometrist(OptometristDomain optometristDomain);

}
