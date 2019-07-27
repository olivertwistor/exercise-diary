<?php // List of all exercises in the database. ?>

<?php
// Make sure that the exercises array is defined. If not, let's just use an
// empty array as fallback.
if (!isset($exercises))
{
    $exercises = [];
}
?>

<main>
    <h1>Past exercises</h1>
    <table>
        <thead>
            <tr>
                <th>Timestamp</th>
                <th>Type</th>
                <th>Repetitions</th>
            </tr>
        </thead>
        <tbody>
        <?php foreach ($exercises as $exercise) : ?>
            <tr>
                <td><?php echo $exercise->exercise_timestamp; ?></td>
                <td><?php echo $exercise->exercise_type; ?></td>
                <td><?php echo $exercise->repetitions; ?></td>
            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
    <p><?php echo anchor('exercises/add', 'Add a new exercise?'); ?></p>
</main>
