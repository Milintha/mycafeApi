package com.mycafe.mycafe_api.repository.customerRepository;

import com.mycafe.mycafe_api.model.canteenmodel.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory,Integer> {

}

