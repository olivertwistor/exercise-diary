package nu.olivertwistor.exercisediary.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import nu.olivertwistor.exercisediary.BuildConfig;

/**
 * This class manages a singleton instance of the RoomDatabase class particular
 * for this app. It also holds a reference to each of the Room DAO's for this
 * app.
 *
 * @author Johan Nilsson
 *
 * @since 0.1.0
 */
@Database(version = 1, entities = { ExerciseType.class })
public abstract class AppDatabase extends RoomDatabase
{
    private static final String TAG = AppDatabase.class.getSimpleName();

    /**
     * Filename of the SQLite database.
     *
     * @since 0.1.0
     */
    private static final String db_filename = "exercises.db";

    /**
     * Singleton instance of this class.
     *
     * @since 0.1.0
     */
    private static AppDatabase instance;

    /**
     * Gets a reference to the ExerciseType DAO.
     *
     * @return An instance of the ExerciseTypeDao class.
     *
     * @since 0.1.0
     */
    public abstract ExerciseTypeDao getExerciseTypeDao();

    /**
     * Returns the singleton instance of this class.
     *
     * If not previously instantiated, Room's databaseBuilder is used to build
     * the database.
     *
     * @param context the context in which the call to this method is made
     *
     * @return The singleton instance of this class.
     *
     * @since 0.1.0
     */
    public static AppDatabase getInstance(final Context context)
    {
        if (BuildConfig.DEBUG)
        {
            Log.d(TAG, "Entering getInstance(Context)");
        }

        if (instance == null)
        {
            synchronized (AppDatabase.class)
            {
                instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        db_filename).fallbackToDestructiveMigration().build();
            }
        }

        return instance;
    }

    /**
     * Destroys the instance of this class. Nothing happens if an instance
     * wasn't instantiated before calling this method.
     *
     * @since 0.1.0
     */
    public static void destroyInstance()
    {
        if (BuildConfig.DEBUG)
        {
            Log.d(TAG, "Entering destroyInstance()");
        }
        
        instance = null;
    }
}
