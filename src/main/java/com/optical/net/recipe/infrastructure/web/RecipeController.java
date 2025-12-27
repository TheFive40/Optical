package com.optical.net.recipe.infrastructure.web;

import com.optical.net.recipe.application.RecipeCaseAdapter;
import com.optical.net.recipe.infrastructure.mapper.RecipeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeMapper recipeMapper;
    private final RecipeCaseAdapter recipeCaseAdapter;

    public RecipeController(RecipeMapper recipeMapper, RecipeCaseAdapter recipeCaseAdapter) {
        this.recipeMapper = recipeMapper;
        this.recipeCaseAdapter = recipeCaseAdapter;
    }

    @PostMapping("/register")
    public ResponseEntity<RecipeResponse> registerRecipe(RecipeRequest request) {
        var domain = recipeCaseAdapter.registerRecipe(recipeMapper.fromRequest(request));
        return ResponseEntity.ok(new RecipeResponse(domain.id(), domain.date(), domain.odSphere(), domain.odCylinder(),
                domain.odAxis(), domain.odAddition(), domain.oiSphere(), domain.oiCylinder(), domain.oiAxis(), domain.oiAddition(),
                domain.pupillaryDistance(), domain.observations(), domain.patient(), domain.optometrist()));
    }
}
