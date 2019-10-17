package com.mycafe.mycafe_api.controller.customerController;

import com.mycafe.mycafe_api.model.canteenmodel.Food;
import com.mycafe.mycafe_api.service.customerService.ServiceImpl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/second")
public class SecondaryController  {
    @Autowired
    private FoodServiceImpl foodService;

    @GetMapping("/getFoods/{owner_id}")
    public List<Food> getAllFoodsByOwnerId(@PathVariable Integer owner_id){
        return  foodService.getAllFoodsById(owner_id);
    }
}
