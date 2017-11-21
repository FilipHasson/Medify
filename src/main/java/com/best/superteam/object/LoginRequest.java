package com.best.superteam.object;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Filip Hasson
 */
public class LoginRequest {
    private String email;
    private int UID;
    private byte[] passwordHash;
    private boolean validHash;


    //This should be used for new password requests
    public LoginRequest(String email, String password){
        this.email = email;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.passwordHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            this.passwordHash = null;
            this.validHash = false;
        }
    }

    //This should ONLY be used by the DAO
    public LoginRequest(String email, byte[]passwordHash){
        this.email = email;
        this.passwordHash = passwordHash;
        this.validHash = true;
    }

    public boolean isPasswordHashed(){
        return validHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!email.equals(that.email)) return false;
        return Arrays.equals(passwordHash, that.passwordHash);
    }

    public static byte[] hexStringToByteArray(String s){
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String byteArrayToHexString(byte[]data){
        final StringBuilder builder = new StringBuilder();
        for(byte b : data) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
