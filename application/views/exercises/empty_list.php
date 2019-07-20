<?php // View to show when there are no exercises in the database. ?>

<main>
    <h1>Past exercises</h1>
    <p>
        It doesn't seem to be any exercises in the database. Do you want to
        <?php echo anchor('exercises/add', 'add a new exercise?'); ?>
    </p>
</main>
