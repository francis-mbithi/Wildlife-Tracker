import org.junit.*;
import static org.junit.Assert.*;

import java.sql.Timestamp;

public class SightingsTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();

    @Test
    public void Sightings_instantiatesCorrectly_true() {
        Sightings testSighting = new Sightings("area 1", "Vick", 1);
        assertEquals(testSighting instanceof Sightings, true);
    }

    @Test
    public void getLocation_instantiatesWithLocation_String() {
        Sightings testSighting = new Sightings("area 1", "Vick", 1);
        assertEquals("area 1", testSighting.getLocation());
    }
}