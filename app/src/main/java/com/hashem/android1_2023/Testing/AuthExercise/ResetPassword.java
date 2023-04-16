package com.hashem.android1_2023.Testing.AuthExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hashem.android1_2023.R;

public class ResetPassword extends AppCompatActivity {

    EditText emailEt,passwordEt;
    Button resetBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        String receivedEmail = getIntent().getStringExtra("email");

        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.newPasswordEt);
        resetBt = findViewById(R.id.resetBt);

        resetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();

                if (email.equals("") && password.equals("")){
                    Toast.makeText(ResetPassword.this, "Fill all Fields", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("newPassword",password);
                    setResult(101,intent);
                    finish();
                }


            }
        });
    }
}