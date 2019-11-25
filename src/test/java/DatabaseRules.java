import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseRules extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "francis", "123");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalssQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalssQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }

    public static class EndangeredTest{
        @Rule
        public DatabaseRules database = new DatabaseRules();
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
        @Test
        public void endangered_instantiatesWIthAnimalHealth_String(){
            Endangered testAnimal = new Endangered("lion","okay", "young");
            assertEquals("okay", testAnimal.getHealth());
        }
        @Test
        public void endangered_instantiatesWithAgeOfAnimal_String(){
            Endangered testAnimal = new Endangered("lion","okay", "young");
            assertEquals("young", testAnimal.getAge());
        }
        @Test
        public void save_savesEndangeredAnimalObjectsIntoDB(){
            Endangered testAnimal = new Endangered("lion","okay", "young");
            testAnimal.save();
            assertTrue(Endangered.all().get(0).equals(testAnimal));
        }
        @Test
        public void all_returnsAllInstancesOfEndangeredAnimals_true(){
            Endangered firstAnimal = new Endangered("lion","okay", "young");
            firstAnimal.save();
            Endangered secondAnimal = new Endangered("snake","healthy", "adult");
            secondAnimal.save();
            assertEquals(true, Endangered.all().get(0).equals(firstAnimal));
            assertEquals(true, Endangered.all().get(1).equals(secondAnimal));
        }
        @Test
        public void find_returnsEndangeredAnimalWithSameId_secondAnimal(){
            Endangered firstAnimal = new Endangered("lion","okay", "young");
            firstAnimal.save();
            Endangered secondAnimal = new Endangered("snake","healthy", "adult");
            secondAnimal.save();
            assertEquals(Endangered.find(secondAnimal.getId()), secondAnimal);
        }
    //    @Test
    //    public void update_updatesAnimalNameAndHealth_true(){
    //        Endangered firstAnimal = new Endangered("lion","okay", "young");
    //        firstAnimal.save();
    //        firstAnimal.update("lioness", "healthy");
    //        assertEquals("lioness", Endangered.find(firstAnimal.getId().getName()));
    //    }
    }
}