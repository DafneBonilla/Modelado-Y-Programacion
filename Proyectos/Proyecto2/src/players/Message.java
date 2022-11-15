package players;

/**
 * Enum to represent the messages betwen the server and the client
 */
public enum Message {

    /* The messages */
    START, GET_NAME, SET_DECK, ASK_BET, GET_TRIUMPH, GET_CONTINUE, SHOW_TEXT, ASK_CARD, END, INVALID;

    /**
     * Returns the message in a string form
     * 
     * @return the message in a string form
     */
    public String toString() {
        switch (this) {
            case START:
                return "START";
            case GET_NAME:
                return "GET_NAME";
            case SET_DECK:
                return "SET_DECK";
            case ASK_BET:
                return "ASK_BET";
            case GET_TRIUMPH:
                return "GET_TRIUMPH";
            case GET_CONTINUE:
                return "GET_CONTINUE";
            case SHOW_TEXT:
                return "SHOW_TEXT";
            case ASK_CARD:
                return "ASK_CARD";
            case END:
                return "END";
            case INVALID:
                return "INVALID";
            default:
                return "INVALID";
        }
    }

    /**
     * Returns the message from a string
     * 
     * @param message the string to convert
     * @return the message
     */
    public static Message getMessage(String message) {
        switch (message) {
            case "START":
                return START;
            case "GET_NAME":
                return GET_NAME;
            case "SET_DECK":
                return SET_DECK;
            case "ASK_BET":
                return ASK_BET;
            case "GET_TRIUMPH":
                return GET_TRIUMPH;
            case "GET_CONTINUE":
                return GET_CONTINUE;
            case "SHOW_TEXT":
                return SHOW_TEXT;
            case "ASK_CARD":
                return ASK_CARD;
            case "END":
                return END;
            default:
                return INVALID;
        }
    }

}
