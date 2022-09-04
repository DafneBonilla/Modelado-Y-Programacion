import java.util.ArrayList;
import java.util.List;

public class Practica1 {

    /* Metodo que genera numeros aleatorios entre 0 y max. */
    public static int random(int max) {
        int resultadorand = (int) Math.round(Math.random() * max + 0.5);
        return resultadorand;
    }

    public static List<Fighter> createList (int version) {
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
