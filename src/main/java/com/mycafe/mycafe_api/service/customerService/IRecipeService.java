package com.mycafe.mycafe_api.service.customerService;

import com.mycafe.mycafe_api.model.canteenmodel.Recipe;

import javax.validation.constraints.Min;
import java.util.List;

public interface IRecipeService {

    public List<Recipe> getAllRecipeByCanteenIdMealTime(int canteenId, String mealTime);
    public List<Recipe> getAllRecipeByCanteenId(int canteenId);


    public List<Recipe> getAllRecipeByDate(int canteenId,String date);

}
