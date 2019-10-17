package com.mycafe.mycafe_api.service.loginservice;

import java.io.IOException;

public interface EmailService {
    //void sendText(String from, String to, String subject, String body);
    //void sendHTML(String from, String to, String subject, String body);
    void sendPasswordResetRequest(String username, String email, String token) throws IOException;
}
