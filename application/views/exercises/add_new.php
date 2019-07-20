<?php // Form that lets the user add a new exercise. ?>

<main>
    <h1>Add a new exercise</h1>
    <?php if (!empty($insert_status)) : ?>
    <p class="<?php echo $insert_status['css_class']; ?>">
        <?php echo $insert_status['text']; ?>
    </p>
    <?php endif; ?>
    <?php
    echo form_open('exercises/add');
        echo form_fieldset('Date and time for the exercise');
            echo form_label('Date', 'exercise-date', ['class' => 'required']);
            echo form_input([
                'type' => 'date',
                'name' => 'exercise-date',
                'value' => date('Y-m-d'),
                'required' => 'required'
            ]);
            echo form_label('Time', 'exercise-time', ['class' => 'required']);
            echo form_input([
                'type' => 'time',
                'name' => 'exercise-time',
                'value' => date('H:i:s'),
                'required' => 'required'
            ]);
        echo form_fieldset_close();
        echo form_fieldset('Information about the exercise itself');
            echo form_label('Exercise type', 'exercise-type');
            echo form_dropdown('exercise-type', $exercise_types);
            echo form_label(
                'Number of repetitions, minutes or whichever unit is ' .
                'appropiate for the exercise type',
                'repetitions',
                ['class' => 'required']
            );
            echo form_input([
                'type' => 'number',
                'name' => 'repetitions',
                'value' => 1,
                'min' => 0,
                'required' => 'required'
            ]);
        echo form_fieldset_close();
        echo form_fieldset('Actions');
            echo form_submit('save', 'Save');
            echo form_reset('clear', 'Clear all fields');
        echo form_fieldset_close();
    echo form_close();
    ?>
</main>
