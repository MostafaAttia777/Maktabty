package com.Maktaba.MyBooks.LoginActivity;

import android.net.Uri;

public class Model {
    private String name;
    private String email;
    private String password;
    private String phone;
     private  String image_uri;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    public Model(String name) {
        this.name = name;
    }

    public Model(String name, String email, String password, String phone, String image_uri) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image_uri = image_uri;
    }

    public Model(String name, String email, String password, String phone, Uri linkofimage) {
    }
}
