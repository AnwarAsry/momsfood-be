package org.iths.momsfoodbe.controller;

import lombok.RequiredArgsConstructor;
import org.iths.momsfoodbe.component.ApiResponse;
import org.iths.momsfoodbe.dto.RecipeCardDto;
import org.iths.momsfoodbe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RecipeCardDto>>> search(@RequestParam String query) {
        return ResponseEntity.ok(ApiResponse.ok(recipeService.searchRecipes(query)));
    }
}
