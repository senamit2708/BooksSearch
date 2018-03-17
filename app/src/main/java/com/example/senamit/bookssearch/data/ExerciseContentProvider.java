package com.example.senamit.bookssearch.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.senamit.bookssearch.data.ExerciseContract.*;
import com.example.senamit.bookssearch.data.ExerciseDBHelper.*;

/**
 * Created by senamit on 13/3/18.
 */

public class ExerciseContentProvider extends ContentProvider {

    ExerciseDBHelper dbHelper;
    SQLiteDatabase db;

    private static final String LOG_TAG = ExerciseContentProvider.class.getSimpleName();


    public static final int EXERCISE_LIST = 100;
    public static final int EXERCISE_LIST_ITEM = 101;

    private static final UriMatcher sUriMatcher = buildUriMatcher();


    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ExerciseContract.AUTHORITY, ExerciseContract.PATH_EXERCISE_LIST, EXERCISE_LIST);
        uriMatcher.addURI(ExerciseContract.AUTHORITY, ExerciseContract.PATH_EXERCISE_LIST + "/#", EXERCISE_LIST_ITEM);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        dbHelper = new ExerciseDBHelper(getContext());

        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        db = dbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Cursor retCursor;
        switch (match) {
            case EXERCISE_LIST:
                retCursor = db.query(FitnessExcercise.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                Log.i(LOG_TAG, "inside the table query ");
                break;
            case EXERCISE_LIST_ITEM:
                String id = uri.getPathSegments().get(1);
                String mSelection = "_id=?";
                String[] mSelectionArgs = new String[]{id};
                retCursor = db.query(FitnessExcercise.TABLE_NAME,
                        projection,
                        mSelection,
                        mSelectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new android.database.SQLException("uri is bad" + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
