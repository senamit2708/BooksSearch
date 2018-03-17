package com.example.senamit.bookssearch;

/**
 * Created by senamit on 13/3/18.
 */

public class ExerciseName {

    private String fitnessExerciseName;
    private String fitnessExerciseImage;
    private String fitnessExerciseType;

    public ExerciseName(String fitnessExerciseName, String fitnessExerciseImage, String fitnessExerciseType) {
        this.fitnessExerciseName = fitnessExerciseName;
        this.fitnessExerciseImage = fitnessExerciseImage;
        this.fitnessExerciseType = fitnessExerciseType;
    }

    public ExerciseName(String fitnessExerciseName) {
        this.fitnessExerciseName = fitnessExerciseName;
    }

    public ExerciseName(){};

    public String getFitnessExerciseName() {
        return fitnessExerciseName;
    }

    public String getFitnessExerciseImage() {
        return fitnessExerciseImage;
    }

    public String getFitnessExerciseType() {
        return fitnessExerciseType;
    }
}
