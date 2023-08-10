package com.hashem.android1_2023.Testing.DatabaseFullExample;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private double GPA;
    private String field;

    public Student(String name, double GPA, String field) {
        this.name = name;
        this.GPA = GPA;
        this.field = field;
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

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
