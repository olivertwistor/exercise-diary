package nu.olivertwistor.exercisediary.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Model class for Exercise type. Just a POJO.
 *
 * @author Johan Nilsson
 *
 * @since 0.1.0
 */
@Entity(tableName = "exercise_types", indices = {@Index(value = "type")})
public class ExerciseType
{
    /**
     * Row ID in the database.
     *
     * @since 0.1.0
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    /**
     * Name of this exercise type.
     *
     * @since 0.1.0
     */
    private String type;

    /**
     * The unit of this exercise type, for example "miles" or "reps".
     *
     * @since 0.1.0
     */
    private String unit;

    /**
     * Gets the row ID.
     *
     * @return The row ID.
     *
     * @since 0.1.0
     */
    int getId()
    {
        return this.id;
    }

    /**
     * Sets the row ID.
     *
     * @param id the row ID
     *
     * @since 0.1.0
     */
    void setId(int id)
    {
        this.id = id;
    }

    /**
     * Gets the name of this exercise type.
     *
     * @return The name of this exercise type.
     *
     * @since 0.1.0
     */
    String getType()
    {
        return this.type;
    }

    /**
     * Sets the name of this exercise type.
     *
     * @param type the name of this exercise type
     *
     * @since 0.1.0
     */
    public void setType(final String type)
    {
        this.type = type;
    }

    /**
     * Gets the unit of this exercise type, for example "miles" or "reps".
     *
     * @return The unit of this exercise type.
     *
     * @since 0.1.0
     */
    String getUnit()
    {
        return this.unit;
    }

    /**
     * Sets the unit of this exercise type, for example "miles" or "reps".
     *
     * @param unit the unit of this exercise type
     *
     * @since 0.1.0
     */
    public void setUnit(final String unit)
    {
        this.unit = unit;
    }

    @Override
    @NonNull
    public String toString()
    {
        return "ExerciseType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
