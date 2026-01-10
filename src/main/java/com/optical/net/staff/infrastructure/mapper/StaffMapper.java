package com.optical.net.staff.infrastructure.mapper;

import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.domain.StaffDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface StaffMapper {

    @Mapping(target = "rolname", expression = "java(domain.getStaffType())")
    @Mapping(target = "createdAt", ignore = true)
    StaffDomain fromAdmin(AdminDomain domain);

    List<StaffDomain> fromAdmin(List<AdminDomain> domains);


    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rolname", expression = "java(domain.getStaffType())")
    StaffDomain fromOptometrist(OptometristDomain domain);

    List<StaffDomain> fromOptometrist(List<OptometristDomain> domains);

    @Mapping(target = "rolname", expression = "java(domain.getStaffType())")
    @Mapping(target = "createdAt", ignore = true)
    StaffDomain fromSeller(SellerDomain domain);

    List<StaffDomain> fromSeller(List<SellerDomain> domains);
}

