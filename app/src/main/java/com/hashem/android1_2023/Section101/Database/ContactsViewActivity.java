package com.hashem.android1_2023.Section101.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityContactsViewBinding;

import java.util.ArrayList;

public class ContactsViewActivity extends AppCompatActivity {
    ActivityContactsViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        MyDatabase db = new MyDatabase(this);

        ArrayList<Contact> contacts = db.getAllContacts();
        Log.d("getDataTest", "onCreate: "+contacts);


        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.nameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phone = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());

                Contact c = new Contact(name,email,phone,year);
                long r =  db.insertContact(c);
            }
        });
        binding.deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(binding.idEt.getText().toString());

                int result = db.deleteContact(id);

                if (result > 0){
                    Toast.makeText(ContactsViewActivity.this, "delete successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ContactsViewActivity.this, "delete failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(binding.idEt.getText().toString());
                String name = binding.nameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phone = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());

                Contact c = new Contact(name,email,phone,year);
                c.setId(id);

                int result = db.updateContact(c);

                if (result > 0){
                    Toast.makeText(ContactsViewActivity.this, "update successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ContactsViewActivity.this, "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}