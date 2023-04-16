package com.hashem.android1_2023.Testing.FinalProject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemExamBinding;

import java.util.ArrayList;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {
    ArrayList<Exam> exams;

    public ExamAdapter(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemExamBinding binding = ItemExamBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ExamViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        Exam e = exams.get(position);
        holder.examNameTv.setText(e.getExamName());
        holder.examIdTv.setText(String.valueOf(e.getExamId()));
        holder.numOfQuestionsTv.setText(String.valueOf(e.getNumberOfQuestions()));
        holder.minAvgTv.setText(String.valueOf(e.getMinPassAvg()));
        holder.totalMarksTv.setText(String.valueOf(e.getTotalMark()));
    }

    @Override
    public int getItemCount() {
        return exams.size();
    }

    class ExamViewHolder extends RecyclerView.ViewHolder {
        TextView examNameTv;
        TextView examIdTv;
        TextView numOfQuestionsTv;
        TextView minAvgTv;
        TextView totalMarksTv;
        public ExamViewHolder(ItemExamBinding binding) {
            super(binding.getRoot());
            examNameTv = binding.examNameTv;
            examIdTv = binding.examIdTv;
            numOfQuestionsTv = binding.numOfQuestionsTv;
            minAvgTv = binding.minAvgTv;
            totalMarksTv = binding.totalMarksTv;

        }
    }
}
