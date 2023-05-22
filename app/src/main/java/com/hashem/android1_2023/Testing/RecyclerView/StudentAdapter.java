package com.hashem.android1_2023.Testing.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemNewItemBinding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    ArrayList<Student> students;
    MyListener myListener;

    public StudentAdapter(ArrayList<Student> students,MyListener myListener) {
        this.students = students;
        this.myListener = myListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewItemBinding binding = ItemNewItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        int index = position;
        Student s = students.get(position);
        holder.studentName.setText(s.getName());
        holder.studentId.setText(s.getId());
        holder.studentImage.setImageURI(s.getImage());
        holder.deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListener.onDelete(holder.getAdapterPosition());
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemView.setBackgroundColor(Color.CYAN);
            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView studentId;
        ImageView deleteBt;
        ImageView studentImage;
        public StudentViewHolder(@NonNull ItemNewItemBinding binding) {
            super(binding.getRoot());
            studentName = binding.studentNameTv;
            studentId = binding.studentIdTv;
            deleteBt = binding.deleteBt;
            studentImage = binding.studentImageIv;
        }

    }
}
