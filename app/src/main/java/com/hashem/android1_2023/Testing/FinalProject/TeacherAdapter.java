package com.hashem.android1_2023.Testing.FinalProject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemTeacherBinding;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {
    ArrayList<User> teachers;


    public TeacherAdapter(ArrayList<User> teachers) {
        this.teachers = teachers;
        Log.d("TestingRv", "onCreate: 1 "+teachers.size());

    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTeacherBinding binding = ItemTeacherBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new TeacherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        User t = teachers.get(position);
        holder.studentNameTv.setText(t.getName());
        holder.usernameTv.setText(t.getUsername());
        holder.fieldTv.setText(t.getField());
        holder.genderTv.setText(t.getGender());
        Log.d("TestingRv", "onCreate: 2 ");
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    class TeacherViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameTv;
        TextView usernameTv;
        TextView fieldTv;
        TextView genderTv;

        public TeacherViewHolder(ItemTeacherBinding binding) {
            super(binding.getRoot());
            studentNameTv = binding.studentNameTv;
            usernameTv = binding.usernameTv;
            fieldTv = binding.fieldTv;
            genderTv = binding.genderTv;
        }
    }
}
