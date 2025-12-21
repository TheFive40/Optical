package com.optical.net.staff.infrastructure.mapper;
import com.optical.net.staff.domain.Staff;
import com.optical.net.staff.infrastructure.web.StaffRestRequest;
import com.optical.net.staff.infrastructure.persistence.StaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "true")
    StaffEntity fromApplication(Staff createStaff);

    Staff fromRestRequest(StaffRestRequest user);
}
