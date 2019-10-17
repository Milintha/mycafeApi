package com.mycafe.mycafe_api.service.loginservice;

import com.mycafe.mycafe_api.model.loginmodel.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerService {
   // ResponseEntity<List<User>> findAll();

    List<User> getOwnerList();

    ResponseEntity<?> deleteOwner(int key);

    ResponseEntity<User> updateOwner(int id, User user);

    ResponseEntity<User> getOwner(int id);


}
