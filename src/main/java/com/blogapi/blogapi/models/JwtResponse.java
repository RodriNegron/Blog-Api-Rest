package com.blogapi.blogapi.models;

public class JwtResponse {

    private String jwtToken;

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public String getJwtToken() {
        return jwtToken;
    }

    public JwtResponse(String string){
        this.jwtToken=string;
    }
    
}
