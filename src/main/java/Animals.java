//package wildlifeTracker;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Animals {
    public int id;
    public String name;
    public boolean endangered;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getEndangered() {
        return endangered;
    }
}