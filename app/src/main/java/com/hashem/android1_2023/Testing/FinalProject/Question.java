package com.hashem.android1_2023.Testing.FinalProject;

import android.net.Uri;

import java.util.Arrays;

public class Question {
    private int id;
    private int QuestionType;
    private String questionText;
    private int marks;
    private Uri image;
    private String Answer;
    private String[] choices;

    public Question(int id, int questionType, String questionText, int marks, Uri image, String answer) {
        this.id = id;
        QuestionType = questionType;
        this.questionText = questionText;
        this.marks = marks;
        this.image = image;
        Answer = answer;
    }

    public Question(int id, int questionType, String questionText, int marks, Uri image, String answer, String[] choices) {
        this.id = id;
        QuestionType = questionType;
        this.questionText = questionText;
        this.marks = marks;
        this.image = image;
        Answer = answer;
        this.choices = choices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public int getQuestionType() {
        return QuestionType;
    }

    public void setQuestionType(int questionType) {
        QuestionType = questionType;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", QuestionType=" + QuestionType +
                ", questionText='" + questionText + '\'' +
                ", marks=" + marks +
                ", image=" + image +
                ", Answer='" + Answer + '\'' +
                ", choices=" + Arrays.toString(choices) +
                '}';
    }
}
