package com.hashem.android1_2023.Testing.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hashem.android1_2023.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("name","ahmed");
        intent.putExtra("age",26);
        startActivity(intent);
    }
}