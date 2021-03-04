package com.project.FoodIsHere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodIsHere.entity.Recipe;
import com.project.FoodIsHere.service.RecipeService;

@RestController
@RequestMapping(path="RecipeController")
public class RecipeController {
	
	private final RecipeService recipeService;
	
	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping(path="recipes")
	public List<Recipe> getRecipes() {
		return recipeService.getRecipes();
	}
	
	@PostMapping(path="addRecipe")
	public void addRecipe(@RequestBody Recipe recipe) {
		recipe.setName("Nouille Instantanée");
		recipe.setIngredient_list("Sachet de nouille, Eau, Légumes");
		recipe.setInstruction_list("Faire chauffer l'eau dans une casserole. Ajouter les nouilles et les légumes et laisser cuire");
		recipe.setType("Plat");
		this.recipeService.addRecipe(recipe);
	}

	@DeleteMapping(path="deleteRecipe/{recipeId}")
	public void deleteRecipe(@PathVariable("recipeId") Integer recipe_id) {
		this.recipeService.deleteRecipe(recipe_id);
	}
	
	@PostMapping(path="updateRecipe/{recipeId}")
	public void updateRecipe(@PathVariable("recipeId") Integer recipe_id,
								@RequestParam(required=false) String name,
								@RequestParam(required=false) String ingredient_list,
								@RequestParam(required=false) String instruction_list,
								@RequestParam(required=false) String type) {
		this.recipeService.updateRecipe(recipe_id, name, ingredient_list, instruction_list, type);
	}
}
