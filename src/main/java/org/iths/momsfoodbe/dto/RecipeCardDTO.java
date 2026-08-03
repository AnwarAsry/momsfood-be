package org.iths.momsfoodbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeCardDTO {
    private Long id;
    private String title;
    private String category;
    private String imgUrl;
    private Integer servings;
    private Integer prepTime;
    private Integer cookTime;
    private Integer numIngredients;
}
