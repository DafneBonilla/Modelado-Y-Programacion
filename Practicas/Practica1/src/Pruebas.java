import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    public static void main(String[] args) {

        List<Fighter> fighters = new ArrayList<>();
        fighters.add(new Korby());
        fighters.add(new MeganMan());
        fighters.add(new Dittuu());
        
        RiggedFight order = new Case1();

        Ring show = new Ring(fighters, order);

        show.registerObserver(new Viewer("Black Dragon", show, "MeganMan"));
        show.registerObserver(new Viewer("Camilo el Poderoso", show, "Dittuu"));
        show.registerObserver(new Viewer("Dracarys", show, "Korby"));

        show.start();

    }
}
