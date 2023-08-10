package com.hashem.android1_2023.Testing.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityForm5Binding;

public class FormActivity extends AppCompatActivity {

    ActivityForm5Binding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    boolean isSubmitted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForm5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("MyFormData", MODE_PRIVATE);
//        PreferenceManager.getDefaultSharedPreferences(this);
//        getPreferences(MODE_PRIVATE);
        editor = preferences.edit();


        if (!preferences.getString("name", "NoData").equals("NoData"))
            binding.nameEt.setText(preferences.getString("name", "NoData"));

        if (!preferences.getString("email", "NoData").equals("NoData"))
            binding.emailEt.setText(preferences.getString("email", "NoData"));

//            if (preferences.getInt("birthYear", -1) != -1)
//                binding.birthYearEt.setText(String.valueOf(preferences.getInt("birthYear", -1)));
        if (!preferences.getString("jobTitle", "NoData").equals("NoData"))
            binding.jobTitleEt.setText(preferences.getString("jobTitle", "NoData"));

        if (!preferences.getString("birthYear", "NoData").equals("NoData"))
            binding.birthYearEt.setText(preferences.getString("birthYear", "NoData"));

//            if (preferences.getInt("birthYear", -1) != -1)
//                binding.yearsOfServiceEt.setText(String.valueOf(preferences.getInt("yearsOfService", -1)));
        if (!preferences.getString("yearsOfService", "NoData").equals("NoData"))
            binding.yearsOfServiceEt.setText(preferences.getString("yearsOfService", "NoData"));

        if (!preferences.getString("city", "NoData").equals("NoData"))
            binding.cityEt.setText(preferences.getString("city", "NoData"));

        if (!preferences.getString("street", "NoData").equals("NoData"))
            binding.streetEt.setText(preferences.getString("street", "NoData"));


        binding.submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSubmitted = true;
                editor.clear().apply();
            }
        });
        binding.clearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.nameEt.setText("");
                binding.emailEt.setText("");
                binding.birthYearEt.setText("");
                binding.jobTitleEt.setText("");
                binding.yearsOfServiceEt.setText("");
                binding.cityEt.setText("");
                binding.streetEt.setText("");
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!isSubmitted) {
            editor.putString("name", binding.nameEt.getText().toString());
            editor.putString("email", binding.emailEt.getText().toString());
            editor.putString("birthYear", binding.birthYearEt.getText().toString());
            editor.putString("jobTitle", binding.jobTitleEt.getText().toString());
            editor.putString("yearsOfService", binding.yearsOfServiceEt.getText().toString());
            editor.putString("city", binding.cityEt.getText().toString());
            editor.putString("street", binding.streetEt.getText().toString());
            editor.apply();

        }
    }
}