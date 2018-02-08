package com.nu2k18.nitrutsav;

/**
 * Created by SUBAS on 04-01-2018.
 */

public class Users {

    private String user;
    private String email;
    private String PhotoUrl;
    private String UID;

    public Users()
    {

    }
    public Users(String user)
    {
        this.user=user;
    }

    public Users(String user, String email, String photourl, String UID)
    {
        this.user=user;
        this.email=email;
        this.PhotoUrl=photourl;
        this.UID=UID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
