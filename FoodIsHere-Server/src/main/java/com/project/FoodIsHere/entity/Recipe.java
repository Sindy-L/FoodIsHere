package com.project.FoodIsHere.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Recipe {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recipe_id;
	private String name;
	private String ingredient_list;
	private String instruction_list;
	private String type;

	public Recipe() {
		super();
	}
	
	public Recipe(String name, String ingredient_list, String instruction_list, String type) {
		this.name = name;
		this.ingredient_list = ingredient_list;
		this.instruction_list = instruction_list;
		this.type = type;
	}

	public int getRecipe_id() {
		return this.recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getIngredient_list() {
		return this.ingredient_list;
	}

	public void setIngredient_list(String ingredient_list) {
		this.ingredient_list = ingredient_list;
	}   
	public String getInstruction_list() {
		return this.instruction_list;
	}

	public void setInstruction_list(String instruction_list) {
		this.instruction_list = instruction_list;
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", name=" + name + ", ingredient_list=" + ingredient_list
				+ ", instruction_list=" + instruction_list + ", type=" + type + "]";
	}
	
}
