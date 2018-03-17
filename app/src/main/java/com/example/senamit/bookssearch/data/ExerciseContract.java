package com.example.senamit.bookssearch.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by senamit on 13/3/18.
 */

public class ExerciseContract {

    public ExerciseContract() {
    }

    public static final String AUTHORITY = "com.example.senamit.bookssearch";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_EXERCISE_LIST = "ExerciseListTable";


    public static class FitnessExcercise implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_EXERCISE_LIST).build();


        public static final String TABLE_NAME = "ExerciseListTable";
        public static final String COLUMN_EXERCISE_NAME= "ExerciseName";

    }
}
