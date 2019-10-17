package com.mycafe.mycafe_api.service.loginservice;

import com.mycafe.mycafe_api.model.loginmodel.User;

import java.util.Optional;

public interface AdminService {
    Optional<User> findByCanteen(String canteen);
}
