package com.hashem.android1_2023.Section101.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public static final String CONTACTS_TABLE = "contacts";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String EMAIL_COLUMN = "email";
    public static final String PHONE_COLUMN = "phone";
    public static final String YEAR_OF_BIRTH_COLUMN = "yearOfBirth";


    public MyDatabase(@Nullable Context context) {
        super(context, "Contacts_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + CONTACTS_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement , " + NAME_COLUMN + " text," +
                " " + EMAIL_COLUMN + " text, " + PHONE_COLUMN + " text, " + YEAR_OF_BIRTH_COLUMN + " integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists " + CONTACTS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long insertContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(NAME_COLUMN, contact.getName());
        cv.put(EMAIL_COLUMN, contact.getEmail());
        cv.put(PHONE_COLUMN, contact.getPhone());
        cv.put(YEAR_OF_BIRTH_COLUMN, contact.getYearOfBirth());

        long result = db.insert(CONTACTS_TABLE, null, cv);

        return result;
    }

    public int deleteContact(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {String.valueOf(id)};
        int result = db.delete(CONTACTS_TABLE, ID_COLUMN + " = ?", args);
        return result;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NAME_COLUMN, contact.getName());
        cv.put(EMAIL_COLUMN, contact.getEmail());
        cv.put(PHONE_COLUMN, contact.getPhone());
        cv.put(YEAR_OF_BIRTH_COLUMN, contact.getYearOfBirth());

        int result = db.update(CONTACTS_TABLE, cv, ID_COLUMN+" = ?", new String[]{String.valueOf(contact.getId())});

        return result;
    }

    public ArrayList<Contact> getAllContacts(){

        ArrayList<Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+CONTACTS_TABLE,null);

        int idIndex = cursor.getColumnIndexOrThrow(ID_COLUMN);
        int nameIndex = cursor.getColumnIndexOrThrow(NAME_COLUMN);
        int emailIndex = cursor.getColumnIndexOrThrow(EMAIL_COLUMN);
        int phoneIndex = cursor.getColumnIndexOrThrow(PHONE_COLUMN);
        int yearOfBirthIndex = cursor.getColumnIndexOrThrow(YEAR_OF_BIRTH_COLUMN);


        while (cursor.moveToNext()){
            int id = cursor.getInt(idIndex);
           String name = cursor.getString(nameIndex);
           String email = cursor.getString(emailIndex);
           String phone = cursor.getString(phoneIndex);
           int year = cursor.getInt(yearOfBirthIndex);

           Contact c = new Contact(name,email,phone,year);
           c.setId(id);
           contacts.add(c);
        }
        return contacts;
    }

}
