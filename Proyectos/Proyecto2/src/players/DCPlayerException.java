package players;

import java.io.IOException;

/**
 * Exception to use when a player disconnects or theres a communication error
 */
public class DCPlayerException extends IOException {

    /**
     * Constructor
     */
    public DCPlayerException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message the message
     */
    public DCPlayerException(String message) {
        super(message);
    }

}
