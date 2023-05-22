package com.hashem.android1_2023.Section106.RecyclerViewPart2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemStudent3Binding;

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
        ItemStudent3Binding binding = ItemStudent3Binding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

        int index = position;
        Student s = students.get(index);

        holder.studentId.setText(String.valueOf(s.getId()));
        holder.studentName.setText(s.getName());
        holder.studentGpa.setText(String.valueOf(s.getGPA()));
        holder.studentField.setText(s.getField());

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelete(index);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               holder.itemView.setBackgroundColor(Color.CYAN);
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
        TextView studentName, studentId, studentGpa, studentField;
        ImageView deleteIv, editIv;

        public StudentViewHolder(ItemStudent3Binding binding) {
            super(binding.getRoot());

            studentName = binding.studentNameTv;
            studentId = binding.studentIdTv;
            studentGpa = binding.studentGpaTv;
            studentField = binding.studentFieldTv;
            deleteIv = binding.deleteIv;
            editIv = binding.editIv;

        }
    }
}
