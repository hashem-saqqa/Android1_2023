package com.hashem.android1_2023.Section101.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityMyForm2Binding;

public class MyFormActivity extends AppCompatActivity {

    ActivityMyForm2Binding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    boolean isSubmitted = false;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyForm2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getPreferences(MODE_PRIVATE);

        PreferenceManager.getDefaultSharedPreferences(this);

        preferences = getSharedPreferences(getString(R.string.SharedPreferenceName101), MODE_PRIVATE);

        editor = preferences.edit();

        if (!preferences.getString("name","NoData").equals("NoData"))
        binding.nameET.setText(preferences.getString("name","NoData"));

        if (!preferences.getString("email","NoData").equals("NoData"))
        binding.emailET.setText(preferences.getString("email","NoData"));

        if (!preferences.getString("city","NoData").equals("NoData"))
        binding.cityET.setText(preferences.getString("city","NoData"));

        if (!preferences.getString("jobTitle","NoData").equals("NoData"))
        binding.jobTitleET.setText(preferences.getString("jobTitle","NoData"));

        if (!preferences.getString("birthYear","NoData").equals("NoData"))
        binding.birthYearET.setText(preferences.getString("birthYear","NoData"));

        if (!preferences.getString("yearsOfServices","NoData").equals("NoData"))
        binding.yearsOfServiceEt.setText(preferences.getString("yearsOfServices","NoData"));

        binding.submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSubmitted = true;
                editor.clear().apply();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!isSubmitted){
            String name = binding.nameET.getText().toString();
            editor.putString("name", name);
            editor.putString("email", binding.emailET.getText().toString());
            editor.putString("city", binding.cityET.getText().toString());
            editor.putString("jobTitle", binding.jobTitleET.getText().toString());
            editor.putString("birthYear", binding.birthYearET.getText().toString());
            editor.putString("yearsOfServices", binding.yearsOfServiceEt.getText().toString());
            editor.apply();
        }



    }
}