package com.hashem.android1_2023.Section106.AlertDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityForm3Binding;

public class FormActivity extends AppCompatActivity {

    ActivityForm3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForm3Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());




        binding.submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(FormActivity.this);
//                dialog.setTitle("Are you sure ?");
//                dialog.setMessage("data of the form will be sent to the server");
//                dialog.setIcon(R.drawable.ic_form);
//                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FormActivity.this, "Data Sent", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FormActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
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
//                dialog.show();
               AlertDialog x = new AlertDialog.Builder(FormActivity.this)
                        .setTitle("Are you sure?")
                        .setMessage("the data will .....")
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
                        }).show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(FormActivity.this)
                .setTitle("r u sure u want 2 exit")
                .setMessage("all the data in the form will be lost")
                .setIcon(R.drawable.ic_exit)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FormActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(FormActivity.this, "process canceled", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}