package com.mycafe.mycafe_api.controller.customerController;

import com.mycafe.mycafe_api.model.canteenmodel.Canteen;
import com.mycafe.mycafe_api.service.customerService.ServiceImpl.CanteenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canteen")
public class CanteenController {
    @Autowired
    private CanteenServiceImpl canteenService;

    @GetMapping("/detail/{canteen_id}")
    public Canteen getCanteenDetails(@PathVariable Integer canteen_id){
        return canteenService.getCanteenDetail(canteen_id);
    }
}
