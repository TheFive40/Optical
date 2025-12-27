package com.optical.net.staff.domain;
import com.optical.net.accescontrol.domain.RoleDomain;
import com.optical.net.sale.domain.SaleDomain;
import lombok.Builder;
import java.util.List;

@Builder
public record StaffDomain(
        String username,
        String email,
        String password,
        String name,
        String lastName,
        List<SaleDomain> sales,
        List<RoleDomain> roles

) {
}
