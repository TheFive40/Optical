package com.optical.net.user.infrastructure.mapper;
import com.optical.net.user.domain.User;
import com.optical.net.user.infrastructure.web.UserRestRequest;
import com.optical.net.user.infrastructure.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "true")
    UserEntity fromApplication(User createUser);

    User fromRestRequest(UserRestRequest user);
}
