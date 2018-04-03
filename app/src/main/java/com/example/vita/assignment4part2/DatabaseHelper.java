package com.example.vita.assignment4part2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "words.db";
    private static final String TABLE_NAME = "words";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYNONYM = "synonym";

    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_WORD + " TEXT NOT NULL, " + COLUMN_SYNONYM + " TEXT NOT NULL);";

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertWord(Word w) {
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, w.getWord());
        values.put(COLUMN_SYNONYM, w.getSynonym());

        db.insert(TABLE_NAME, null, values);
    }

    public  Word getWord( String w ) {
        db = this.getReadableDatabase();

        String[] columns = {COLUMN_ID, COLUMN_WORD, COLUMN_SYNONYM};
        String[] filter = {w};
        Cursor cursor = db.query(TABLE_NAME, columns, COLUMN_WORD + "=?", filter, null, null, null, null);
        Word word = new Word();

        if (cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            word.setId(cursor.getInt(0));
            word.setWord(cursor.getString(1));
            word.setSynonym(cursor.getString(2));
        }

        if (word.getWord().equals("")) {
            word.setWord("Word not entered into database.");
        }

        cursor.close();
        return word;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
