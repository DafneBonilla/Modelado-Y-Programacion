import java.util.ArrayList;
import java.util.List;

/**
 * Class to the make everything work
 */
public class Practica1 {

    /**
     * Generates a random number between 0 and max
     * 
     * @param max the maximum number that the random number can be
     * @return a random number between 0 and max
     */
    public static int random(int max) {
        int resultadorand = (int) Math.round(Math.random() * max + 0.5);
        return resultadorand;
    }

    /**
     * Generates the order that the fight will take
     * 
     * @param version a random number between 0 and 2
     * @return the order that the fight will take
     */
    public static RiggedFight generateFight(int version) {
        switch (version) {
            case 0:
                return new Case1();
            case 1:
                return new Case2();
            case 2:
                return new Case3();
            default:
                return null;
        }
    }

    /**
     * Returns the name of a random fighter
     * 
     * @param version a random number between 0 and 2
     * @return the name of a random fighter
     */
    public static String support(int version) {
        switch (version) {
            case 0:
                return "Korby";
            case 1:
                return "MeganMan";
            case 2:
                return "Dittuu";
            default:
                return null;
        }
    }

    /**
     * Main method
     * 
     * @param args the arguments of the main method
     */
    public static void main(String[] args) {
        List<Fighter> fighters = new ArrayList<Fighter>();
        fighters.add(new Korby());
        fighters.add(new MeganMan());
        fighters.add(new Dittuu());
        RiggedFight riggedFight = generateFight(random(2));
        Ring ring = new Ring(fighters, riggedFight);
        ring.registerObserver(new Viewer("ViewerBlackDragon", ring, support(random(2))));
        ring.registerObserver(new Viewer("ViewerDracarys", ring, support(random(2))));
        ring.registerObserver(new Viewer("ViewerJamesss", ring, support(random(2))));
        ring.registerObserver(new Viewer("ViewerCanek", ring, support(random(2))));
        ring.start();
    }
}
