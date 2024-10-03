package com.sgd.sgdfback.object;

public class AuthTokenResponse {
    private String token; 


    public AuthTokenResponse() {
    }

    public AuthTokenResponse(String token) {
        this.token = token;
    }

    private AuthTokenResponse(builder builder) {
        this.token = builder.token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public static class builder {
        private String token;

        public builder token(String token) {
            this.token = token;
            return this;
        }

        public AuthTokenResponse build() {
            return new AuthTokenResponse(this);
        }
    }

}
