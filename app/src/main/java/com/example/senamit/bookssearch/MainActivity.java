package com.example.senamit.bookssearch;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.senamit.bookssearch.data.ExerciseDBHelper;
import com.example.senamit.bookssearch.data.ExerciseContract.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton floatingActionButton;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView text1 = findViewById(R.id.textView);




        floatingActionButton = findViewById(R.id.floatingActionButton1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExerciseList.class);
                startActivity(intent);
            }
        });

        cursor = getContentResolver().query(FitnessExcercise.CONTENT_URI,
                null,
                null,
                null,
                null);

        int count = cursor.getCount();
        int idIndex = cursor.getColumnIndex(FitnessExcercise._ID);
        int exerciseNameIndex = cursor.getColumnIndex(FitnessExcercise.COLUMN_EXERCISE_NAME);
//        int indexNumber = cursor.getColumnNames(idIndex);
        cursor.moveToFirst();

        String exerciseName = cursor.getString(exerciseNameIndex);
        Log.i(LOG_TAG,"the count of table is "+count);

        text1.setText(exerciseName);



    }
}
