package com.ayush.Repository;

import com.ayush.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public List<Category> findByRestaurantId(Long id); // By restaurantId, it will find all the categories within this restaurant...
}
