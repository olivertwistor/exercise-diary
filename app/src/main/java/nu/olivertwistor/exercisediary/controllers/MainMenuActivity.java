package nu.olivertwistor.exercisediary.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nu.olivertwistor.exercisediary.R;

/**
 * This activity presents a main menu screen with buttons which the user may
 * click on in order to go to other activities within this app.
 *
 * @author Johan Nilsson
 * @since  0.1.0
 */
public class MainMenuActivity extends AppCompatActivity
{
    /**
     * Logging tag string for this class.
     *
     * @since 0.1.0
     */
    private static final String TAG = MainMenuActivity.class.getSimpleName();

    /**
     * Sets content view and adds click listeners to all the buttons.
     *
     * @param savedInstanceState previously saved activity state
     *
     * @since 0.1.0
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main_menu);

        Button addExerciseButton = this.findViewById(
                R.id.button_main_menu_add_exercise);
        addExerciseButton.setOnClickListener(
                new AddExerciseClickListener(this));

        Button addExerciseTypeButton = this.findViewById(
                R.id.button_main_menu_add_exercise_type);
        addExerciseTypeButton.setOnClickListener(
                new AddExerciseTypeClickListener(this));
    }

    private class AddExerciseClickListener implements View.OnClickListener
    {
        private MainMenuActivity mainMenuActivity;

        AddExerciseClickListener(final MainMenuActivity mainMenuActivity)
        {
            this.mainMenuActivity = mainMenuActivity;
        }

        @Override
        public void onClick(final View view)
        {
            // TODO: Implement this.
        }
    }

    private class AddExerciseTypeClickListener implements View.OnClickListener
    {
        private MainMenuActivity mainMenuActivity;

        AddExerciseTypeClickListener(final MainMenuActivity mainMenuActivity)
        {
            this.mainMenuActivity = mainMenuActivity;
        }

        @Override
        public void onClick(final View view)
        {
            final Intent intent = new Intent(
                    this.mainMenuActivity, AddExerciseTypeActivity.class);
            this.mainMenuActivity.startActivity(intent);
        }
    }
}
