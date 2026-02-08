package com.ecommerce.Rp_ecommerce.payload;

public class SignUpResponse {
        private  Long userId;
        private  String username;
        private String email;

        public SignUpResponse(Long userId, String username, String email) {
            this.userId = userId;
            this.username = username;
            this.email = email;
        }

    public SignUpResponse() {
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
