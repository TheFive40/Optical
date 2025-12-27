package com.optical.net.staff.application;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;

public interface StaffCase {
    AdminDomain registerAdmin(AdminDomain staffDomain);
    SellerDomain registerSeller(SellerDomain sellerDomain);
    OptometristDomain registerOptometrist(OptometristDomain optometristDomain);
}
