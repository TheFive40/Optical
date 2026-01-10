package com.optical.net.staff.infrastructure.persistence.seller;

import com.optical.net.sale.infrastructure.persistence.Sale;
import com.optical.net.staff.infrastructure.persistence.staff.Staff;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("SELLER")
public class Seller extends Staff {

    @Column(name = "commission_rate", precision = 5, scale = 2)
    private BigDecimal commissionRate;

    @Column(name = "sales_target", precision = 10, scale = 2)
    private BigDecimal salesTarget;

    @Column(name = "employee_code", unique = true, length = 20)
    private String employeeCode;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Sale> sales = new ArrayList<>();

    @Override
    public String getStaffType() {
        return "SELLER";
    }

    public void addSale(Sale sale) {
        sales.add(sale);
        sale.setSeller(this);
    }

    public BigDecimal getTotalSales() {
        return sales != null ? sales.stream()
                .map(Sale::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add) : BigDecimal.ZERO;
    }

    public BigDecimal calculateCommission() {
        if (commissionRate == null) {
            return BigDecimal.ZERO;
        }
        return getTotalSales().multiply(commissionRate).divide(new BigDecimal("100"));
    }

    public int getTotalSalesCount() {
        return sales != null ? sales.size() : 0;
    }
}
