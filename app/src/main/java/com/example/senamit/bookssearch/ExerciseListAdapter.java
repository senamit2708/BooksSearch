package com.example.senamit.bookssearch;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.senamit.bookssearch.data.ExerciseContract;

/**
 * Created by senamit on 16/3/18.
 */

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ViewHolder> {

    private Context context;
    private Cursor mCursor;
    private static final String LOG_TAG = ExerciseListAdapter.class.getSimpleName();

    public ExerciseListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_exercise_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      int  exerciseNameId = mCursor.getColumnIndex(ExerciseContract.FitnessExcercise.COLUMN_EXERCISE_NAME);
      mCursor.moveToNext();
      String exerciseName = mCursor.getString(exerciseNameId);
        Log.i(LOG_TAG, "the name of exercise is "+exerciseName);
      holder.txtExerciseName.setText(exerciseName);


    }

    @Override
    public int getItemCount() {
       if (mCursor==null){
           return 0;
       }
       return mCursor.getCount();
    }

    public Cursor swapCursor(Cursor cursor){

        if (mCursor==cursor){
            return null;
        }
        Cursor tempCursor= mCursor;
        this.mCursor = cursor;
        if (cursor==null){
            this.notifyDataSetChanged();
        }
        return tempCursor;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtExerciseName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtExerciseName = itemView.findViewById(R.id.txtExerciseName);
        }
    }
}
