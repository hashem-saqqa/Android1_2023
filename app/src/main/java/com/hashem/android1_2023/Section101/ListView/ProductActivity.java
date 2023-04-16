package com.hashem.android1_2023.Section101.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityProductBinding;
import com.hashem.android1_2023.databinding.ActivityProductsBinding;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityProductBinding binding;
    ArrayAdapter<String> adapter;
    ArrayList<String> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        products = new ArrayList<>();
        products.add("Milk");
        products.add("Bread");
        products.add("Sugar");
        products.add("Sugar");
        products.add("Chocolate");

        adapter = new ArrayAdapter<>(ProductActivity.this,
                android.R.layout.simple_list_item_1,products);

        binding.productsLv.setAdapter(adapter);


        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = binding.productNameET.getText().toString();

                products.add(productName);

                adapter.notifyDataSetChanged();

            }
        });

        binding.productsLv.setOnItemClickListener(this);

//        binding.productsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Log.d("testingIndex", "onClick 1: "+i);
//                int p = i;
//                new AlertDialog.Builder(ProductActivity.this)
//                        .setTitle("R u sure u want to delete "+products.get(i))
//                        .setMessage("the item will be deleted forever")
//                        .setIcon(R.drawable.ic_exit)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                                Log.d("testingIndex", "onClick 2: "+i);
//                                products.remove(p);
//                                adapter.notifyDataSetChanged();
//
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                            }
//                        })
//                        .setCancelable(false)
//                        .show();
//
//            }
//        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int p = i;
                new AlertDialog.Builder(ProductActivity.this)
                        .setTitle("R u sure u want to delete "+products.get(i))
                        .setMessage("the item will be deleted forever")
                        .setIcon(R.drawable.ic_exit)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                products.remove(p);
                                adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setCancelable(false)
                        .show();

            }
    }