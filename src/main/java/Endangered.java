package wildlifeTracker;
import org.sql2o.*;

import java.util.List;

public class Endangered extends Animals {
    private String health;
    private String age;

    public static final String HEALTHY = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";

    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";

    public Endangered(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        endangered = true;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }
}
