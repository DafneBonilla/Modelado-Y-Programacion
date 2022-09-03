import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ring implements Subject {

    private List<Viewer> viewers = new ArrayList<Viewer>();

    private List<Fighter> fighters = new ArrayList<Fighter>();

    private boolean over;

    private RiggedFight order;

    private String move;

    private String winner;

    private int maxRounds;

    private int round;

    private Action action;

    public Ring(ArrayList<Fighter> fighters, RiggedFight order) {
        viewers = new ArrayList<Viewer>();
        this.fighters = fighters;
        over = false;
        this.order = order;
        this.move = "";
        this.winner = "";
        this.maxRounds = order.getMaxRounds();
        this.round = 1;
        this.action = null;
    }
    
        
    @Override
    public void registerObserver(Observer o) {
        viewers.add((Viewer) o);
    }

    @Override
    public void removeObserver(Observer o) {
        viewers.remove(o);
    }

    @Override
    public void notifyObserver() {
        if (viewers.size() > 0) {
            for (Observer o : viewers) {
                o.update();
            }
        }
    }   

    public String getMove() {
        return move;
    }

    public void start() {
        while (round <= maxRounds) {
            int i = 0;
            for (Fighter f : fighters) {
                if (!f.isAlive()) {
                    i++;
                }
            }
            if (i == fighters.size() - 1) {
                over = true;
                break;
            }
            if (round % 3 == 0) {
                String aux = "El estado de los luchadores es: " + "\n";
                for (Fighter f : fighters) {
                    aux += f.getInfo() + "\n";
                }
                move = aux;
                notifyObserver();
            }
            action = order.getAction();
            int actor = action.getActor();
            Fighter actorF = fighters.get(actor);
            if (actorF.isAlive()) {
                switch (action.getMovement()) {
                    case "a":
                        int target = action.getTarget();
                        Fighter targetF = fighters.get(target);
                        if (targetF.isAlive()) {
                            int dmg = actorF.hit(targetF);
                            move = "Movimiento " + round + ": " + actorF.getName() + " golpea a " + targetF.getName() + " por " + dmg + " puntos de daño";
                        } else {
                            move = "Movimiento " + round + ": " + actorF.getName() + " ataca a " + targetF.getName() + " pero este ya esta muerto";
                        }
                        break;
                    case "d":
                        int blk = actorF.defend();
                        move = "Movimiento " + round + ": " + actorF.getName() + " se defiende y obtiene " + blk + " puntos de escudo";
                        break;
                    case "t":
                        String transform = actorF.transform();
                        move = "Movimiento " + round + ": " + actorF.getName() + " se transforma en " + transform;
                        break;
                    default:
                        move = "Movimiento "+ ": Invalid move";
                        break;
                }
            } else {
                move = "Movimiento" + round + ": El luchador " + actorF.getName() + " paso a mejor vida, no puede hacer nada";
            }
            notifyObserver();
            round++;
            if (over) {
                break;
            }
        }
        if (over) {
            int i = 0;
            for (Fighter f : fighters) {
                if (f.isAlive()) {
                    i++;
                }
            }
            if (i == 1) {
                for (Fighter f : fighters) {
                    if (f.isAlive()) {
                        winner = f.getName();
                    }
                }
                move = "El ganador es: " + winner;
                notifyObserver();
                for (Viewer v : viewers) {
                    v.finish(winner);
                }
            } else {
                winner = "Empate";
                move = "Fue un empate";
                notifyObserver();
                for (Viewer v : viewers) {
                    v.finish(winner);
                }
            }
            for (Viewer v : viewers) {
                try {
                    v.leave();
                } catch (IOException e) {
                    System.out.println("Hubo un error de entrada/salida del observador " + v.getName());
                    continue;
                }
            }
        }
    }

}
