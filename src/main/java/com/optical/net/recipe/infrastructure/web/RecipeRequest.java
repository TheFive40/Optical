package com.optical.net.recipe.infrastructure.web;

import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.staff.domain.StaffDomain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RecipeRequest (
        Long id,

        LocalDateTime date,

        BigDecimal odSphere,

        BigDecimal odCylinder,

        Integer odAxis,

        BigDecimal odAddition,

        BigDecimal oiSphere,

        BigDecimal oiCylinder,

        Integer oiAxis,

        BigDecimal oiAddition,

        BigDecimal pupillaryDistance,

        String observations

){
}
