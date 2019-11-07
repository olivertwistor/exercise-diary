package nu.olivertwistor.exercisediary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity presents a main menu screen with buttons which the user may
 * click on in order to go to other activities within this app.
 *
 * @author Johan Nilsson
 * @since  0.1.0
 */
public class MainMenuActivity extends AppCompatActivity
        implements View.OnClickListener
{
    /**
     * Logging tag string for this class.
     *
     * @since 0.1.0
     */
    private static final String logtag = "MainMenuActivity";

    /**
     * Button that leads to the Add exercise activity.
     *
     * @since 0.1.0
     */
    private Button addExerciseButton;

    /**
     * Button that leads to the Add exercise type activity.
     *
     * @since 0.1.0
     */
    private Button addExerciseTypeButton;

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

        this.addButtonListeners(this);
    }

    /**
     * Handles what happens when the user clicks on any of the buttons.
     *
     * @param view the button that's clicked
     *
     * @since 0.1.0
     */
    @Override
    public void onClick(View view)
    {
        final Button clickedButton = (Button) view;

        if (clickedButton == this.addExerciseButton)
        {
            Log.e(logtag, "Not yet implemented.");
        }
        else if (clickedButton == this.addExerciseTypeButton)
        {
            final Intent intent = new Intent(
                    this, AddExerciseTypeActivity.class);
            this.startActivity(intent);
        }
    }

    /**
     * Adds click listeners to all the buttons.
     *
     * @param listener the click listener to add to the buttons
     *
     * @since 0.1.0
     */
    private void addButtonListeners(View.OnClickListener listener)
    {
        this.addExerciseButton = this.findViewById(R.id.btn_add_exercise);
        this.addExerciseButton.setOnClickListener(listener);

        this.addExerciseTypeButton = this.findViewById(
                R.id.btn_add_exercise_type);
        this.addExerciseTypeButton.setOnClickListener(listener);
    }
}
