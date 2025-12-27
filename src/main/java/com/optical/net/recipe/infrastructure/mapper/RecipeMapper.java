package com.optical.net.recipe.infrastructure.mapper;

import com.optical.net.recipe.domain.RecipeDomain;
import com.optical.net.recipe.infrastructure.persistence.Recipe;
import com.optical.net.recipe.infrastructure.web.RecipeRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    RecipeDomain toDomain(Recipe recipe);

    RecipeDomain fromRequest(RecipeRequest request);

    Recipe toEntity(RecipeDomain domain);

}
