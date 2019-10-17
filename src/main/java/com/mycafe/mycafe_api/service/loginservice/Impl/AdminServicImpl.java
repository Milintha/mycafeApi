package com.mycafe.mycafe_api.service.loginservice.Impl;

import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.repository.UserRepository;
import com.mycafe.mycafe_api.service.loginservice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServicImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findByCanteen(String canteen) {
        return userRepository.findByCanteen(canteen);
    }
}
