package com.hashem.android1_2023.Section101.Database;

import android.graphics.Bitmap;

public class Contact {

    private int id;
    private String name;
    private String email;
    private String phone;
    private int yearOfBirth;
    Bitmap image;

    public Contact(String name, String email, String phone, int yearOfBirth) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
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

    @Override
    public String toString() {
        return "\nContact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
