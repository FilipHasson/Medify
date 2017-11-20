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
    private int medals;
    private int streak;

    public User(String firstName, String lastName, int UID, String email,
                Enumeration.userTypes userType, int medals, int streak) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.UID = UID;
        this.email = email;
        this.userType = userType;
        this.medals = medals;
        this.streak = streak;
    }

    public User(String firstName, String lastName, int UID, String email,
                int userType, int medals, int streak) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.UID = UID;
        this.email = email;
        this.medals = medals;
        this.streak = streak;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enumeration.userTypes getUserType() {
        return userType;
    }

    public void setUserType(Enumeration.userTypes userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return UID + ": " + lastName + ", " + firstName;
    }
}
