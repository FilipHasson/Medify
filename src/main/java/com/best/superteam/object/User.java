package com.best.superteam.object;

/**
 * @author Filip Hasson
 */
public class User {
    private String firstName;
    private String lastName;
    private String UID;
    private String username;
    private Enumeration.userTypes userType;

    public User(String firstName, String lastName, String UID, String username, Enumeration.userTypes userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.UID = UID;
        this.username = username;
        this.userType = userType;
    }
}
