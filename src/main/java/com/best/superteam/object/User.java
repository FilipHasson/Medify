package com.best.superteam.object;

/**
 * @author Filip Hasson
 */
public class User {
    private String firstName;
    private String lastName;
    private int UID;
    private String email;
    private Enumeration.userTypes userType;

    public User(String firstName, String lastName, int UID, String email, Enumeration.userTypes userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.UID = UID;
        this.email = email;
        this.userType = userType;
    }

    public User(String firstName, String lastName, int UID, String email, int userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.UID = UID;
        this.email = email;
        switch (userType){
            case 0:
                this.userType = Enumeration.userTypes.CLIENT;
                break;
            case 1:
                this.userType = Enumeration.userTypes.STAFF;
                break;
            case 2:
                this.userType = Enumeration.userTypes.ADMIN;
                break;
            case 3:
                this.userType = Enumeration.userTypes.FAMILY;
                break;
            default:
                this.userType = Enumeration.userTypes.CLIENT;
                break;
        }
    }

    @Override
    public String toString() {
        return UID + ": " + lastName + ", " + firstName;
    }
}
