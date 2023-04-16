package com.hashem.android1_2023.Testing.AuthExercise;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hashem.android1_2023.R;

public class Login extends AppCompatActivity {

    EditText emailEt,passwordEt;
    TextView resetPasswordTv;
    Button login;
    String receivedEmail,receivedPassword;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == 101 && result.getData() != null)
                    receivedPassword = result.getData().getStringExtra("newPassword");

                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         receivedEmail = getIntent().getStringExtra("email");
         receivedPassword = getIntent().getStringExtra("password");

        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        resetPasswordTv = findViewById(R.id.resetPasswordTv);
        login = findViewById(R.id.loginBt);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();
                if (email.equals("") && password.equals("")){
                    Toast.makeText(Login.this, "Fill The Fields pls", Toast.LENGTH_SHORT).show();
                }else if (email.equals(receivedEmail) && password.equals(receivedPassword)){
                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        resetPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResetPassword.class);
                intent.putExtra("email",receivedEmail);
                launcher.launch(intent);
            }
        });


    }
}