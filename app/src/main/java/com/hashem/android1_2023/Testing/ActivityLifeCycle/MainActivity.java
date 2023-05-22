package com.hashem.android1_2023.Testing.ActivityLifeCycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hashem.android1_2023.R;

public class MainActivity extends AppCompatActivity {
    TextView nameTv;
    EditText nameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycle", "onCreate: ");
        setContentView(R.layout.activity_main3);

        nameEt = findViewById(R.id.nameEt);
        Button nameBt = findViewById(R.id.nameBt);
        nameTv = findViewById(R.id.nameTv);
        Button hideBt = findViewById(R.id.hideBt);

        nameBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                nameTv.setText(name);
            }
        });
        hideBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nameTv.setVisibility(View.INVISIBLE);
//                AlertDialog dialog = new AlertDialog.Builder(LoginActivity.this)
//                        .setTitle("dialog")
//                        .setMessage("this is dialog")
//                        .setPositiveButton("click here", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                            }
//                        })
//                        .setIcon(R.drawable.ic_fav)
//                        .show();
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "onRestart: ");
        nameTv.setVisibility(View.VISIBLE);
        nameEt.setText("");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", nameEt.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nameTv.setText(savedInstanceState.getString("name"));
//        nameTv.setVisibility(View.INVISIBLE);


    }
}