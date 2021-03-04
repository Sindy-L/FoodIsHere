package com.project.FoodIsHere.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FoodIsHere.entity.Recipe;
import com.project.FoodIsHere.jpa.RecipeRepository;

@Service
public class RecipeService {

private final RecipeRepository recipeRepository;
	
	@Autowired
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	/**
	 * Recupere la liste des recettes
	 * @return
	 */
	public List<Recipe> getRecipes() {
		return this.recipeRepository.findAll();
	}
	
	/**
	 * Ajoute une recette
	 * @param recipe
	 */
	public void addRecipe(Recipe recipe) {
		Optional<Recipe> recipeOptional = this.recipeRepository.findRecipeByName(recipe.getName());
		if(recipeOptional.isPresent()) {
			throw new IllegalStateException("Le recipe existe déjà.");
		}
		this.recipeRepository.save(recipe);
	}
	
	/**
	 * Supprime une recette
	 * @param recipe_id
	 */
	public void deleteRecipe(Integer recipe_id) {
		Boolean recipeExist = this.recipeRepository.existsById(recipe_id);
		if(!recipeExist) {
			throw new IllegalStateException("La recette n'existe pas.");
		}
		this.recipeRepository.deleteById(recipe_id);
	}
	
	/**
	 * Mets a jour une recette
	 * @param recipe_id
	 * @param name
	 * @param ingredient_list
	 * @param instruction_list
	 * @param type
	 */
	@Transactional
	public void updateRecipe(Integer recipe_id, String name, String ingredient_list, 
			String instruction_list, String type) {
		Recipe recipeById = this.recipeRepository.findRecipeById(recipe_id);
		
		if(recipeById != null) {
			throw new IllegalStateException("Le recipe n'existe pas.");
		}
		
		if(name != null && name.length() > 0 && !Objects.equals(name, recipeById.getName())) {
			recipeById.setName(name);
		}
		
		if(ingredient_list != null && ingredient_list.length() > 0 && !Objects.equals(ingredient_list, recipeById.getIngredient_list())) {
			recipeById.setIngredient_list(ingredient_list);
		}
		
		if(instruction_list != null && instruction_list.length() > 0 && !Objects.equals(instruction_list, recipeById.getInstruction_list())) {
			recipeById.setInstruction_list(instruction_list);
		}
		
		if(type != null && type.length() > 0 && !Objects.equals(type, recipeById.getType())) {
			recipeById.setType(type);
		}
		
		this.recipeRepository.save(recipeById);
	}
}
