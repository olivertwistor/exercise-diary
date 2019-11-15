package nu.olivertwistor.exercisediary.controllers;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import nu.olivertwistor.exercisediary.BuildConfig;
import nu.olivertwistor.exercisediary.R;
import nu.olivertwistor.exercisediary.database.ExerciseType;
import nu.olivertwistor.exercisediary.viewmodels.ExerciseTypeViewModel;

public class AddExerciseTypeActivity extends AppCompatActivity
{
    static final String TAG = AddExerciseTypeActivity.class.getSimpleName();

    ExerciseTypeViewModel exerciseTypeViewModel;

    EditText nameEditText;
    EditText unitEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG)
        {
            Log.d(TAG, "Entering onCreate(Bundle)");
        }

        this.setContentView(R.layout.activity_add_exercise_type);

        this.exerciseTypeViewModel = new ExerciseTypeViewModel(
                this.getApplication());

        this.nameEditText = this.findViewById(
                R.id.input_add_exercise_type_name);
        this.unitEditText = this.findViewById(
                R.id.input_add_exercise_type_unit);
        Button saveButton = this.findViewById(
                R.id.button_add_exercise_type_save);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final ExerciseType exerciseType = new ExerciseType();
                exerciseType.setType(nameEditText.getText().toString());
                exerciseType.setUnit(unitEditText.getText().toString());

                exerciseTypeViewModel.insert(exerciseType);

                if (BuildConfig.DEBUG)
                {
                    Log.i(TAG, "Inserted " + exerciseType);
                }
            }
        });
    }
}
