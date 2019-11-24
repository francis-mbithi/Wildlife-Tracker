package wildlifeTracker;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class EndangeredTest{
//    @Rule
////    public DatabaseRules database = new DatabaseRules();
    @Test
    public void endangered_instantiatesCorrectly_true(){
        Endangered testAnimal = new Endangered("lion","okay", "young");
        assertEquals(testAnimal instanceof Endangered, true);
    }
    @Test
    public void endangered_instantiatesWithAnimalName_String(){
        Endangered testAnimal = new Endangered("lion","okay", "young");
        assertEquals("lion", testAnimal.getName());
    }