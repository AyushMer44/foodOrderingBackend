package com.ayush.Repository;

import com.ayush.Model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {
    List<IngredientCategory> findByRestaurantId(Long id);
}
