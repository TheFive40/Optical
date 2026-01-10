package com.optical.net.staff.infrastructure.mapper;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.infrastructure.persistence.admin.AdminRequest;
import com.optical.net.staff.infrastructure.persistence.admin.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDomain fromRequest(AdminRequest request);

    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "createdAt", ignore = true)
    Admin toEntity(AdminDomain domain);

    AdminDomain toDomain(Admin entity);

    List<AdminDomain> toListDomain(Iterable<Admin> admins);

}
