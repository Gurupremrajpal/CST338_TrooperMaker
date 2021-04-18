import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AStarWar {
    /**
     *  DON'T Change this file!!
     *
     */
    public static void main(String[] args){
        StormTrooper tk421 = new StormTrooper("tk",421);
        StormTrooper jb007 = new StormTrooper("jb",007);
        RebelTrooper poe = new RebelTrooper("black",1, "Poe");
        RebelTrooper luke = new RebelTrooper("red",5, "Luke");

        System.out.println("Rebel troopers: " + RebelTrooper.getSoldierCount());
        System.out.println("Stormtroopers: " + StormTrooper.getSoldierCount());

        poe.setMarchSpeed(10.0);
        tk421.setMarchSpeed(12.0);

        HashMap<String, List<Trooper>> army = new HashMap<>();

        Trooper.addToUnit(army, poe);
        Trooper.addToUnit(army,tk421);
        Trooper.addToUnit(army,jb007);
        Trooper.addToUnit(army,luke);

        System.out.println(army);
        Random r = new Random();

        for (String unit : army.keySet()) {
            for(Trooper t : army.get(unit)){
                System.out.println(t);
                System.out.println(t + " Marched " + t.march(10) + " meters");
                for(String unit2 : army.keySet()){
                    for (Trooper u : army.get(unit2)) {
                        System.out.println(t.attack(u, r.nextInt(20) + 1) ? "Hit!" : "Miss!");
                    }
                }
            }
        }
    }
}
