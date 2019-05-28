package com.reactLogin.login.payload;

import javax.validation.constraints.NotBlank;

public class PostRequest {
    @NotBlank(message = "Text cannot be blank")
    private String text;

    private String username;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
