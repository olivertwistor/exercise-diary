package nu.olivertwistor.exercisediary.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface ExerciseTypeDao
{
    /**
     * Inserts a new record into the database representing the given exercise
     * type.
     *
     * @param exerciseType the object to insert into the database
     *
     * @return The row ID of the newly created database record.
     *
     * @since 0.1.0
     */
    @Insert
    long insert(ExerciseType exerciseType);

    /**
     * Updates the record in the database corresponding to the given exercise
     * type.
     *
     * @param exerciseType the object to update in the database
     *
     * @return The number of records that were affected; should be 1 for
     *         success or 0 for failure.
     *
     * @since 0.1.0
     */
    @Update
    int update(ExerciseType exerciseType);

    /**
     * Deletes the record in the database corresponding to the given exercise
     * type.
     *
     * @param exerciseType the object to delete from the database
     *
     * @return The number of records that were affected; should be 1 for
     *         success or 0 for failure.
     */
    @Delete
    int delete(ExerciseType exerciseType);
}
