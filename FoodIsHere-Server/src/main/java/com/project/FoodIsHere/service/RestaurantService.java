package com.project.FoodIsHere.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FoodIsHere.entity.Restaurant;
import com.project.FoodIsHere.jpa.RestaurantRepository;

@Service
public class RestaurantService {
	
	private final RestaurantRepository restaurantRepository;
	
	@Autowired
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	/**
	 * Recupere la liste des restaurants
	 * @return
	 */
	public List<Restaurant> getRestaurants() {
		return this.restaurantRepository.findAll();
	}

	/**
	 * Ajoute un restaurant
	 * @param restaurant
	 */
	public void addRestaurant(Restaurant restaurant) {
		Optional<Restaurant> restaurantOptional = this.restaurantRepository.findRestaurantByName(restaurant.getName());
		if(restaurantOptional.isPresent()) {
			throw new IllegalStateException("Le restaurant existe déjà.");
		}
		this.restaurantRepository.save(restaurant);
	}
	
	/**
	 * Supprime un restaurant
	 * @param restaurant_id
	 */
	public void deleteRestaurant(Integer restaurant_id) {
		Boolean restaurantExist = this.restaurantRepository.existsById(restaurant_id);
		if(!restaurantExist) {
			throw new IllegalStateException("Le restaurant n'existe pas.");
		}
		this.restaurantRepository.deleteById(restaurant_id);
	}
	
	/**
	 * Mets a jours un restaurant
	 * @param restaurant_id
	 * @param name
	 * @param address
	 * @param description
	 */
	@Transactional
	public void updateRestaurant(Integer restaurant_id, String name, String address, String description) {
		Restaurant restaurantById = this.restaurantRepository.findRestaurantById(restaurant_id);
		
		if(restaurantById != null) {
			throw new IllegalStateException("Le restaurant n'existe pas.");
		}
		
		if(name != null && name.length() > 0 && !Objects.equals(name, restaurantById.getName())) {
			restaurantById.setName(name);
		}
		if(address != null && address.length() > 0 && !Objects.equals(address, restaurantById.getAddress())) {
			restaurantById.setAddress(address);
		}
		if(description != null && description.length() > 0 && !Objects.equals(description, restaurantById.getDescription())) {
			restaurantById.setDescription(description);
		}
		
		this.restaurantRepository.save(restaurantById);
	}
}
