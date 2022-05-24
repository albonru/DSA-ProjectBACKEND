package edu.upc.eetac.dsa.models;

public class SignUpCredentials {

    private String username;
    private String password;
    private String email;

    public SignUpCredentials(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public SignUpCredentials(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public SignUpCredentials() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}