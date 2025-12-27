package com.optical.net.staff.infrastructure.persistence;

import com.optical.net.recipe.infrastructure.persistence.Recipe;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("OPTOMETRIST")
public class OptometristStaff extends Staff {

    @Column(name = "license_number", unique = true, length = 50)
    private String licenseNumber;

    @Column(name = "specialization", length = 100)
    private String specialization;

    @Column(name = "years_experience")
    private Integer yearsOfExperience;

    @OneToMany(mappedBy = "optometrist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Recipe> recipes = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setOptometrist(this);
    }

    @Override
    public String getStaffType() {
        return "OPTOMETRIST";
    }
}
