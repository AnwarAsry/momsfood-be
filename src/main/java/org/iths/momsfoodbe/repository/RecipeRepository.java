package org.iths.momsfoodbe.repository;

import org.iths.momsfoodbe.model.Category;
import org.iths.momsfoodbe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory(Category category);
}
