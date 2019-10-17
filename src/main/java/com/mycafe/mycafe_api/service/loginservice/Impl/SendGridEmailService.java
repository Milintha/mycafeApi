package com.mycafe.mycafe_api.service.loginservice.Impl;

import com.mycafe.mycafe_api.service.loginservice.EmailService;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class SendGridEmailService implements EmailService {
    @Override
    public void sendPasswordResetRequest(String username, String email, String token) throws IOException{
        Email from = new Email("test@example.com");
        String subject = "Password reset request";
        Email to = new Email(email);
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

    }
}
