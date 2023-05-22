package com.hashem.android1_2023.Section101.RecyclerViewPart2;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemStudent4Binding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    ArrayList<Student> students;
    StudentListener listener;


    public StudentAdapter(ArrayList<Student> students, StudentListener listener) {
        this.students = students;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudent4Binding binding = ItemStudent4Binding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);

        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        int index = position;
        Student s = students.get(index);
        holder.studentNameTv.setText(s.getName());
        holder.studentIdTv.setText(String.valueOf(s.getId()));
        holder.studentGpaTV.setText(String.valueOf(s.getGPA()));
        holder.studentFieldTv.setText(s.getField());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemView.setBackgroundColor(Color.CYAN);
            }
        });

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelete(index);
            }
        });

        holder.editIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEdit(index);
            }
        });



    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameTv, studentIdTv, studentGpaTV, studentFieldTv;
        ImageView deleteIv, editIv;

        public StudentViewHolder(ItemStudent4Binding binding) {
            super(binding.getRoot());
            studentNameTv = binding.studentNameTv;
            studentIdTv = binding.studentIdTv;
            studentGpaTV = binding.studentGpaTv;
            studentFieldTv = binding.studentFieldTv;
            deleteIv = binding.deleteIv;
            editIv = binding.editIv;
        }
    }
}
