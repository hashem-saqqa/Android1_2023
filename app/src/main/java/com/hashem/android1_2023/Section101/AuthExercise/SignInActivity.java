package com.hashem.android1_2023.Section101.AuthExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.Testing.AuthExercise.Login;
import com.hashem.android1_2023.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signInBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailEt.getText().toString();
                String password = binding.passwordEt.getText().toString();

                if (!email.equals("") && !password.equals("")){
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("email",email);
                    intent.putExtra("password",password);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignInActivity.this, "please fill the Data", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}