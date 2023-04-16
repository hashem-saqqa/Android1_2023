package com.hashem.android1_2023.Testing.AuthExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hashem.android1_2023.R;

public class SignInScreen extends AppCompatActivity {
    EditText usernameEt,emailEt,passwordEt,mobileEt;
    Button signInBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        usernameEt = findViewById(R.id.usernameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        mobileEt = findViewById(R.id.mobileEt);
        signInBt = findViewById(R.id.signInBt);

        signInBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (emailEt.getText().toString().equals("") && usernameEt.getText().toString().equals("")
//                && passwordEt.getText().toString().equals("") && mobileEt.getText().toString().equals("")){
//                    Toast.makeText(SignInScreen.this, "Fill all Fields pls", Toast.LENGTH_SHORT).show();
//                }else{

                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    intent.putExtra("email",emailEt.getText().toString());
                    intent.putExtra("password",passwordEt.getText().toString());
                    startActivity(intent);

//                }
            }
        });
    }
}