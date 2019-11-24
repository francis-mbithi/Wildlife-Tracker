import org.sql2o.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

public class Sightings {
    private String location;
    private String rangerName;
    private Timestamp spotted;
    private int animalId;
    private int id;

    public Sightings(String location, String rangerName, int animalId) {
        this.location = location;
        this.rangerName = rangerName;
        this.animalId = animalId;
    }

    public String getLocation() {
        return location;
    }
    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getSpotted() {
        return spotted;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }
}