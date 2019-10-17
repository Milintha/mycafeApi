package com.mycafe.mycafe_api.service.loginservice;

import java.io.IOException;

public interface UserService {
    boolean requestPasswordReset(String email);

    boolean resetPassword(String token, String password);
}
