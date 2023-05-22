package com.hashem.android1_2023.Section106.SqliteDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityShowContactsBinding;

import java.util.ArrayList;

public class ShowContactsActivity extends AppCompatActivity {

    ActivityShowContactsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowContactsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDatabase db = new MyDatabase(this);

        ArrayList<Contact> contacts = db.getAllContacts();

        ContactAdapter adapter = new ContactAdapter(contacts);
        binding.contactsRv.setAdapter(adapter);
        binding.contactsRv.setLayoutManager(new LinearLayoutManager(this));




    }
}