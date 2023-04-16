package com.hashem.android1_2023.Section101.AuthExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityResetPassword2Binding;

public class ResetPasswordActivity extends AppCompatActivity {

    ActivityResetPassword2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetPassword2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String receivedEmail = getIntent().getStringExtra("email");

        binding.resetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailEt.getText().toString();
                String password = binding.newPasswordEt.getText().toString();
                if (email.equals("") || password.equals("")){
                    Toast.makeText(ResetPasswordActivity.this, "Fill the Data pls", Toast.LENGTH_SHORT).show();
                }else if (email.equals(receivedEmail)){
                    Intent intent = new Intent();
                    intent.putExtra("newPassword",password);
                    setResult(101,intent);
                    finish();
                }else {
                    Toast.makeText(ResetPasswordActivity.this, "Check The email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}