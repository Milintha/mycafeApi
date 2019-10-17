package com.mycafe.mycafe_api.service.loginservice.Impl;

/*
import com.fasterxml.jackson.databind.JsonNode;
import com.mycafe.mycafe_api.service.loginservice.EmailService;
import com.mycafe.mycafe_api.service.loginservice.RESTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;*/

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycafe.mycafe_api.service.loginservice.RESTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailGunEmailService  {
    private RESTClient springRestClient;
    private String password;
    private String messagesUrl;
    private String username;

    final String FROM = "sandbox8a75880f9997487895e8c278dd626748.mailgun.org";
    final String PASSWORD_RESET_SUBJECT = "Password reset request";

    final String PASSWORD_RESET_HTMLBODY = "<h1>A request to reset your password</h1>"
            +"<p>Hi $name!</p>"
            +"<p>Please click on below link to reset password.</p>"
            +"<a href='http://localhost:8080/verifiation-service/password-reset.html?token=$token'>Reset Password</a>"
            +"<br/>Thank You!";

    @Autowired
    public MailGunEmailService(RESTClient springRestClient, String mailGunAPIMessagesUrl, String mailGunAPIUsername,
                               String mailGunAPIPassword) {
        this.springRestClient = springRestClient;
        this.username = mailGunAPIUsername;
        this.password = mailGunAPIPassword;
        this.messagesUrl = mailGunAPIMessagesUrl;
    }

   /* @Override
    public void sendText(String from, String to, String subject, String body) {
        MultiValueMap<String, String> map = getPostRequestObject(from, to, subject);
        map.add("text", body);
        sendEmail(map);

    }

    @Override
    public void sendHTML(String from, String to, String subject, String body) {
        MultiValueMap<String, String> map = getPostRequestObject(from, to, subject);
        map.add("html", body);
        sendEmail(map);
    }

    @Override
    public boolean sendPasswordResetRequest(String username, String email, String token) {
        boolean returnValue = false;
        return returnValue;
    }

    private void sendEmail(MultiValueMap<String, String> map) {
        this.springRestClient.post(this.messagesUrl, map, this.username, this.password);
    }

    private MultiValueMap<String, String> getPostRequestObject(String from, String to, String subject) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("from", from);
        map.add("to", to);
        map.add("subject", subject);
        return map;
    }*/

    public static JsonNode sendSimpleMessage(String email) throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "sandbox8a75880f9997487895e8c278dd626748.mailgun.org" + "/messages")
                .basicAuth("api", "c99c30568c3eebf4c47f3df2ed65497e-4167c382-54d64af7")
                .field("from", "Excited User igskrishan@gmail.com")
                .field("to", email)
                .field("subject", "hello")
                .field("text", "testing")
                .asJson();

        return request.getBody();
    }
}

