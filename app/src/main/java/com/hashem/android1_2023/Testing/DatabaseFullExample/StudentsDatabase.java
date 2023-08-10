package com.hashem.android1_2023.Testing.DatabaseFullExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentsDatabase extends SQLiteOpenHelper {

    public static final String STUDENTS_TABLE = "students";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String GPA_COLUMN = "GPA";
    public static final String FIELD_COLUMN = "field";

    public StudentsDatabase(@Nullable Context context) {
        super(context, "students_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table " + STUDENTS_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement," +
                NAME_COLUMN + " text, " + GPA_COLUMN + " REAL, " + FIELD_COLUMN + " text  )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop TABLE IF EXISTS " + STUDENTS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long insertStudent(Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME_COLUMN, student.getName());
        cv.put(GPA_COLUMN, student.getGPA());
        cv.put(FIELD_COLUMN, student.getField());
        long result = db.insert(STUDENTS_TABLE, null, cv);

        return result;
    }

    public int updateStudent(Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME_COLUMN, student.getName());
        cv.put(GPA_COLUMN, student.getGPA());
        cv.put(FIELD_COLUMN, student.getField());
        int result = db.update(STUDENTS_TABLE, cv, ID_COLUMN + "= ? ", new String[]{String.valueOf(student.getId())});
        return result;
    }

    public int deleteStudent(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete(STUDENTS_TABLE, ID_COLUMN + "= ? ", new String[]{String.valueOf(id)});
        return result;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
       Cursor cursor = db.rawQuery("SELECT * FROM "+STUDENTS_TABLE, null);

       while (cursor.moveToNext()){
           int id = cursor.getInt(cursor.getColumnIndexOrThrow(ID_COLUMN));
           String name = cursor.getString(cursor.getColumnIndexOrThrow(NAME_COLUMN));
           double GPA = cursor.getDouble(cursor.getColumnIndexOrThrow(GPA_COLUMN));
           String field = cursor.getString(cursor.getColumnIndexOrThrow(FIELD_COLUMN));

           Student student = new Student(name,GPA,field);
           student.setId(id);
           students.add(student);
       }
        return students;
    }

}
