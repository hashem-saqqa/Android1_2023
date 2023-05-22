package com.hashem.android1_2023.Section106.SqliteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemContactBinding;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContactBinding binding = ItemContactBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact c = contacts.get(position);
        holder.contactName.setText(c.getName());
        holder.contactEmail.setText(c.getEmail());
        holder.contactPhone.setText(c.getPhone());
        holder.contactYear.setText(String.valueOf(c.getYearOfBirth()));

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView contactName, contactEmail, contactPhone, contactYear;

        public ContactViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            contactName = binding.contactNameTv;
            contactEmail = binding.contactEmailTv;
            contactPhone = binding.contactPhoneTv;
            contactYear = binding.contactYearTv;
        }
    }
}
