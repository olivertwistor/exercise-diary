package nu.olivertwistor.exercisediary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddExerciseTypeActivity extends AppCompatActivity
{
    private static final String logtag = "AddExerciseTypeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_add_exercise_type);
    }
}
