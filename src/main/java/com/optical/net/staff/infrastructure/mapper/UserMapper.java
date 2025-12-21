package com.optical.net.staff.infrastructure.mapper;
import com.optical.net.staff.domain.Staff;
import com.optical.net.staff.infrastructure.web.UserRestRequest;
import com.optical.net.staff.infrastructure.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "true")
    UserEntity fromApplication(Staff createStaff);

    Staff fromRestRequest(UserRestRequest user);
}
