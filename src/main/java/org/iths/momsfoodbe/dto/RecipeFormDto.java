package org.iths.momsfoodbe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iths.momsfoodbe.model.Category;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeFormDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Category is required")
    private Category category;

    @NotBlank(message = "Image URL is required")
    private String imgUrl;

    private Integer servings;
    private Integer prepTime;
    private Integer cookTime;
    private String notes;

    @NotEmpty(message = "Add at least one ingredient")
    private List<IngredientDto> ingredients;

    @NotEmpty(message = "Add at least one step")
    private List<String> instructions;
}
