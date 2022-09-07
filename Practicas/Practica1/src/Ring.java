import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent the ring where the fights will take place
 * The ring has a list of fighters, a list of skills, a boolean to know if the
 * fight is over, and a list of actions, the move in text that happened , a
 * winner, a maximum number of rounds, a
 * current round and a current action
 */
public class Ring implements Subject {

    /* The list of viewers */
    private List<Viewer> viewers = new ArrayList<Viewer>();
    /* The list of fighters */
    private List<Fighter> fighters = new ArrayList<Fighter>();
    /* The boolean to know if the fight is over */
    private boolean over;
    /* The list of actions */
    private RiggedFight order;
    /* The move in text that happened */
    private String move;
    /* The winner of the fight */
    private String winner;
    /* The maximum number of rounds */
    private int maxRounds;
    /* The current round */
    private int round;
    /* The current action */
    private Action action;

    /**
     * Constructor of the ring
     * 
     * @param fighters the list of fighters
     * @param order    the order that the fight will take
     */
    public Ring(List<Fighter> fighters, RiggedFight order) {
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

    /**
     * Registers a viewer to the ring
     * 
     * @param o the viewer to be registered
     */
    @Override
    public void registerObserver(Observer o) {
        viewers.add((Viewer) o);
    }

    /**
     * Removes a viewer from the ring
     * 
     * @param o the viewer to be removed
     */
    @Override
    public void removeObserver(Observer o) {
        viewers.remove(o);
    }

    /**
     * Notifies the viewers of the ring
     */
    @Override
    public void notifyObserver() {
        if (viewers.size() > 0) {
            for (Observer o : viewers) {
                o.update();
            }
        }
    }

    /**
     * Returns the move in text that happened
     * 
     * @return the move in text that happened
     */
    public String getMove() {
        return move;
    }

    /**
     * Begins the fight
     */
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
            if (round % 3 == 1) {
                fighterStatus();
            }
            action = order.getAction();
            if (action == null) {
                over = true;
                break;
            }
            doAction();
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
            end();
        }
    }

    /**
     * Notifies the viewers of the status of the fighters
     */
    private void fighterStatus() {
        String aux = "El estado de los luchadores es: " + "\n";
        for (Fighter f : fighters) {
            aux += f.getInfo() + "\n";
        }
        move = aux;
        notifyObserver();
    }

    /**
     * Does the current action
     */
    private void doAction() {
        int actor = action.getActor();
        Fighter actorF = fighters.get(actor);
        if (actorF.isAlive()) {
            switch (action.getMovement()) {
                case "a":
                    int target = action.getTarget();
                    Fighter targetF = fighters.get(target);
                    if (targetF.isAlive()) {
                        int dmg = actorF.hit(targetF);
                        move = "Movimiento " + round + ": " + actorF.getName() + " golpea a " + targetF.getName()
                                + " por " + dmg + " puntos de danio";
                    } else {
                        move = "Movimiento " + round + ": " + actorF.getName() + " ataca a " + targetF.getName()
                                + " pero este ya esta muerto";
                    }
                    break;
                case "d":
                    int blk = actorF.defend();
                    move = "Movimiento " + round + ": " + actorF.getName() + " se defiende y obtiene " + blk
                            + " puntos de escudo";
                    break;
                case "t":
                    String transform = actorF.transform();
                    if (transform == null) {
                        move = "Movimiento " + round + ": " + actorF.getName() + " no puede transformarse";
                    } else {
                        move = "Movimiento " + round + ": " + actorF.getName() + " se transforma en " + transform;
                    }
                    break;
                default:
                    move = "Movimiento " + ": Invalid move";
                    break;
            }
        } else {
            move = "Movimiento " + round + ": El luchador " + actorF.getName()
                    + " paso a mejor vida, no puede hacer nada";
        }
        notifyObserver();
    }

    /**
     * Ends the fight and makes the viewers leave (write their files)
     */
    private void end() {
        for (Viewer v : viewers) {
            try {
                v.leave();
            } catch (IOException ioe) {
                System.out.println("Hubo un error de entrada/salida del observador " + v.getName());
                continue;
            }
        }
    }

}
