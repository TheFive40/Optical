package com.optical.net.staff.infrastructure.persistence.ports;

import com.optical.net.staff.application.CrudStaffPort;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.domain.StaffDomain;
import com.optical.net.staff.infrastructure.mapper.AdminMapper;
import com.optical.net.staff.infrastructure.mapper.OptometristStaffMapper;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import com.optical.net.staff.infrastructure.mapper.StaffMapper;
import com.optical.net.staff.infrastructure.persistence.admin.AdminRepository;
import com.optical.net.staff.infrastructure.persistence.optometrist.OptometristRepository;
import com.optical.net.staff.infrastructure.persistence.seller.SellerRepository;
import com.optical.net.staff.infrastructure.persistence.staff.StaffRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CrudStaffPortAdapter implements CrudStaffPort {

    private final StaffRepository staffRepository;
    private final AdminMapper adminMapper;
    private final OptometristStaffMapper optometristStaffMapper;
    private final SellerStaffMapper sellerStaffMapper;
    private final OptometristRepository optometristRepository;
    private final SellerRepository sellerRepository;
    private final AdminRepository adminRepository;
    private final StaffMapper staffMapper;

    public CrudStaffPortAdapter(AdminMapper adminMapper, StaffRepository staffRepository, OptometristStaffMapper optometristStaffMapper, SellerStaffMapper sellerStaffMapper, OptometristRepository optometristRepository, SellerRepository sellerRepository, AdminRepository adminRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.optometristStaffMapper = optometristStaffMapper;
        this.sellerStaffMapper = sellerStaffMapper;
        this.optometristRepository = optometristRepository;
        this.sellerRepository = sellerRepository;
        this.adminMapper = adminMapper;
        this.adminRepository = adminRepository;
        this.staffMapper = staffMapper;
    }



    @Override
    public AdminDomain registerAdmin(AdminDomain createStaffDomain) {
        var entity = adminMapper.toEntity(createStaffDomain);
        staffRepository.save(entity);
        return createStaffDomain;
    }

    @Override
    public SellerDomain registerSeller(SellerDomain sellerDomain) {
        var entity = sellerStaffMapper.toEntity(sellerDomain);
        return sellerStaffMapper.toDomain(staffRepository.save(entity));
    }

    @Override
    public OptometristDomain registerOptometrist(OptometristDomain optometristDomain) {
        var entity = optometristStaffMapper.toEntity(optometristDomain);
        return optometristStaffMapper.toDomain(staffRepository.save(entity));
    }

    @Override
    public StaffDomain findStaff(Long id) {
        var staff = staffRepository.findById(id);
        assert staff.orElse(null) != null;
        return StaffDomain.builder()
                .email(staff.orElse(null).getEmail())
                .lastName(staff.orElse(null).getLastName())
                .username(staff.orElse(null).getUsername())
                .password(staff.orElse(null).getPassword())
                .id(staff.orElse(null).getId())
                .build();
    }

    @Override
    public AdminDomain findAdmin(Long id) {
        return adminMapper.toDomain(adminRepository.findById(id).orElse(null));
    }

    @Override
    public OptometristDomain findOptometrist(Long id) {
        return optometristStaffMapper.toDomain(optometristRepository.findById(id).orElse(null));
    }

    @Override
    public SellerDomain findSeller(Long id) {
        return sellerStaffMapper.toDomain(sellerRepository.findById(id).orElse(null));
    }

    @Override
    public StaffDomain findByEmail(String email) {
        var staff = staffRepository.findByEmail(email);
        return StaffDomain.builder()
                .email(staff.getEmail())
                .lastName(staff.getLastName())
                .username(staff.getUsername())
                .password(staff.getPassword())
                .id(staff.getId())
                .build();
    }

    @Override
    public List<OptometristDomain> readAllOptometrist() {
        return optometristStaffMapper.toListDomain(optometristRepository.findAll());
    }

    @Override
    public List<SellerDomain> readAllSeller() {
        return sellerStaffMapper.toListDomain(sellerRepository.findAll());
    }

    @Override
    public List<AdminDomain> readAllAdmin() {
        return adminMapper.toListDomain(adminRepository.findAll());
    }

    @Override
    public List<StaffDomain> readAllStaffs() {

        List<StaffDomain> staffDomains = new ArrayList<>();
        staffDomains.addAll(staffMapper.fromAdmin(readAllAdmin()));
        staffDomains.addAll(staffMapper.fromSeller(readAllSeller()));
        staffDomains.addAll(staffMapper.fromOptometrist(readAllOptometrist()));

        return staffDomains;
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
