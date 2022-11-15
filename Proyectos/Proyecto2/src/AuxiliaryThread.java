import views.*;
import players.*;

public class AuxiliaryThread implements Runnable {

    private View view;

    public AuxiliaryThread(View view) {
        this.view = view;
    }

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
