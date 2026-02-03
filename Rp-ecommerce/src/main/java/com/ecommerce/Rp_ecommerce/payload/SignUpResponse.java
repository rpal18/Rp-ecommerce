package com.ecommerce.Rp_ecommerce.security.jwt.payload;

public class SignUpResponse {
        private Long userId;
        private String username;
        private String email;

        public SignUpResponse(Long userId, String username, String email) {
            this.userId = userId;
            this.username = username;
            this.email = email;
        }
    public Long getUserId() {
        return userId;
    }


    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }

}
