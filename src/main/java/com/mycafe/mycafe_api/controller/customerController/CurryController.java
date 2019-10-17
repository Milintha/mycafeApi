package com.mycafe.mycafe_api.controller.customerController;

import com.mycafe.mycafe_api.model.canteenmodel.Curry;
import com.mycafe.mycafe_api.service.customerService.ServiceImpl.CurryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curry")
public class CurryController {

    @Autowired
    private CurryServiceImpl curryService;

    //add new curry
    @PostMapping("/addCurry")
    public boolean addNewCurry(@RequestBody Curry curry){
        return curryService.addCurry(curry);
    }

//    //checks if curry is exists by curry name
    // return curry list
    @GetMapping
    public List<Curry> searchCurryByName(@PathVariable String name){
        return curryService.searchCurryByName(name);
    }

}
/*
* check exists curries before adding new one
* */