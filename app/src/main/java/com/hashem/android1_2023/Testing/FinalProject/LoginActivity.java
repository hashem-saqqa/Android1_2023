package com.hashem.android1_2023.Testing.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityLoginScreenBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDataBase db = new MyDataBase(this);

//        MyDataBase db = new MyDataBase(this);
        boolean result =  db.insertUser(new User(120180001,2,"s1","123456","Ahmed Ali","1/1/2000","Male"));
        boolean result1 = db.insertQuestion(new Question(1,1,"Does Java can build GUI?",2,  null,"yes"));
//        Log.d("TAGgg", "onCreate:0 "+result);
//        Log.d("TAGgg", "onCreate:1 "+result1);

//        Utils.generateData(this);

        binding.loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.usernameEt.getText().toString();
                String password = binding.passwordEt.getText().toString();
                if (username.equals("admin")){
                    if (password.equals("admin")){
                        Intent intent = new Intent(getApplicationContext(),AdminMainMenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Check the Password", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    for (User user : db.getAllTeachers()) {
                        if (user.getUsername().equals(username)) {
                            if (user.getPassword().equals(password)) {
                                    Intent intent = new Intent(getApplicationContext(),TeacherMainMenuActivity.class);
                                    startActivity(intent);
                                    return;
                            } else {
                                Toast.makeText(LoginActivity.this, "Check the password", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } else {
                            // TODO: 13/04/2023 handle this
                        }
                    }
                    for (User user:db.getAllStudents()) {
                        if (user.getUsername().equals(username)) {
                            if (user.getPassword().equals(password)) {
                                    Intent intent = new Intent(getApplicationContext(),StudentMainMenuActivity.class);
                                    startActivity(intent);
                                    return;
                            } else {
                                Toast.makeText(LoginActivity.this, "Check the password", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } else {
                            // TODO: 13/04/2023 handle this
                        }
                    }
                    Toast.makeText(LoginActivity.this, "There is no user with this Username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}