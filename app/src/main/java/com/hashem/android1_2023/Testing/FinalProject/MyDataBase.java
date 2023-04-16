package com.hashem.android1_2023.Testing.FinalProject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "university_db";
    public static final String USERS_TABLE = "users";
    public static final String QUESTIONS_TABLE = "questions";
    public static final String EXAM_TABLE = "exam";
    public static final String USERNAME_COLUMN = "username";
    public static final String PASSWORD_COLUMN = "password";
    public static final String UNIVERSITY_ID_COLUMN = "id";
    public static final String USER_TYPE_COLUMN = "userType";
    public static final String NAME_COLUMN = "name";
    public static final String BIRTHDAY_COLUMN = "birthday";
    public static final String GENDER_COLUMN = "gender";
    public static final String SALARY_COLUMN = "salary";
    public static final String FIELD_COLUMN = "field";
    public static final String QUESTION_ID_COLUMN = "id";
    public static final String QUESTION_TYPE_COLUMN = "questionType";
    public static final String QUESTION_TEXT_COLUMN = "questionText";
    public static final String MARKS_COLUMN = "marks";
    public static final String ANSWER_COLUMN = "answer";
    public static final String CHOICES_COLUMN = "choices";
    public static final String STEPS_COLUMN = "steps";
    public static final String ORDERS_COLUMN = "orders";
    public static final String EXAM_ID_COLUMN = "id";
    public static final String EXAM_NAME_COLUMN = "examName";
    public static final String EXAM_NUMBER_OF_QUESTIONS_COLUMN = "numberOfQuestions";
    public static final String EXAM_MIN_PASS_AVG_COLUMN = "minPassAvg";
    public static final String EXAM_ALLOWED_QUESTIONS_TYPE_COLUMN = "allowedQuestionsType";
    public static final String EXAM_TOTAL_MARK_COLUMN = "totalMark";
    public static final String EXAM_QUESTIONS_COLUMN = "questions";


    public MyDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + USERS_TABLE + " ( " + UNIVERSITY_ID_COLUMN + " INTEGER , " + USER_TYPE_COLUMN + " integer , "
                + USERNAME_COLUMN + " text primary key, " + PASSWORD_COLUMN + " text , " + NAME_COLUMN + " text , "
                + BIRTHDAY_COLUMN + " text, " + GENDER_COLUMN + " text, " + SALARY_COLUMN + " integer, " + FIELD_COLUMN + " text )";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL("create table " + QUESTIONS_TABLE + " (" + QUESTION_ID_COLUMN + " Integer primary key," +
                QUESTION_TYPE_COLUMN + " Integer, " + QUESTION_TEXT_COLUMN + " text, " + MARKS_COLUMN + " integer," +
                " " + ANSWER_COLUMN + " text, " + CHOICES_COLUMN + " text, " + STEPS_COLUMN + " text, " + ORDERS_COLUMN + " text)");
        sqLiteDatabase.execSQL("create table " + EXAM_TABLE + " (" + EXAM_ID_COLUMN + " integer primary key autoincrement ," + EXAM_NAME_COLUMN + " text ," +
                EXAM_NUMBER_OF_QUESTIONS_COLUMN + " integer , " + EXAM_MIN_PASS_AVG_COLUMN + " integer " +
                " , " + EXAM_ALLOWED_QUESTIONS_TYPE_COLUMN + " text ," + EXAM_TOTAL_MARK_COLUMN + " integer, " + EXAM_QUESTIONS_COLUMN + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertUser(User user) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        long result = 0;

        if (user.getUserType() == 2) {
            ContentValues cv = new ContentValues();
            cv.put(UNIVERSITY_ID_COLUMN, user.getId());
            cv.put(USER_TYPE_COLUMN, user.getUserType());
            cv.put(USERNAME_COLUMN, user.getUsername());
            cv.put(PASSWORD_COLUMN, user.getPassword());
            cv.put(NAME_COLUMN, user.getName());
            cv.put(BIRTHDAY_COLUMN, user.getBirthday());
            cv.put(GENDER_COLUMN, user.getGender());
            result = sqLiteDatabase.insert(USERS_TABLE, null, cv);
        } else if (user.getUserType() == 1) {
            ContentValues cv = new ContentValues();
            cv.put(USER_TYPE_COLUMN, user.getUserType());
            cv.put(USERNAME_COLUMN, user.getUsername());
            cv.put(PASSWORD_COLUMN, user.getPassword());
            cv.put(NAME_COLUMN, user.getName());
            cv.put(BIRTHDAY_COLUMN, user.getBirthday());
            cv.put(GENDER_COLUMN, user.getGender());
            cv.put(SALARY_COLUMN, user.getSalary());
            cv.put(FIELD_COLUMN, user.getField());
            result = sqLiteDatabase.insert(USERS_TABLE, null, cv);
        }
        return result != -1;
    }

    public boolean insertQuestion(Question question) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        long result = 0;

        if (question.getQuestionType() == 1) {

            ContentValues cv = new ContentValues();
            cv.put(QUESTION_ID_COLUMN, question.getId());
            cv.put(QUESTION_TYPE_COLUMN, question.getQuestionType());
            cv.put(QUESTION_TEXT_COLUMN, question.getQuestionText());
            cv.put(MARKS_COLUMN, question.getMarks());
            cv.put(ANSWER_COLUMN, question.getAnswer());
            result = sqLiteDatabase.insert(QUESTIONS_TABLE, null, cv);

        } else if (question.getQuestionType() == 2) {

            String choices = Utils.convertArrayToString(question.getChoices());
            ContentValues cv = new ContentValues();
            cv.put(QUESTION_ID_COLUMN, question.getId());
            cv.put(QUESTION_TYPE_COLUMN, question.getQuestionType());
            cv.put(QUESTION_TEXT_COLUMN, question.getQuestionText());
            cv.put(MARKS_COLUMN, question.getMarks());
            cv.put(ANSWER_COLUMN, question.getAnswer());
            cv.put(CHOICES_COLUMN, choices);
            result = sqLiteDatabase.insert(QUESTIONS_TABLE, null, cv);

        } else if (question.getQuestionType() == 3) {

            // TODO: 15/04/2023 there is bug here
//            String steps = Utils.convertArrayToString(question.getSteps());
//            String orders = Utils.convertArrayToString(question.getOrders());
            ContentValues cv = new ContentValues();
            cv.put(QUESTION_ID_COLUMN, question.getId());
            cv.put(QUESTION_TYPE_COLUMN, question.getQuestionType());
            cv.put(QUESTION_TEXT_COLUMN, question.getQuestionText());
            cv.put(MARKS_COLUMN, question.getMarks());
//            cv.put(STEPS_COLUMN, steps);
//            cv.put(ORDERS_COLUMN, orders);
            result = sqLiteDatabase.insert(QUESTIONS_TABLE, null, cv);
        }
        return result != -1;
    }

    public int getQuestionsCount() {
        SQLiteDatabase db = getWritableDatabase();
        long num = DatabaseUtils.queryNumEntries(db, QUESTIONS_TABLE);
        return (int) num;
    }

    public Question getQuestionById(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + QUESTIONS_TABLE + " where " + QUESTION_ID_COLUMN + " = ?", new String[]{"" + id});
        if (c.getCount() > 0) {
            c.moveToFirst();
            int questionId = c.getInt(c.getColumnIndexOrThrow(QUESTION_ID_COLUMN));
            int questionType = c.getInt(c.getColumnIndexOrThrow(QUESTION_TYPE_COLUMN));
            String questionText = c.getString(c.getColumnIndexOrThrow(QUESTION_TEXT_COLUMN));
            int marks = c.getInt(c.getColumnIndexOrThrow(MARKS_COLUMN));
            String answer = c.getString(c.getColumnIndexOrThrow(ANSWER_COLUMN));
            return new Question(questionId, questionType, questionText, marks, null, answer);
        } else {
            return null;
        }
    }

    public boolean insertExam(Exam exam) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EXAM_NAME_COLUMN, exam.getExamName());
        cv.put(EXAM_NUMBER_OF_QUESTIONS_COLUMN, exam.getNumberOfQuestions());
        cv.put(EXAM_MIN_PASS_AVG_COLUMN, exam.getMinPassAvg());
        cv.put(EXAM_ALLOWED_QUESTIONS_TYPE_COLUMN, Utils.convertArrayToString(Utils.intToStringArray( exam.getAllowedQuestionsType())));
        cv.put(EXAM_TOTAL_MARK_COLUMN, exam.getTotalMark());
        cv.put(EXAM_QUESTIONS_COLUMN, Utils.convertArrayToString(Utils.intToStringArray(exam.getQuestionsIndices())));

        long result = db.insert(EXAM_TABLE, null, cv);
        return result != -1;

    }

    public ArrayList<User> getAllStudents() {
        ArrayList<User> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from " + USERS_TABLE + " where " + USER_TYPE_COLUMN + " = ? ", new String[]{"2"});
        while (c.moveToNext()) {
            String username = c.getString(c.getColumnIndexOrThrow(USERNAME_COLUMN));
            String password = c.getString(c.getColumnIndexOrThrow(PASSWORD_COLUMN));
            int universityId = c.getInt(c.getColumnIndexOrThrow(UNIVERSITY_ID_COLUMN));
            String name = c.getString(c.getColumnIndexOrThrow(NAME_COLUMN));
            String birthday = c.getString(c.getColumnIndexOrThrow(BIRTHDAY_COLUMN));
            String gender = c.getString(c.getColumnIndexOrThrow(GENDER_COLUMN));

            students.add(new User(universityId, 2, username, password, name, birthday, gender));
        }
        return students;
    }

    public ArrayList<User> getAllTeachers() {
        ArrayList<User> teachers = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from " + USERS_TABLE + " where " + USER_TYPE_COLUMN + " = ? ", new String[]{"1"});
        while (c.moveToNext()) {
            String username = c.getString(c.getColumnIndexOrThrow(USERNAME_COLUMN));
            String password = c.getString(c.getColumnIndexOrThrow(PASSWORD_COLUMN));
            String name = c.getString(c.getColumnIndexOrThrow(NAME_COLUMN));
            String birthday = c.getString(c.getColumnIndexOrThrow(BIRTHDAY_COLUMN));
            String gender = c.getString(c.getColumnIndexOrThrow(GENDER_COLUMN));
            int salary = c.getInt(c.getColumnIndexOrThrow(SALARY_COLUMN));
            String field = c.getString(c.getColumnIndexOrThrow(FIELD_COLUMN));

            teachers.add(new User(2, username, password, name, birthday, gender, salary, field));
        }
        return teachers;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from " + QUESTIONS_TABLE, null);
        while (c.moveToNext()) {
            int questionId = c.getInt(c.getColumnIndexOrThrow(QUESTION_ID_COLUMN));
            int questionType = c.getInt(c.getColumnIndexOrThrow(QUESTION_TYPE_COLUMN));
            String questionText = c.getString(c.getColumnIndexOrThrow(QUESTION_TEXT_COLUMN));
            int marks = c.getInt(c.getColumnIndexOrThrow(MARKS_COLUMN));
            String answer = c.getString(c.getColumnIndexOrThrow(ANSWER_COLUMN));
            questions.add(new Question(questionId, questionType, questionText, marks, null, answer));
        }
        return questions;
    }

    public ArrayList<Exam> getAllExams() {
        ArrayList<Exam> exams = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from " + EXAM_TABLE, null);
        while (c.moveToNext()) {
            int examId = c.getInt(c.getColumnIndexOrThrow(EXAM_ID_COLUMN));
            String examName = c.getString(c.getColumnIndexOrThrow(EXAM_NAME_COLUMN));
            int numberOfQuestions = c.getInt(c.getColumnIndexOrThrow(EXAM_NUMBER_OF_QUESTIONS_COLUMN));
            int minPassAvg = c.getInt(c.getColumnIndexOrThrow(EXAM_MIN_PASS_AVG_COLUMN));
            String allowedQuestionsTypeAsString = c.getString(c.getColumnIndexOrThrow(EXAM_ALLOWED_QUESTIONS_TYPE_COLUMN));
            int[] allowedQuestionsType = Utils.stringToIntegerArray(Utils.convertStringToArray(allowedQuestionsTypeAsString));
            int totalMark = c.getInt(c.getColumnIndexOrThrow(EXAM_TOTAL_MARK_COLUMN));
            // TODO: 15/04/2023 Add the question to the return data
            Exam e = new Exam(examName, numberOfQuestions, minPassAvg, allowedQuestionsType, null, totalMark,null);
            e.setExamId(examId);
            exams.add(e);
        }
        return exams;
    }


//    public ArrayList<User> getAllUsers() {
//        ArrayList<User> teachers = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c = db.rawQuery("Select * from "+USERS_TABLE,null);
//        while (c.moveToNext()) {
//            String username = c.getString(c.getColumnIndexOrThrow(USERNAME_COLUMN));
//            String password = c.getString(c.getColumnIndexOrThrow(PASSWORD_COLUMN));
//            String name = c.getString(c.getColumnIndexOrThrow(NAME_COLUMN));
//            String birthday = c.getString(c.getColumnIndexOrThrow(BIRTHDAY_COLUMN));
//            String gender = c.getString(c.getColumnIndexOrThrow(GENDER_COLUMN));
//            int salary = c.getInt(c.getColumnIndexOrThrow(SALARY_COLUMN));
//            String field = c.getString(c.getColumnIndexOrThrow(FIELD_COLUMN));
//
//            teachers.add(new User(2,username,password,name,birthday,gender,salary,field));
//        }
//        return teachers;
//    }


}
