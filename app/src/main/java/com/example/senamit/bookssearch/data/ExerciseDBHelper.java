package com.example.senamit.bookssearch.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.senamit.bookssearch.ExerciseList;
import com.example.senamit.bookssearch.ExerciseName;
import com.example.senamit.bookssearch.data.ExerciseContract.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 13/3/18.
 */

public class ExerciseDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = ExerciseDBHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "ExerciseTracker";
    public static final int DATABASE_VERSION = 7;

    public ExerciseDBHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION );
    }

    List<ExerciseName> listExercise = new ArrayList<>();
       // listExercise.add(new ExerciseName("amit"));


    private static final String SQL_CREATE_EXERCISE_ENTRY = "CREATE TABLE " + FitnessExcercise.TABLE_NAME +
            "(" + FitnessExcercise._ID + " INTEGER PRIMARY KEY, " +
            FitnessExcercise.COLUMN_EXERCISE_NAME + " TEXT NOT NULL UNIQUE )";

    String SQL_DATA_ENTRY1 = "INSERT INTO "+ FitnessExcercise.TABLE_NAME +"(" +FitnessExcercise.COLUMN_EXERCISE_NAME+") VALUES ('BODY BUILDING'),('head1'),('head2');";

//    String SQL_DATA_ENTRY2 = "INSERT INTO "+ FitnessExcercise.TABLE_NAME +"(" +FitnessExcercise.COLUMN_EXERCISE_NAME+") VALUES ('LEG BUILDING');";


    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FitnessExcercise.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_EXERCISE_ENTRY);
        db.execSQL(SQL_DATA_ENTRY1);
//        db.execSQL(SQL_DATA_ENTRY2);

        Log.i(LOG_TAG, "inside on creaate method of database");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
        Log.i(LOG_TAG, "inside on upgrade method of database");
        onCreate(db);

    }
}
