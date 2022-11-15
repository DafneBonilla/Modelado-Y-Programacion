import views.*;
import players.*;

/**
 * Class to help the player know to disconnect if one minute has passed and the
 * game has not started
 * It has a view (instance of {@link View})
 */
public class AuxiliaryThread implements Runnable {

    /* The view */
    private View view;

    /**
     * Constructor
     * 
     * @param view the view
     */
    public AuxiliaryThread(View view) {
        this.view = view;
    }

    /**
     * Method to run the thread
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        if (!view.getStarted()) {
            try {
                view.getPlayer().end();
            } catch (DCPlayerException dcpe) {
            }
        }
    }

}
