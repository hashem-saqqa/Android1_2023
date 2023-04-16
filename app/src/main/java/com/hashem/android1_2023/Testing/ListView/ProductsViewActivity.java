package com.hashem.android1_2023.Testing.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityProductsViewBinding;

import java.util.ArrayList;

public class ProductsViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityProductsViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> productsName = new ArrayList<>();
        productsName.add("Milk");
        productsName.add("Bread");
        productsName.add("XL");
        productsName.add("soda");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,productsName);

        binding.productsLv.setAdapter(adapter);
        binding.productsLv.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "tasting", Toast.LENGTH_SHORT).show();
    }
}