package com.hashem.android1_2023.Section101.ActivityLifeCycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hashem.android1_2023.R;

public class MainActivity extends AppCompatActivity {
    TextView nameTv;
    EditText nameEt;
    Button nameButton, hideBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Log.d("lifeCycle", "this is onCreate");


        nameEt = findViewById(R.id.nameEt);
        nameButton = findViewById(R.id.nameBt);
        nameTv = findViewById(R.id.nameTv);
        hideBt = findViewById(R.id.hideBt);


        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                nameTv.setText(name);
            }
        });

        hideBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameTv.getVisibility() == View.VISIBLE)
                    nameTv.setVisibility(View.INVISIBLE);
                else
                    nameTv.setVisibility(View.VISIBLE);
            }
        });

        nameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nameTv.setTextColor(Color.parseColor("#ff0000"));
                nameTv.setTextColor(Color.RED);
            }
        });


    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeCycle", "this is onRestart");
        nameTv.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle", "this is onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "this is onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "this is onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "this is onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "this is onDestroy");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String name = nameTv.getText().toString();
        outState.putString("name",name);
        outState.putInt("age",15);
        outState.putString("TextView_Color","#ff0000");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       String name = savedInstanceState.getString("name","notFound");
       int age = savedInstanceState.getInt("age");
       String color = savedInstanceState.getString("TextView_Color");
       nameTv.setText(name);
       nameTv.setTextColor(Color.parseColor(color));


    }
}