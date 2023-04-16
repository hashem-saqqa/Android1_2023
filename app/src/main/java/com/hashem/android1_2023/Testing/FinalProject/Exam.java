package com.hashem.android1_2023.Testing.FinalProject;

import java.util.ArrayList;

public class Exam {
    private int examId;
    String examName;
    private int numberOfQuestions;
    private int minPassAvg;
    private int[] allowedQuestionsType;
    private int totalMark;
    private int[] questionsIndices;
    ArrayList<Question> questions;

    public Exam(String examName, int numberOfQuestions, int minPassAvg, int[] allowedQuestionsType, int[] questionsIndices, int totalMark,
                ArrayList<Question> questions) {
        this.examName = examName;
        this.numberOfQuestions = numberOfQuestions;
        this.minPassAvg = minPassAvg;
        this.allowedQuestionsType = allowedQuestionsType;
        this.totalMark = totalMark;
        this.questionsIndices = questionsIndices;
        this.questions = questions;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getMinPassAvg() {
        return minPassAvg;
    }

    public void setMinPassAvg(int minPassAvg) {
        this.minPassAvg = minPassAvg;
    }

    public int[] getAllowedQuestionsType() {
        return allowedQuestionsType;
    }

    public void setAllowedQuestionsType(int[] allowedQuestionsType) {
        this.allowedQuestionsType = allowedQuestionsType;
    }

    public int[] getQuestionsIndices() {
        return questionsIndices;
    }

    public void setQuestionsIndices(int[] questionsIndices) {
        this.questionsIndices = questionsIndices;
    }
}
