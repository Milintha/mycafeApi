package com.mycafe.mycafe_api.controller.admincontroller;

import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.service.loginservice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/search/owner/{canteen}")
    public Optional<User> getOwner(@PathVariable("canteen") String canteen){
        return  adminService.findByCanteen(canteen);
    }

}
