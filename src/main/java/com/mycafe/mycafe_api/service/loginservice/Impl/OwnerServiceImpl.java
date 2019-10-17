package com.mycafe.mycafe_api.service.loginservice.Impl;

import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.repository.UserRepository;
import com.mycafe.mycafe_api.service.loginservice.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public  class OwnerServiceImpl implements OwnerService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getOwnerList() {
       // List<User> user = userRepository.getownerListByRoleName("OWNER");
            List<User> user=new ArrayList<>();
        user = userRepository.getOwnerListByRoleName("OWNER");
        try{

            if(user.isEmpty()){
                return user;
            }
            return  user;
        }

        catch (Exception exception){
            return null;
        }

    }

    @Override
    public ResponseEntity<?> deleteOwner(int key) {
        userRepository.deleteById(key);
        String msg = "Successful";
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getOwner(int id) {
       User result = userRepository.findById(id).get();
       return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateOwner(int id, User user) {
        Optional<User> nw = userRepository.findById(id);
        if(nw.isPresent())
        {
            User _user = nw.get();
            _user.setName(user.getName());
            _user.setNic(user.getNic());
            _user.setEmail(user.getEmail());
            _user.setPhone(user.getPhone());
            _user.setCanteen(user.getCanteen());
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());


            return  new ResponseEntity<>(userRepository.save(_user),HttpStatus.OK);

        }
        else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
