package org.iths.momsfoodbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private Long id;
    private String title;
    private String category;
    private String imgUrl;
    private Integer servings;
    private Integer prepTime;
    private Integer cookTime;
    private String notes;
    private List<IngredientDto> ingredients;
    private List<String> instructions;
}
