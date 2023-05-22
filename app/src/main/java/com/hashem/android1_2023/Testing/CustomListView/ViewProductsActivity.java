package com.hashem.android1_2023.Testing.CustomListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityViewProductsBinding;

import java.util.ArrayList;

public class ViewProductsActivity extends AppCompatActivity {
    ActivityViewProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Milk",1,20,100));
        products.add(new Product("Bread",2,30,300));

        ProductAdapter adapter = new ProductAdapter(products,this);

        binding.productsLv.setAdapter(adapter);


    }
}