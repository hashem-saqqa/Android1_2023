package com.hashem.android1_2023.Section106.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ItemStudent2Binding;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudent2Binding binding = ItemStudent2Binding.inflate(LayoutInflater.from(context),parent,false);

        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder,int position) {

        int index  = position;

        Student s = students.get(position);

        holder.studentName.setText(s.getName());
        holder.studentId.setText(String.valueOf(s.getId()));
        holder.studentGpa.setText(String.valueOf(s.getGPA()));
        holder.studentField.setText(s.getField());

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(index);
                notifyDataSetChanged();
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

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView studentId;
        TextView studentGpa;
        TextView studentField;
        ImageView deleteIv;
        public StudentViewHolder(ItemStudent2Binding binding) {
            super(binding.getRoot());
            studentName = binding.studentNameTv;
            studentId = binding.studentIdTv;
            studentGpa = binding.studentGpaTv;
            studentField = binding.studentFieldTv;
            deleteIv = binding.deleteIv;
        }
    }

}
