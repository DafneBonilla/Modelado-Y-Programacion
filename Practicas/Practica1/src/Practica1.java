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
     * Generates a list of fighters
     * The order of the fighters in the list is random
     * 
     * @param version a random number between 0 and 2
     * @return a list of fighters
     */
    public static List<Fighter> createList(int version) {
        List<Fighter> list = new ArrayList<Fighter>();
        switch (version) {
            case 0:
                list.add(new Korby());
                list.add(new MeganMan());
                list.add(new Dittuu());
                return list;
            case 1:
                list.add(new Korby());
                list.add(new Dittuu());
                list.add(new MeganMan());
                return list;
            case 2:
                list.add(new MeganMan());
                list.add(new Korby());
                list.add(new Dittuu());
                return list;
            case 3:
                list.add(new MeganMan());
                list.add(new Dittuu());
                list.add(new Korby());
                return list;
            case 4:
                list.add(new Dittuu());
                list.add(new Korby());
                list.add(new MeganMan());
                return list;
            case 5:
                list.add(new Dittuu());
                list.add(new MeganMan());
                list.add(new Korby());
                return list;
            default:
                return null;
        }
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
        List<Fighter> fighters = createList(random(5));
        RiggedFight riggedFight = generateFight(random(2));
        Ring ring = new Ring(fighters, riggedFight);
        ring.registerObserver(new Viewer("ViewerBlackDragon", ring, support(random(2))));
        ring.registerObserver(new Viewer("ViewerDracarys", ring, support(random(2))));
        ring.registerObserver(new Viewer("ViewerJamesss", ring, support(random(2))));
        ring.registerObserver(new Viewer("ViewerCanek", ring, support(random(2))));
        ring.start();
    }
}
