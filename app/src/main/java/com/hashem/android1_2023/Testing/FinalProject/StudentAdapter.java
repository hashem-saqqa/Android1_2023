package com.hashem.android1_2023.Testing.FinalProject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemStudentBinding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    ArrayList<User> students;

    public StudentAdapter(ArrayList<User> students) {
        this.students = students;
        Log.d("TestingRv", "onCreate: 1 "+students.size());
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudentBinding binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        User s = students.get(position);
        holder.studentNameTv.setText(s.getName());
        holder.studentIdTv.setText(String.valueOf(s.getId()));
        holder.usernameTv.setText(s.getUsername());
        holder.genderTv.setText(s.getGender());
        Log.d("TestingRv", "onCreate: 2 ");
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameTv;
        TextView studentIdTv;
        TextView usernameTv;
        TextView genderTv;
        public StudentViewHolder(ItemStudentBinding binding) {
            super(binding.getRoot());
            studentNameTv = binding.studentNameTv;
            studentIdTv = binding.studentIdTv;
            usernameTv = binding.usernameTv;
            genderTv = binding.genderTv;
        }
    }
}
