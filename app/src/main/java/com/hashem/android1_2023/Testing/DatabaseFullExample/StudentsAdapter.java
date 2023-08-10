package com.hashem.android1_2023.Testing.DatabaseFullExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemStudentFullExampleBinding;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {

    ArrayList<Student> students;
    StudentListener listener;

    public StudentsAdapter(ArrayList<Student> students, StudentListener listener) {
        this.students = students;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudentFullExampleBinding binding = ItemStudentFullExampleBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        int pos = position;
        Student s = students.get(pos);

        holder.studentId.setText(String.valueOf(s.getId()));
        holder.studentName.setText(String.valueOf(s.getName()));
        holder.studentGPA.setText(String.valueOf(s.getGPA()));
        holder.studentField.setText(String.valueOf(s.getField()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(pos);
            }
        });
        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelete(s.getId(), pos);
            }
        });
        holder.editIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEdit(s.getId(), pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentId, studentName, studentGPA, studentField;
        ImageView deleteIv, editIv;
        public StudentViewHolder(ItemStudentFullExampleBinding binding) {
            super(binding.getRoot());
            studentId = binding.studentIdTv;
            studentName = binding.studentNameTv;
            studentGPA = binding.studentGpaTv;
            studentField = binding.studentFieldTv;
            deleteIv = binding.deleteIv;
            editIv = binding.editIv;


        }
    }
}
