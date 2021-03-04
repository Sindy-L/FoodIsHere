package com.project.FoodIsHere.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.FoodIsHere.entity.Recipe;

@Repository
public interface RecipeRepository  extends JpaRepository<Recipe, Integer>{
	/**
	 * @Query is Optional, findRecipeByName does not requires the annotation.
	 * It's just to be more specific
	 * @param name
	 * @return
	 */
	@Query("SELECT r FROM Recipe r WHERE r.name = ?1")
	Optional<Recipe> findRecipeByName(String name);
	
	@Query("SELECT r FROM Recipe r WHERE r.recipe_id = ?1")
	Recipe findRecipeById(Integer recipe_id);
}
