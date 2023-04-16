package com.hashem.android1_2023.Section101.AlertDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityForm2Binding;

public class FormActivity extends AppCompatActivity {
    ActivityForm2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForm2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        AlertDialog.Builder dialog = new AlertDialog.Builder(FormActivity.this)
                .setTitle("r u sure?")
                .setMessage("the data will ......")
                .setIcon(R.drawable.ic_form)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }) ;

        binding.submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                AlertDialog.Builder dialog = new AlertDialog.Builder(FormActivity.this);
//                dialog.setTitle("Are you sure ?");
//                dialog.setMessage("the data will be sent to the server");
//                dialog.setIcon(R.drawable.ic_form);
//                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FormActivity.this, "Data sent", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FormActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FormActivity.this, "process canceled", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                dialog.setCancelable(false);
//
//                dialog.show();
               dialog.show();

            }
        });


    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(FormActivity.this)
                .setTitle("Are u sure u want to Exit")
                .setMessage("all the data will be lost")
                .setIcon(R.drawable.ic_exit)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FormActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setCancelable(false).
                show();

    }
}