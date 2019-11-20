package nu.olivertwistor.exercisediary.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Data Access Object for the entity Exercise Type.
 *
 * @since 0.1.0
 */
@Dao
public interface ExerciseTypeDao
{
    /**
     * Inserts new record(s) into the database representing the given exercise
     * type(s).
     *
     * @param exerciseType the object(s) to insert into the database
     *
     * @return Row ID(s) of the inserted record(s).
     *
     * @since 0.1.0
     */
    @Insert
    long[] insert(ExerciseType... exerciseType);

    /**
     * Gets all exercise types from the database.
     *
     * @return A list of exercise types, wrapped in a LiveData object.
     *
     * @since 0.1.0
     */
    @Query("SELECT * FROM exercise_types ORDER BY type")
    LiveData<List<ExerciseType>> getExerciseTypes();

    /**
     * Updates the record in the database corresponding to the given exercise
     * type.
     *
     * @param exerciseType the object to update in the database
     *
     * @return Number of records that were affected (should be 1 for success).
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
     * @return Number of records that were affected (should be 1 for success).
     *
     * @since 0.1.0
     */
    @Delete
    int delete(ExerciseType exerciseType);
}
