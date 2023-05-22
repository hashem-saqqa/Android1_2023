package com.hashem.android1_2023.Testing.SqliteDatabase;

import android.graphics.Bitmap;

public class Contact {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int yearOfBirth;
    private Bitmap image;

    public Contact(String name, String email, String phone, int yearOfBirth,Bitmap image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", image=" + image +
                '}';
    }
}
