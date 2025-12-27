package com.optical.net.recipe.infrastructure.persistence;

import com.optical.net.recipe.application.RecipePort;
import com.optical.net.recipe.domain.RecipeDomain;
import com.optical.net.recipe.infrastructure.mapper.RecipeMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RecipePortAdapter implements RecipePort {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipePortAdapter(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public RecipeDomain save(RecipeDomain domain) {
        return recipeMapper.toDomain(recipeRepository.save(recipeMapper.toEntity(domain)));
    }
}
