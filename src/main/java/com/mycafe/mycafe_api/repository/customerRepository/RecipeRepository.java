package com.mycafe.mycafe_api.repository.customerRepository;

import com.mycafe.mycafe_api.model.canteenmodel.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {


}
