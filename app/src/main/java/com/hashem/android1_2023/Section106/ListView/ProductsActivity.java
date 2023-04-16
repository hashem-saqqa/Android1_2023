package com.hashem.android1_2023.Section106.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityProductsBinding;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityProductsBinding binding;
    ArrayList<String> products;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        products = new ArrayList<>();
        products.add("Milk");
        products.add("Bread");
        products.add("Soda");
        products.add("XL");
        products.add("Chocolate");


        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,products);

        binding.productsLv.setAdapter(adapter);

        binding.productsLv.setOnItemClickListener(this);

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = binding.productNameEt.getText().toString();

                products.add(productName);
                adapter.notifyDataSetChanged();

            }
        });
//        binding.productsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                String productName = products.get(i);
////
////                startActivity(new Intent(getApplicationContext(),
////                        ProductDetails.class).putExtra("productName",productName));
//
//                Log.d("testingIndex", "onItemClick 1: "+i);
//                int p = i;
//
//               new AlertDialog.Builder(ProductsActivity.this)
//                       .setTitle("r u sure u want to delete "+products.get(i)+" ?")
//                       .setMessage("this item will be deleted forever")
//                       .setIcon(R.drawable.ic_exit)
//                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialogInterface, int i) {
//
//                               Log.d("testingIndex", "onItemClick 2: "+i);
//                               products.remove(p);
//                               adapter.notifyDataSetChanged();
//                               Log.d("testingIndex", "onItemClick 3: "+i);
//
//
//                           }
//                       })
//                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                           @Override
//                           public void onClick(DialogInterface dialogInterface, int i) {
//
//                           }
//                       })
//                       .setCancelable(false)
//                       .show();
//            }
//        });



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        String productName = products.get(i);
//
//                startActivity(new Intent(getApplicationContext(),
//                        ProductDetails.class).putExtra("productName",productName));

                Log.d("testingIndex", "onItemClick 1: "+i);
                int p = i;

               new AlertDialog.Builder(ProductsActivity.this)
                       .setTitle("r u sure u want to delete "+products.get(i)+" ?")
                       .setMessage("this item will be deleted forever")
                       .setIcon(R.drawable.ic_exit)
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {

                               Log.d("testingIndex", "onItemClick 2: "+i);
                               products.remove(p);
                               adapter.notifyDataSetChanged();
                               Log.d("testingIndex", "onItemClick 3: "+i);


                           }
                       })
                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {

                           }
                       })
                       .setCancelable(false)
                       .show();
    }
}