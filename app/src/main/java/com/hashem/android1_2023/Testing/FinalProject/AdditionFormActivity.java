package com.hashem.android1_2023.Testing.FinalProject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityAdditionFormBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AdditionFormActivity extends AppCompatActivity {
    ActivityAdditionFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdditionFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDataBase db = new MyDataBase(this);

        int additionType = getIntent().getIntExtra("additionType", -1);

        if (additionType == 1) {

            binding.et1.setVisibility(View.VISIBLE);
            binding.et1.setHint("Enter the username");
            binding.et2.setVisibility(View.VISIBLE);
            binding.et2.setHint("Enter the password");
            binding.et3.setVisibility(View.VISIBLE);
            binding.et3.setHint("Enter the name");
            binding.et4.setVisibility(View.VISIBLE);
            binding.et4.setHint("Enter the birthdate");
            binding.et5.setVisibility(View.VISIBLE);
            binding.et5.setHint("Enter the salary");
            binding.et6.setVisibility(View.VISIBLE);
            binding.et6.setHint("Enter the field");
            binding.genderRg.setVisibility(View.VISIBLE);

        } else if (additionType == 2) {

            binding.et1.setVisibility(View.VISIBLE);
            binding.et1.setHint("Enter the username");
            binding.et2.setVisibility(View.VISIBLE);
            binding.et2.setHint("Enter the password");
            binding.et3.setVisibility(View.VISIBLE);
            binding.et3.setHint("Enter the name");
            binding.et4.setVisibility(View.VISIBLE);
            binding.et4.setHint("Enter the university id");
            binding.et5.setVisibility(View.VISIBLE);
            binding.et5.setHint("Enter the birthdate");
            binding.genderRg.setVisibility(View.VISIBLE);

        } else if (additionType == 3) {

            binding.et1.setVisibility(View.VISIBLE);
            binding.et1.setHint("Enter the id of questions");
            binding.et2.setVisibility(View.VISIBLE);
            binding.et2.setHint("Enter the questions text");
            binding.et3.setVisibility(View.VISIBLE);
            binding.et3.setHint("Enter the Mark weight");
            binding.et4.setVisibility(View.VISIBLE);
            binding.et4.setHint("Enter the questions answer");
        } else if (additionType == 4) {

            binding.et1.setVisibility(View.VISIBLE);
            binding.et1.setHint("Enter the Exam name");
            binding.et2.setVisibility(View.VISIBLE);
            binding.et2.setHint("Enter the number of questions");
            binding.et3.setVisibility(View.VISIBLE);
            binding.et3.setHint("Enter the minimum pass average ");
            binding.et4.setVisibility(View.VISIBLE);
            binding.et4.setHint("Enter the total mark");
            binding.questionsTypeTv.setVisibility(View.VISIBLE);
            binding.yesNoType.setVisibility(View.VISIBLE);
            binding.multipleChoiceType.setVisibility(View.VISIBLE);
            binding.fillTheBlankType.setVisibility(View.VISIBLE);

        }

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if (additionType == 1) {
                    String username = binding.et1.getText().toString();
                    String password = binding.et2.getText().toString();
                    String name = binding.et3.getText().toString();
                    String birthdate = binding.et4.getText().toString();
                    int salary = Integer.parseInt(binding.et5.getText().toString());
                    String field = binding.et6.getText().toString();
                    String gender = "";
                    if (binding.genderRg.getCheckedRadioButtonId() == R.id.maleRb)
                        gender = "male";
                    else if (binding.genderRg.getCheckedRadioButtonId() == R.id.femaleRb)
                        gender = "female";

                    db.insertUser(new User(1, username, password, name, birthdate, gender, salary, field));
                    finish();
                } else if (additionType == 2) {
                    String username = binding.et1.getText().toString();
                    String password = binding.et2.getText().toString();
                    String name = binding.et3.getText().toString();
                    int uniId = Integer.parseInt(binding.et4.getText().toString());
                    String birthdate = binding.et5.getText().toString();
                    String gender = "";
                    if (binding.genderRg.getCheckedRadioButtonId() == R.id.maleRb)
                        gender = "male";
                    else if (binding.genderRg.getCheckedRadioButtonId() == R.id.femaleRb)
                        gender = "female";

                    db.insertUser(new User(uniId, 2, username, password, name, birthdate, gender));
                    finish();
                } else if (additionType == 3) {
                    int questionId = Integer.parseInt(binding.et1.getText().toString());
                    String questionText = binding.et2.getText().toString();
                    int marks = Integer.parseInt(binding.et3.getText().toString());
                    String answer = binding.et5.getText().toString();

                    db.insertQuestion(new Question(questionId, 1, questionText, marks, null, answer));
                    finish();

                } else if (additionType == 4) {

                    String examName = binding.et1.getText().toString();
                    int numberOfQuestions = Integer.parseInt(binding.et2.getText().toString());
                    int minPassAvg = Integer.parseInt(binding.et3.getText().toString());
                    int totalMark = Integer.parseInt(binding.et4.getText().toString());
                    int[] allowedQuestionsType = new int[3];
                    int[] questionsIndices = new int[numberOfQuestions];
                    int lastIndex = 0;
                    ArrayList<Question> questions = new ArrayList<>();
                    if (binding.yesNoType.isChecked()) {
                        allowedQuestionsType[lastIndex] = 1;
                        lastIndex++;
                    } else if (binding.multipleChoiceType.isChecked()) {
                        allowedQuestionsType[lastIndex] = 2;
                        lastIndex++;

                    } else if (binding.fillTheBlankType.isChecked()) {
                        allowedQuestionsType[lastIndex] = 3;
                        lastIndex++;
                    }

                    for (int i = 0; i < numberOfQuestions; i++) {
                        Random r = new Random();
                        int randomNumber = r.nextInt(db.getQuestionsCount()-1) + 1;
                        Log.d("ExamTesting", "onClick: "+randomNumber);
                        Question q = db.getQuestionById(randomNumber);
                        if (IntStream.of(questionsIndices).anyMatch(x -> x == randomNumber) || !IntStream.of(allowedQuestionsType).anyMatch(x -> x == q.getQuestionType())) {
                            Log.d("ExamTesting", "onClick: if1 : "+IntStream.of(questionsIndices).anyMatch(x -> x == randomNumber));
                            Log.d("ExamTesting", "onClick: if2: "+IntStream.of(allowedQuestionsType).anyMatch(x -> x == q.getQuestionType()));
                            i--;
                        } else {
                            Log.d("ExamTesting", "onClick: else1 : "+q);
                            questionsIndices[i] = randomNumber;
                            questions.add(q);
                        }
                    }
                    boolean result = db.insertExam(new Exam(examName, numberOfQuestions, minPassAvg, allowedQuestionsType, questionsIndices, totalMark, questions));
                    Log.d("TestingExam", "onClick: " + result);
                    finish();
                }

            }
        });


    }
}