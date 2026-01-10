package com.optical.net.sale.infrastructure.web;

import java.util.List;

public record SaleRequest(

        Long id,

        String patientEmail,

        String sellerUsername,

        List<SaleDetailRequest> detailRequest

) {
}
