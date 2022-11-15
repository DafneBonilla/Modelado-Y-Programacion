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
            for (int i = 0; i < 60 * 1000; i++) {
                if (view.getStarted().get() == true) {
                    return;
                }
                Thread.sleep(1);
            }
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        if (view.getStarted().get() == false) {
            view.showText("El tiempo de espera ha terminado");
            System.out.println("Terminando ejecucion");
            System.exit(0);
        }
    }

}
