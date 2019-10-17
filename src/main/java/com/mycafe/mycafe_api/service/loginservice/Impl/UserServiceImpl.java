package com.mycafe.mycafe_api.service.loginservice.Impl;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycafe.mycafe_api.model.loginmodel.PasswordResetTokenEntity;
import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.repository.PasswordResetTokenRepository;
import com.mycafe.mycafe_api.repository.UserRepository;
import com.mycafe.mycafe_api.security.ResetTokenProvider;
import com.mycafe.mycafe_api.service.loginservice.EmailService;
import com.mycafe.mycafe_api.service.loginservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean resetPassword(String token, String password) {
        boolean returnValue = false;

        if(ResetTokenProvider.hasTokenExpired(token))
        {
            return returnValue;
        }

        PasswordResetTokenEntity passwordResetTokenEntity = passwordResetTokenRepository.findByToken(token);

        if(passwordResetTokenEntity==null){
            return returnValue;
        }

        //Prepare new password
        String enodedPassword = passwordEncoder.encode(password);

        //update password in database
        User user = passwordResetTokenEntity.getUser();
        user.setPassword(enodedPassword);
        User savedUser = userRepository.save(user);

        if (savedUser!=null && savedUser.getPassword().equalsIgnoreCase(enodedPassword)){
            returnValue = true;
        }

        //Remove password reset toke from db
        passwordResetTokenRepository.delete(passwordResetTokenEntity);

        return returnValue;
    }

    @Override
    public boolean requestPasswordReset(String email)  {

        boolean returnValue = false;

        User user = userRepository.findByEmail(email);

        if (user == null){
            return returnValue;
        }

        ResetTokenProvider resetTokenProvider = new ResetTokenProvider();

        String token = resetTokenProvider.generatePasswordResetToken(user.getName());

        PasswordResetTokenEntity passwordResetTokenEntity = new PasswordResetTokenEntity();
        passwordResetTokenEntity.setToken(token);
        passwordResetTokenEntity.setUser(user);
        passwordResetTokenRepository.save(passwordResetTokenEntity);

        //returnValue = new AmazonSES().sendPassworResetRequest(user.getName(),user.getEmail(),token);

        //emailService.sendHTML("abc@gmail.com", "amilawickramasinghe95@gmail.com", "Hello World", "Hello, <strong>how are you doing?</strong>");

        try {
            JsonNode jsonNode = MailGunEmailService.sendSimpleMessage(user.getEmail());

            if(jsonNode!=null)
                returnValue=true;
            //emailService.sendPasswordResetRequest(email,user.getUsername(),token);
        }catch (UnirestException e) {
            e.printStackTrace();
        }






        return returnValue;
    }
}
