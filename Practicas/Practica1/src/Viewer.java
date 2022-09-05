import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to represent the viewer of the fight
 * The viewer has a name, a history of the fight, a support, a ring to watch,
 * and a current move in text form
 */
public class Viewer implements Observer {

    /* The name of the viewer */
    private String name;
    /* The history of the fight */
    private String history;
    /* The support of the viewer */
    private String support;
    /* The ring to watch */
    private Ring watch;
    /* The current move in text form */
    private String move;

    /**
     * Constructor of the viewer
     * 
     * @param name    the name of the viewer
     * @param support the support of the viewer
     * @param watch   the ring to watch
     */
    public Viewer(String name, Ring watch, String support) {
        this.name = name;
        this.watch = watch;
        this.history = "Bienvenido!\nEstas apoyando a " + support + "\n";
        this.support = support;
        this.move = "";
    }

    /**
     * Updates the viewer with the current move of the ring
     */
    @Override
    public void update() {
        if (watch != null) {
            this.move = watch.getMove();
            this.history += move + "\n";
        }
    }

    /**
     * Returns the name of the viewer
     * 
     * @return the name of the viewer
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the history of the fight
     * 
     * @return the history of the fight
     */
    public String getHistory() {
        return history;
    }

    /**
     * Returns the support of the viewer
     * 
     * @return the support of the viewer
     */
    public String getSupport() {
        return support;
    }

    /**
     * Updates the viewer history depending on the support
     * 
     * @param winner the winner of the fight
     */
    public void finish(String winner) {
        if (winner.equals(support)) {
            this.history += "Felicidades, el peleador que apoyaste gano!";
        } else {
            this.history += "Lo siento, el peleador que apoyaste perdio!";
        }
    }

    /**
     * Writes the history of the fight in a file
     * 
     * @throws IOException if theres an IO error
     */
    public void leave() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(name + "History.txt")));
        bw.write(history);
        bw.flush();
        bw.close();
    }

    /**
     * Makes the viewer leave the ring (stop watching)
     */
    public void stopWatching() {
        watch.removeObserver(this);
        watch = null;
    }

}
