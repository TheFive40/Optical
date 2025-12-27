package com.optical.net.staff.infrastructure.persistence;

import com.optical.net.staff.application.RegisterStaffPort;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.infrastructure.mapper.AdminMapper;
import com.optical.net.staff.infrastructure.mapper.OptometristStaffMapper;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterStaffPortAdapter implements RegisterStaffPort {
    private final StaffRepository staffRepository;

    private final AdminMapper staffMapper;
    private final OptometristStaffMapper optometristStaffMapper;
    private final SellerStaffMapper sellerStaffMapper;

    public RegisterStaffPortAdapter(AdminMapper staffMapper, StaffRepository staffRepository, OptometristStaffMapper optometristStaffMapper, SellerStaffMapper sellerStaffMapper) {
        this.staffMapper = staffMapper;
        this.staffRepository = staffRepository;
        this.optometristStaffMapper = optometristStaffMapper;
        this.sellerStaffMapper = sellerStaffMapper;
    }

    @Override
    public AdminDomain registerAdmin(AdminDomain createStaffDomain) {
        staffRepository.save(staffMapper.toEntity(createStaffDomain));
        return createStaffDomain;
    }

    @Override
    public SellerDomain registerSeller(SellerDomain sellerDomain) {
        return sellerStaffMapper.toDomain(staffRepository.save(sellerStaffMapper.toEntity(sellerDomain)));
    }

    @Override
    public OptometristDomain registerOptometrist(OptometristDomain optometristDomain) {
        return optometristStaffMapper.toDomain(staffRepository.save(optometristStaffMapper.toEntity(optometristDomain)));
    }
}
