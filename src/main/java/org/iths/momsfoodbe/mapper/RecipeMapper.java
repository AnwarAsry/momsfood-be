package org.iths.momsfoodbe.mapper;

import org.iths.momsfoodbe.dto.IngredientDto;
import org.iths.momsfoodbe.dto.RecipeCardDto;
import org.iths.momsfoodbe.dto.RecipeDto;
import org.iths.momsfoodbe.dto.RecipeFormDto;
import org.iths.momsfoodbe.model.Ingredient;
import org.iths.momsfoodbe.model.Instruction;
import org.iths.momsfoodbe.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeMapper {

    public RecipeCardDto toCardDto(Recipe recipe) {
        return RecipeCardDto.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .category(recipe.getCategory().name())
                .imgUrl(recipe.getImgUrl())
                .servings(recipe.getServings())
                .prepTime(recipe.getPrepTime())
                .cookTime(recipe.getCookTime())
                .numIngredients(recipe.getIngredients().size())
                .build();
    }

    public RecipeDto toDto(Recipe recipe) {
        List<IngredientDto> ingredients = recipe.getIngredients().stream()
                .map(ing -> IngredientDto.builder()
                        .name(ing.getName())
                        .amount(ing.getAmount())
                        .unit(ing.getUnit())
                        .build())
                .toList();

        List<String> instructions = recipe.getInstructions().stream()
                .map(Instruction::getDescription)
                .toList();

        return RecipeDto.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .category(recipe.getCategory().name())
                .imgUrl(recipe.getImgUrl())
                .servings(recipe.getServings())
                .prepTime(recipe.getPrepTime())
                .cookTime(recipe.getCookTime())
                .notes(recipe.getNotes())
                .ingredients(ingredients)
                .instructions(instructions)
                .build();
    }

    public Recipe toEntity(RecipeFormDto dto) {
        Recipe recipe = Recipe.builder()
                .title(dto.getTitle())
                .category(dto.getCategory())
                .imgUrl(dto.getImgUrl())
                .servings(dto.getServings())
                .prepTime(dto.getPrepTime())
                .cookTime(dto.getCookTime())
                .notes(dto.getNotes())
                .build();

        List<Ingredient> ingredients = dto.getIngredients().stream()
                .map(ing -> Ingredient.builder()
                        .name(ing.getName())
                        .amount(ing.getAmount())
                        .unit(ing.getUnit())
                        .recipe(recipe)
                        .build())
                .toList();

        List<Instruction> instructions = dto.getInstructions().stream()
                .map(desc -> Instruction.builder()
                        .description(desc)
                        .recipe(recipe)
                        .build())
                .toList();

        recipe.setIngredients(new ArrayList<>(ingredients));
        recipe.setInstructions(new ArrayList<>(instructions));

        return recipe;
    }
}