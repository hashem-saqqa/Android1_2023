package com.hashem.android1_2023.Testing.MidExam;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityCarsBinding;

import java.util.ArrayList;

public class CarsActivity extends AppCompatActivity {

    ActivityCarsBinding binding;
    ArrayList<String> cars;
    ArrayAdapter<String> adapter;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    String newCarName = result.getData().getStringExtra("carName");
                    int carIndex = result.getData().getIntExtra("carIndex",-1);

                    cars.set(carIndex,newCarName);
                    adapter.notifyDataSetChanged();


                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cars = new ArrayList<>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cars);

        binding.carsLv.setAdapter(adapter);

        binding.addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String carName = binding.carNameEt.getText().toString();
                cars.add(carName);
                adapter.notifyDataSetChanged();

            }
        });
        binding.carsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), EditCarActivity.class);
                intent.putExtra("carName", cars.get(i));
                intent.putExtra("carIndex", i);
                launcher.launch(intent);
            }
        });

    }
}