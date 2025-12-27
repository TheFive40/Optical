package com.optical.net.staff.application;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import org.springframework.stereotype.Service;

@Service
public class StaffCaseAdapter implements StaffCase {

    private RegisterStaffPort registerStaffPort;

    @Override
    public AdminDomain registerAdmin(AdminDomain staffDomain) {

        return registerStaffPort.registerAdmin(staffDomain);
    }

    @Override
    public SellerDomain registerSeller(SellerDomain sellerDomain) {
        return registerStaffPort.registerSeller(sellerDomain);
    }

    @Override
    public OptometristDomain registerOptometrist(OptometristDomain optometristDomain) {
        return registerStaffPort.registerOptometrist(optometristDomain);
    }
}
