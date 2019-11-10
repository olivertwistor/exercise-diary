package nu.olivertwistor.exercisediary.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {ExerciseType.class})
public abstract class Db extends RoomDatabase
{
    public abstract ExerciseTypeDao getExerciseTypeDao();
}
