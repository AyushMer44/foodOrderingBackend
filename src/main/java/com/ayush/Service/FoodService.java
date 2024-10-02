package com.ayush.Service;

import com.ayush.Model.Category;
import com.ayush.Model.Food;
import com.ayush.Model.Restaurant;
import com.ayush.Request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId,boolean isVegetarian,boolean isNonveg,boolean isSeasonal,String foodCategory);

    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;

}
