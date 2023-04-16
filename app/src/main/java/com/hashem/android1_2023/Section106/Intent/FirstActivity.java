package com.hashem.android1_2023.Section106.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hashem.android1_2023.R;

public class FirstActivity extends AppCompatActivity {
    Button goToSecondScreen;
    EditText nameEt,ageEt;
    public static final String TAG = "lifeCycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first3);

        Log.d(TAG, "onCreate: ");
        
        goToSecondScreen = findViewById(R.id.goToSecond);
        nameEt = findViewById(R.id.nameEt);
        ageEt = findViewById(R.id.ageEt);


        goToSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEt.getText().toString();
                int age = Integer.parseInt(ageEt.getText().toString());

                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("age",age);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}