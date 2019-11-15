package nu.olivertwistor.exercisediary.viewmodels;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import nu.olivertwistor.exercisediary.BuildConfig;
import nu.olivertwistor.exercisediary.database.AppDatabase;
import nu.olivertwistor.exercisediary.database.ExerciseType;
import nu.olivertwistor.exercisediary.database.ExerciseTypeDao;

/**
 * This class exposes the Exercise type DAO to the view layer. It also contains
 * cached LiveData of various search queries.
 *
 * @author Johan Nilsson
 *
 * @since 0.1.0
 */
public class ExerciseTypeViewModel extends AndroidViewModel
{
    private static final String TAG =
            ExerciseTypeViewModel.class.getSimpleName();

    /**
     * A reference to the Exercise type DAO.
     *
     * @since 0.1.0
     */
    private ExerciseTypeDao exerciseTypeDao;

    /**
     * A reference to the list of exercise types, wrapped in a LiveData object.
     *
     * @since 0.1.0
     */
    private LiveData<List<ExerciseType>> exerciseTypes;

    /**
     * Creates an instance of this class. Gets references to the Exercise type
     * DAO and the list of exercise types.
     *
     * @param application the context for the AppDatabase singleton
     *
     * @since 0.1.0
     */
    public ExerciseTypeViewModel(final Application application)
    {
        super(application);

        if (BuildConfig.DEBUG)
        {
            Log.d(TAG, "Entering constructor.");
        }

        final AppDatabase appDatabase = AppDatabase.getInstance(application);
        this.exerciseTypeDao = appDatabase.getExerciseTypeDao();
        this.exerciseTypes = this.exerciseTypeDao.getExerciseTypes();
    }

    /**
     * Gets a list of exercise types, wrapped in a LiveData object.
     *
     * @return A list of exercise types, wrapped in a LiveData object.
     *
     * @since 0.1.0
     */
    LiveData<List<ExerciseType>> getExerciseTypes()
    {
        return this.exerciseTypes;
    }

    /**
     * Inserts the supplied exercise type into the database.
     *
     * The database operation is made on a background worker thread.
     *
     * @param exerciseType the object to insert
     *
     * @since 0.1.0
     */
    public void insert(final ExerciseType exerciseType)
    {
        if (BuildConfig.DEBUG)
        {
            Log.d(TAG, "Entering insert(ExerciseType)");
        }

        new InsertExerciseTypeTask(this.exerciseTypeDao).execute(exerciseType);
    }

    /**
     * The AsyncTask that does the actual work in inserting an exercise type
     * into the database.
     *
     * @author Johan Nilsson
     *
     * @since 0.1.0
     */
    private static class InsertExerciseTypeTask
            extends AsyncTask<ExerciseType, Void, Void>
    {
        private static final String TAG =
                InsertExerciseTypeTask.class.getSimpleName();

        /**
         * Reference to the Exercise type DAO.
         *
         * @since 0.1.0
         */
        private ExerciseTypeDao dao;

        /**
         * Creating an instance of this class. All it does is storing a
         * reference to the Exercise type DAO.
         *
         * @param exerciseTypeDao a reference to the Exercise type DAO
         *
         * @since 0.1.0
         */
        InsertExerciseTypeTask(final ExerciseTypeDao exerciseTypeDao)
        {
            if (BuildConfig.DEBUG)
            {
                Log.d(TAG, "Entering constructor.");
            }

            this.dao = exerciseTypeDao;
        }

        /**
         * Inserts the list of exercise types in the argument list into the
         * database, using the Exercise type DAO.
         *
         * @param exerciseTypes a list of exercise types to insert into the
         *                      database
         *
         * @return null
         */
        @Override
        protected Void doInBackground(final ExerciseType... exerciseTypes)
        {
            if (BuildConfig.DEBUG)
            {
                Log.d(TAG, "Entering doInBackground(ExerciseType...)");
            }

            if (exerciseTypes.length > 0)
            {
                this.dao.insert(exerciseTypes);
            }

            return null;
        }
    }
}
