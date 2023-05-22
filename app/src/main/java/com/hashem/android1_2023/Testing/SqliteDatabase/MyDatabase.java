package com.hashem.android1_2023.Testing.SqliteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String NAME_COLUMN = "name";
    public static final String ID_COLUMN = "id";
    public static final String PHONE_COLUMN = "phone";
    public static final String EMAIL_COLUMN = "email";
    public static final String YEAR_OF_BIRTH_COLUMN = "yearOfBirth";
    public static final String CONTACTS_TABLE = "contacts";
    public static final String IMAGE_TABLE = "image";


    public MyDatabase(@Nullable Context context) {
        super(context, "my_contacts_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + CONTACTS_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement, " + NAME_COLUMN + " text, "
                + PHONE_COLUMN + " text," + EMAIL_COLUMN + " text, " + YEAR_OF_BIRTH_COLUMN + " integer ,  "+IMAGE_TABLE+" blob )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists contacts");
        onCreate(sqLiteDatabase);
    }

    public long insertContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME_COLUMN, contact.getName());
        cv.put(PHONE_COLUMN, contact.getPhone());
        cv.put(EMAIL_COLUMN, contact.getEmail());
        cv.put(YEAR_OF_BIRTH_COLUMN, contact.getYearOfBirth());
        cv.put(IMAGE_TABLE, Utils.getBytes(contact.getImage()));
        long insertedId = db.insert(CONTACTS_TABLE, null, cv);
        return insertedId;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME_COLUMN, contact.getName());
        cv.put(PHONE_COLUMN, contact.getPhone());
        cv.put(EMAIL_COLUMN, contact.getEmail());
        cv.put(YEAR_OF_BIRTH_COLUMN, contact.getYearOfBirth());
        int updatedId = db.update(CONTACTS_TABLE, cv, "id = ?", new String[]{String.valueOf(contact.getId())});
        return updatedId;
    }

    public int deleteContact(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int updatedId = db.delete(CONTACTS_TABLE, "id = ?", new String[]{String.valueOf(id)});
        return updatedId;
    }

    public int numberOfRows() {
        SQLiteDatabase db = getWritableDatabase();
        int rowsCount = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE);
        return rowsCount;
    }

    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + CONTACTS_TABLE, null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndexOrThrow(ID_COLUMN));
            String name = c.getString(c.getColumnIndexOrThrow(NAME_COLUMN));
            String email = c.getString(c.getColumnIndexOrThrow(EMAIL_COLUMN));
            String phone = c.getString(c.getColumnIndexOrThrow(PHONE_COLUMN));
            int yearOfBirth = c.getInt(c.getColumnIndexOrThrow(YEAR_OF_BIRTH_COLUMN));
            byte[] image = c.getBlob(c.getColumnIndexOrThrow(IMAGE_TABLE));
            Contact contact = new Contact(name, email, phone, yearOfBirth, Utils.getImage(image));
            contact.setId(id);
            contacts.add(contact);
        }
        c.close();
        return contacts;

    }


}
