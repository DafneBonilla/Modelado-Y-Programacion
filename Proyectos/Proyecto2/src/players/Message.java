package players;

public enum Message {

    GET_NAME,

    SET_DECK,

    ASK_BET,

    GET_TRIUMPH,

    GET_CONTINUE,

    SHOW_TEXT,

    ASK_CARD,

    END,

    INVALID;

    public String toString() {
        switch (this) {
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

    public static Message getMessage(String message) {
        switch (message) {
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
