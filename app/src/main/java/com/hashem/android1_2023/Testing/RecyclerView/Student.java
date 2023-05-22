package com.hashem.android1_2023.Testing.RecyclerView;

import android.graphics.Bitmap;
import android.net.Uri;

public class Student {
   private String name;
   private String id;
   private Uri image;


    public Student(String name, String id, Uri image) {
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
