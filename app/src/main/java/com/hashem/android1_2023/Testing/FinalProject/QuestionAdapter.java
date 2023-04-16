package com.hashem.android1_2023.Testing.FinalProject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashem.android1_2023.databinding.ItemQuestionBinding;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    ArrayList<Question> questions;

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemQuestionBinding binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new QuestionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question q = questions.get(position);
        holder.questionTextTv.setText(q.getQuestionText());
        holder.questionIdTv.setText(String.valueOf(q.getId()));
        switch (q.getQuestionType()) {
            case 1:
                holder.questionTypeTv.setText("Yes-No");
                break;
            case 2:
                holder.questionTypeTv.setText("Multiple Choice");
                break;
            case 3:
                holder.questionTypeTv.setText("Fill the Blank");
                break;
        }
        holder.markTv.setText(String.valueOf(q.getMarks()));

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextTv;
        TextView questionIdTv;
        TextView questionTypeTv;
        TextView markTv;

        public QuestionViewHolder(ItemQuestionBinding binding) {
            super(binding.getRoot());
            questionTextTv = binding.questionTextTv;
            questionIdTv = binding.questionIdTv;
            questionTypeTv = binding.questionTypeTv;
            markTv = binding.markTv;
        }
    }
}
