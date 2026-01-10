package com.optical.net.staff.infrastructure.mapper;

import com.optical.net.staff.domain.StaffDomain;
import com.optical.net.staff.infrastructure.web.query.StaffResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffResponseMapper {

    StaffResponse toResponse(StaffDomain domain);

    List<StaffResponse> toResponse(List<StaffDomain> domains);
}

