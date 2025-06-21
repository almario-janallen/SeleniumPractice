package com.selenium.practice.qa.LoginTestSuite;

public class LoginData {
    private String id;
    private String username;
    private String password;
    private String result;

    public LoginData(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("id: %s, username: %s, password: %s, result: %s",this.id,this.username,this.password,this.result);
    }
}
