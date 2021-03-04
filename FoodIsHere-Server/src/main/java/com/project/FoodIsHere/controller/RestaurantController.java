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

import com.project.FoodIsHere.entity.Restaurant;
import com.project.FoodIsHere.service.RestaurantService;

@RestController
@RequestMapping(path="RestaurantController")
public class RestaurantController {
	
	private final RestaurantService restaurantService;
	
	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	@GetMapping(path="restaurants")
	public List<Restaurant> getRestaurants() {
		return this.restaurantService.getRestaurants();
	}
	
	@PostMapping(path="addRestaurant")
	public void addRestaurant(@RequestBody Restaurant restaurant) {
		restaurant.setName("Samouraï");
		restaurant.setDescription("Japonais");
		restaurant.setAddress("Epinay Sur Seine");
		this.restaurantService.addRestaurant(restaurant);
	}

	@DeleteMapping(path="deleteRestaurant/{restaurantId}")
	public void deleteRestaurant(@PathVariable("restaurantId") Integer restaurant_id) {
		this.restaurantService.deleteRestaurant(restaurant_id);
	}
	
	@PostMapping(path="updateRestaurant/{restaurantId}")
	public void updateRestaurant(@PathVariable("restaurantId") Integer restaurant_id,
								@RequestParam(required=false) String name,
								@RequestParam(required=false) String address,
								@RequestParam(required=false) String description) {
		this.restaurantService.updateRestaurant(restaurant_id, name, address, description);
	}
}
