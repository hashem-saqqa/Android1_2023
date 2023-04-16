package com.hashem.android1_2023.Section106.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityProductDetails2Binding;

public class ProductDetails extends AppCompatActivity {

    ActivityProductDetails2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetails2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String productName = getIntent().getStringExtra("productName");

        binding.productNameTv.setText(productName);

    }
}