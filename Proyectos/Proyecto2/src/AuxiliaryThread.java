import views.*;

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
            int i = 0;
            while (i < 60) {
                if (view.getStarted().get() == true) {
                    return;
                }
                Thread.sleep(1000);
                i++;
            }
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        if (view.getStarted().get() == false) {
            view.showText("El tiempo de espera ha terminado");
            view.showText("Terminando ejecucion");
            System.exit(0);
        }
    }

}
