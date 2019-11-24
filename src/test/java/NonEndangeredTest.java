//package wildlifeTracker;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class NonEndangeredTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();

    @Test
    public void NonEndangered_instantiatesCorrectly_true() {
        NonEndangered testanimal = new NonEndangered("bees");
        assertEquals(testanimal instanceof NonEndangered, true);
    }

    @Test
    public void NonEndangered_instantiatesWithName_String() {
        NonEndangered testanimal = new NonEndangered("bees");
        assertEquals("bees", testanimal.getName());
    }

    @Test
    public void equals_returnsTrueIfAnimalNamesAreTrue_True() {
        NonEndangered firstAnimal = new NonEndangered("bees");
        NonEndangered secondAnimal = new NonEndangered("bees");
        assertTrue(firstAnimal.equals(secondAnimal));
    }
}