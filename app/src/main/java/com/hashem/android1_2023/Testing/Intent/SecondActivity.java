package com.hashem.android1_2023.Testing.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hashem.android1_2023.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       String name =  getIntent().getStringExtra("name");
        Intent intent = getIntent();
//        int age= intent.getIntExtra("age",0);
        int age =  getIntent().getExtras().getInt("age");

        Log.d("testingt", "onCreate: "+name+" "+age);
    }
}