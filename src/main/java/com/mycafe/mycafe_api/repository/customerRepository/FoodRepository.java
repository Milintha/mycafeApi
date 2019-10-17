package com.mycafe.mycafe_api.repository.customerRepository;


import com.mycafe.mycafe_api.model.canteenmodel.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query(value = "select * from food f where f.auth_user_id=?1",nativeQuery = true)
    List<Food> findAllFoodsByOwner_id(int auth_user_id);

}
