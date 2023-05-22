package com.hashem.android1_2023.Section101.CustomListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hashem.android1_2023.databinding.ItemProductBinding;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Product> products;
    Context context;

    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemProductBinding binding = ItemProductBinding.inflate(
                LayoutInflater.from(viewGroup.getContext()),viewGroup,false);

        Product p = products.get(i);
        binding.productNameTv.setText(p.getProductName());
        binding.productIdTv.setText(String.valueOf(p.getProductId()));
        binding.productPriceTv.setText(String.valueOf(p.getProductPrice()));
        binding.productQuantityTv.setText(String.valueOf(p.getProductQuantity()));

        return binding.getRoot();
    }
}
