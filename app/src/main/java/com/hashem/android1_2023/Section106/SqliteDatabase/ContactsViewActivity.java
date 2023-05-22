package com.hashem.android1_2023.Section106.SqliteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityContactsView2Binding;

import java.util.ArrayList;

public class ContactsViewActivity extends AppCompatActivity {
    ActivityContactsView2Binding binding;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactsView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabase(this);

        ArrayList<Contact> contacts = db.getAllContacts();

        Log.d("getDataTesting", "onCreate: "+contacts);

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.nameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phone  = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());

                Contact c = new Contact(name,email,phone,year);

                long r = db.insertContact(c);
            }
        });
        binding.deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(binding.idEt.getText().toString());
               int result = db.deleteContact(id);
                if (result > 0){
                    Toast.makeText(ContactsViewActivity.this, "delete successfully", Toast.LENGTH_SHORT).show();
                }else {
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
                String phone  = binding.phoneEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());

                Contact contact = new Contact(name,email,phone,year);
                contact.setId(id);

                int result = db.updateContact(contact);
                if (result > 0){
                    Toast.makeText(ContactsViewActivity.this, "update successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ContactsViewActivity.this, "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShowContactsActivity.class);
                startActivity(intent);
            }
        });


    }

}