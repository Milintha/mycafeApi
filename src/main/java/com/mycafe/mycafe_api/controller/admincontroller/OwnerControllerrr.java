package com.mycafe.mycafe_api.controller.admincontroller;

import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.service.loginservice.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
@RequestMapping(value = "/owner")
public class OwnerControllerrr {

    @Autowired
    OwnerService ownerService;

    @GetMapping(value = "/getAll")
    public List<User> getAllOwners(){
        return  ownerService.getOwnerList();
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<User> getAllOwners(@PathVariable("id") Long id){
        return  ownerService.getOwner(Math.toIntExact(id));
    }

    @DeleteMapping(value = "/delete/{key}")
    public ResponseEntity<?> deleteOwner(@PathVariable("key") Long key) {
        return ownerService.deleteOwner(Math.toIntExact(key));
    }

    @PutMapping("/update/{id}")
    ResponseEntity<User> updateOwner(@PathVariable("id") int id, @RequestBody User user) {
        return  ownerService.updateOwner(id,user);
    }



}
