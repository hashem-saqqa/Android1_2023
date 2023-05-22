package com.hashem.android1_2023.Testing.CustomListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hashem.android1_2023.databinding.ItemProductsTestingBinding;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    List<Product> products;
    Context context;

    public ProductAdapter(List<Product> products, Context context) {
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
        ItemProductsTestingBinding binding = ItemProductsTestingBinding.inflate(LayoutInflater.from(viewGroup.getContext()));
        binding.productIdTv.setText(String.valueOf(products.get(i).getProductId()));
        binding.productNameTv.setText(products.get(i).getProductName());
        binding.productPriceTv.setText(String.valueOf(products.get(i).getProductPrice()));
        binding.productQuantityTv.setText(String.valueOf(products.get(i).getProductQuantity()));


        return binding.getRoot();
    }
}
