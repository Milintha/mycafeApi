package com.mycafe.mycafe_api.service.customerService;

import com.mycafe.mycafe_api.model.canteenmodel.Food;

import java.util.List;

public interface IFoodService {
    List<Food> getAllFoodsById(int owner_id);


}
