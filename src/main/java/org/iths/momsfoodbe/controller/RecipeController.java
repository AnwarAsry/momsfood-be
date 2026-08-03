package org.iths.momsfoodbe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.iths.momsfoodbe.dto.RecipeCardDto;
import org.iths.momsfoodbe.dto.RecipeDto;
import org.iths.momsfoodbe.dto.RecipeFormDto;
import org.iths.momsfoodbe.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    // Get all recipes
    @GetMapping
    public ResponseEntity<List<RecipeCardDto>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    // Get one recipe by id
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    // Create a new recipe
    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@Valid @RequestBody RecipeFormDto requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.createRecipe(requestDTO));
    }
}