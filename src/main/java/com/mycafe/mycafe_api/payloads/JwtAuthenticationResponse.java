package com.mycafe.mycafe_api.payloads;

import com.mycafe.mycafe_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

//Response Payload
public class JwtAuthenticationResponse{
    private String accessToken;
    private String tokenType = "Bearer";
    private String roleName;

    @Autowired
    UserRepository userRepository;


    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
        //this.roleName = userRepository.getRoleNameById(id);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
