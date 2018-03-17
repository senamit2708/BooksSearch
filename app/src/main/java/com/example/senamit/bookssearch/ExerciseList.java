package com.example.senamit.bookssearch;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.senamit.bookssearch.data.ExerciseContract;

public class ExerciseList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private ExerciseListAdapter exerciseListAdapter;
    private RecyclerView mRecyclerExerciseList;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String LOG_TAG = ExerciseList.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        mRecyclerExerciseList = findViewById(R.id.recyclerExerciseList);
        mLayoutManager = new GridLayoutManager(this,1);
        mRecyclerExerciseList.setLayoutManager(mLayoutManager);



        getLoaderManager().initLoader(0, null, this);




    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new AsyncTaskLoader<Cursor>(this) {

            Cursor mExerciseCursor;

            @Override
            protected void onStartLoading() {
                if (mExerciseCursor!=null){
                    deliverResult(mExerciseCursor);
                }
                else {
                    forceLoad();
                }
            }

            @Override
            public Cursor loadInBackground() {

                try{


                return getContentResolver().query(ExerciseContract.FitnessExcercise.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);

            }catch (Exception e){
                    Log.e(LOG_TAG, "unable to return data from database, query code uncessfull");
                }
                return null;
            }

            @Override
            public void deliverResult(Cursor data) {
                mExerciseCursor = data;
                super.deliverResult(data);
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        exerciseListAdapter = new ExerciseListAdapter(this);
        exerciseListAdapter.swapCursor(data);
        mRecyclerExerciseList.setAdapter(exerciseListAdapter);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
