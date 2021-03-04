package com.project.FoodIsHere.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.FoodIsHere.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	/**
	 * @Query is Optional, findRestaurantByName does not requires the annotation.
	 * It's just to be more specific
	 * @param name
	 * @return
	 */
	@Query("SELECT r FROM Restaurant r WHERE r.name = ?1")
	Optional<Restaurant> findRestaurantByName(String name);
	
	@Query("SELECT r FROM Restaurant r WHERE r.restaurant_id = ?1")
	Restaurant findRestaurantById(Integer restaurant_id);
}
