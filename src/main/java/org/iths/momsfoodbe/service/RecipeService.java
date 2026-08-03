package org.iths.momsfoodbe.service;

import org.iths.momsfoodbe.dto.RecipeCardDto;
import org.iths.momsfoodbe.dto.RecipeDto;
import org.iths.momsfoodbe.dto.RecipeFormDto;
import org.iths.momsfoodbe.mapper.RecipeMapper;
import org.iths.momsfoodbe.model.Recipe;
import org.iths.momsfoodbe.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    // Get all recipes
    public List<RecipeCardDto> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(recipeMapper::toCardDto)
                .toList();
    }

    // Get one recipe by id
    public RecipeDto getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
        return recipeMapper.toDto(recipe);
    }

    // Create a new recipe
    public RecipeDto createRecipe(RecipeFormDto dto) {
        Recipe recipe = recipeMapper.toEntity(dto);
        return recipeMapper.toDto(recipeRepository.save(recipe));
    }
}
