package com.ecommerce.Rp_ecommerce.security.jwt.payload;

import java.util.List;

public class UserInfoResponse {
    private Long userId;
    private String jwtToken;
    private String userName;
    private List<String> roles;

    public UserInfoResponse( Long userId , String jwtToken, String userName, List<String> roles) {
        this.jwtToken = jwtToken;
        this.userName = userName;
        this.roles = roles;
        this.userId = userId;
    }

    public UserInfoResponse(Long id, String username, List<String> roles) {
        this.userName = username;
        this.roles = roles;
        this.userId = id;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
