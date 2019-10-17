package com.mycafe.mycafe_api.service.customerService;

import com.mycafe.mycafe_api.model.canteenmodel.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> getAllRecepies();

    public  Recipe getRecipe(int recipe_id);

    public void deleteRecipe(int recipe_id);

    public String updateRecipe(int id,Recipe recipe);

    public Recipe addRecipe(Recipe recipe);


}
