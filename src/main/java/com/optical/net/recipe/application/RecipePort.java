package com.optical.net.recipe.application;

import com.optical.net.recipe.domain.RecipeDomain;

public interface RecipePort {
    RecipeDomain save (RecipeDomain domain);
}
