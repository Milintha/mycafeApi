package com.mycafe.mycafe_api.service.customerService.ServiceImpl;

import com.mycafe.mycafe_api.model.canteenmodel.Food;
import com.mycafe.mycafe_api.repository.customerRepository.FoodRepository;
import com.mycafe.mycafe_api.service.customerService.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Component
public class FoodServiceImpl implements IFoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFoodsById(int owner_id) {
        return foodRepository.findAllFoodsByOwner_id(owner_id);
    }
}
