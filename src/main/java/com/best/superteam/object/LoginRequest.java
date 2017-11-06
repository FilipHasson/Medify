package com.best.superteam.object;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Filip Hasson
 */
public class LoginRequest {
    private String username;
    private byte[] passwordHash;
    private boolean validHash;


    //This should be used for new password requests
    public LoginRequest(String username, String password){
        this.username = username;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.passwordHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            this.passwordHash = null;
            this.validHash = false;
        }
    }

    //This should ONLY be used by the DAO
    public LoginRequest(String username, byte[]passwordHash){
        this.username = username;
        this.passwordHash = passwordHash;
        this.validHash = true;
    }

    public boolean isPasswordHashed(){
        return validHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.passwordHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        } catch (NoSuchAlgorithmException e) {
            this.passwordHash = null;
            this.validHash = false;
        }
    }

    public boolean isValidHash() {
        return validHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginRequest that = (LoginRequest) o;

        if (validHash != that.validHash) return false;
        if (!username.equals(that.username)) return false;
        return Arrays.equals(passwordHash, that.passwordHash);
    }
}
