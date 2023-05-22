package com.hashem.android1_2023.Section101.CustomListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityProductsView2Binding;

import java.util.ArrayList;

public class ProductsViewActivity extends AppCompatActivity {
    ActivityProductsView2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"Milk",20,200));
        products.add(new Product(2,"Bread",30,300));
        products.add(new Product(3,"Sugar",10,500));

        ProductAdapter adapter = new ProductAdapter(products,this);

        binding.productsLv.setAdapter(adapter);


    }
}