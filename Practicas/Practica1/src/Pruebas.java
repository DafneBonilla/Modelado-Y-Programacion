import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    public static void main(String[] args) {

        List<Fighter> fighters = new ArrayList<>();
        fighters.add(new Dittuu());
        fighters.add(new Korby());
        fighters.add(new MeganMan());
        
        RiggedFight order = new Case3();

        Ring show = new Ring(fighters, order);

        show.registerObserver(new Viewer("BlackDragon", show, "Korby"));
        show.registerObserver(new Viewer("CamiloElPoderoso", show, "MeganMan"));
        show.registerObserver(new Viewer("Dracarys", show, "Dittuu"));

        show.start();
    }
}
