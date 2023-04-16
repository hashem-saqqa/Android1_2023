package com.hashem.android1_2023.Testing.MidExam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityAreaPerimeterCalculatorBinding;

public class AreaPerimeterCalculator extends AppCompatActivity {
    ActivityAreaPerimeterCalculatorBinding binding;
    int shapeType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAreaPerimeterCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.calculateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shapeType == 0) {
                    int length = Integer.parseInt(binding.lengthEt.getText().toString());
                    int width = Integer.parseInt(binding.widthEt.getText().toString());
                    int result = length * width;
                    binding.resultTv.setText("The Area is: " + result);
                }
                if (shapeType == 1) {
                    int length = Integer.parseInt(binding.lengthEt.getText().toString());
                    int result = length * length;
                    binding.resultTv.setText("The Area is: " + result);
                }
                if (shapeType == 2) {
                    int radius = Integer.parseInt(binding.lengthEt.getText().toString());
                    double result = (radius * radius) * Math.PI;
                    binding.resultTv.setText("The Area is: " + String.format("%.2f", result));
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shapes, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rectangleItem:
                binding.lengthEt.setHint("Enter the Length of the rectangle");
                binding.widthEt.setHint("Enter the Width of the rectangle");
                binding.widthEt.setVisibility(View.VISIBLE);
                shapeType = 0;
                return true;

            case R.id.squareItem:
                binding.lengthEt.setHint("Enter the Length of one side of the square");
                binding.widthEt.setVisibility(View.INVISIBLE);
                shapeType = 1;
                return true;
            case R.id.circleItem:
                binding.lengthEt.setHint("Enter the Radius of the circle");
                binding.widthEt.setVisibility(View.INVISIBLE);
                shapeType = 2;
                return true;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Are you sure you want to Exit?")
                .setMessage("you will all lose the data!")
                .setIcon(R.drawable.ic_exit)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}