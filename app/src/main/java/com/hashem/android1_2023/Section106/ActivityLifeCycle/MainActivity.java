package com.hashem.android1_2023.Section106.ActivityLifeCycle;

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
    boolean isVisible = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Log.d("lifeCycle", "this is onCreate");

        nameEt = findViewById(R.id.nameEt);
        nameButton = findViewById(R.id.nameBt);
        hideBt = findViewById(R.id.hideBt);

        nameTv = findViewById(R.id.nameTv);


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
                if (isVisible) {
                    nameTv.setVisibility(View.INVISIBLE);
                    isVisible = false;

                } else {
                    nameTv.setVisibility(View.VISIBLE);
                    isVisible = true;
                }

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
    protected void onRestart() {
        super.onRestart();
        Log.e("lifeCycle", "this is onRestart");
        nameTv.setVisibility(View.VISIBLE);
        isVisible = true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String name = nameTv.getText().toString();
        int color = nameTv.getCurrentTextColor();
        outState.putInt("color",color);
        outState.putString("name",name);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("name","notFound");
        int color = savedInstanceState.getInt("color");
        nameTv.setText(name);
        nameTv.setTextColor(color);
    }
}