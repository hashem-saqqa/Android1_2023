package com.hashem.android1_2023.Section106.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityMyFormBinding;

public class MyFormActivity extends AppCompatActivity {

    ActivityMyFormBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    boolean isSubmitted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        getPreferences(MODE_PRIVATE);
//
//        PreferenceManager.getDefaultSharedPreferences(this);

        preferences = getSharedPreferences(getString(R.string.SharedPreferenceName), MODE_PRIVATE);

        editor = preferences.edit();

        if (!preferences.getString("name","NoData").equals("NoData"))
        binding.nameEt.setText(preferences.getString("name","NOData"));

        if (!preferences.getString("email","NoData").equals("NoData"))
        binding.emailEt.setText(preferences.getString("email","NOData"));

        if (!preferences.getString("birthYear","NoData").equals("NoData"))
        binding.birthYearEt.setText(preferences.getString("birthYear","NOData"));

        if (!preferences.getString("city","NoData").equals("NoData"))
        binding.cityEt.setText(preferences.getString("city","NOData"));

        if (!preferences.getString("jobTitle","NoData").equals("NoData"))
        binding.jobTitleEt.setText(preferences.getString("jobTitle","NOData"));

        if (!preferences.getString("yearsOfService","NoData").equals("NoData"))
        binding.yearsOfServiceEt.setText(preferences.getString("yearsOfService","NOData"));


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
            String name = binding.nameEt.getText().toString();
            editor.putString("name",name);
            editor.putString("email",binding.emailEt.getText().toString());
            editor.putString("birthYear",binding.birthYearEt.getText().toString());
            editor.putString("city",binding.cityEt.getText().toString());
            editor.putString("jobTitle",binding.jobTitleEt.getText().toString());
            editor.putString("yearsOfService",binding.yearsOfServiceEt.getText().toString());
            editor.apply();
        }




    }
}