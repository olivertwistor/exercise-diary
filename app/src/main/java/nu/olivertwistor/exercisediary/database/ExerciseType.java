package nu.olivertwistor.exercisediary.database;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercise_types", indices = {@Index(value = "type")})
public class ExerciseType
{
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String type;
    public String unit;
}
