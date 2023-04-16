package com.hashem.android1_2023.Testing.ActivityLifeCycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hashem.android1_2023.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
}