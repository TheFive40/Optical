package com.optical.net.staff.application;

import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.domain.StaffDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StaffCaseAdapter implements StaffCase {


    private final CrudStaffPort crudStaffPort;

    public StaffCaseAdapter(CrudStaffPort crudStaffPort) {
        this.crudStaffPort = crudStaffPort;
    }

    @Override
    public AdminDomain registerAdmin(AdminDomain staffDomain) {

        return crudStaffPort.registerAdmin(staffDomain);
    }

    @Override
    public SellerDomain registerSeller(SellerDomain sellerDomain) {
        return crudStaffPort.registerSeller(sellerDomain);
    }

    @Override
    public OptometristDomain registerOptometrist(OptometristDomain optometristDomain) {
        return crudStaffPort.registerOptometrist(optometristDomain);
    }

    @Override
    public List<OptometristDomain> readAllOptometrist() {
        return crudStaffPort.readAllOptometrist();
    }

    @Override
    public List<SellerDomain> readAllSeller() {
        return crudStaffPort.readAllSeller();
    }

    @Override
    public List<AdminDomain> readAllAdmin() {
        return crudStaffPort.readAllAdmin();
    }

    @Override
    public List<StaffDomain> readAllStaff() {
        return crudStaffPort.readAllStaffs();
    }

    @Override
    public StaffDomain findByEmail(String email) {
        return crudStaffPort.findByEmail(email);
    }

    @Override
    public StaffDomain findStaff(Long id) {
        return crudStaffPort.findStaff(id);
    }

    @Override
    public AdminDomain findAdmin(Long id) {
        return crudStaffPort.findAdmin(id);
    }

    @Override
    public OptometristDomain findOptometrist(Long id) {
        return crudStaffPort.findOptometrist(id);
    }

    @Override
    public SellerDomain findSeller(Long id) {
        return crudStaffPort.findSeller(id);
    }

    @Override
    public boolean validateCredentials(String email, String password) {
        var domain = crudStaffPort.findByEmail(email);
        return domain != null && domain.password().equals(password);
    }
}
