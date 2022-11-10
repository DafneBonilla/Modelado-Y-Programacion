package player;

public enum Message {

    GET_NAME,
    
    SET_DECK,

    GET_SCORE,

    SET_SCORE,

    GET_BET,

    SET_BET,

    GET_WINS,

    SET_WINS,

    GET_TRIUMPH,

    GET_CONTINUE,

    ASK_CARD,

    SHOW_TEXT,

    END,

    INVALID;

    public String toString() {
        switch (this) {
            case GET_NAME:
                return "GET_NAME";
            case SET_DECK:
                return "SET_DECK";
            case GET_SCORE:
                return "GET_SCORE";
            case SET_SCORE:
                return "SET_SCORE";
            case GET_BET:
                return "GET_BET";
            case SET_BET:
                return "SET_BET";
            case GET_WINS:
                return "GET_WINS";
            case SET_WINS:
                return "SET_WINS";
            case GET_TRIUMPH:
                return "GET_TRIUMPH";
            case GET_CONTINUE:
                return "GET_CONTINUE";
            case ASK_CARD:
                return "ASK_CARD";
            case SHOW_TEXT:
                return "SHOW_TEXT";
            case END:
                return "END";
            case INVALID:
                return "INVALID";
            default:
                return "INVALID";
        }
    }

    public static Message getMessage(String message){
        switch (message) {
            case "GET_NAME":
                return GET_NAME;
            case "SET_DECK":
                return SET_DECK;
            case "GET_SCORE":
                return GET_SCORE;
            case "SET_SCORE":
                return SET_SCORE;
            case "GET_BET":
                return GET_BET;
            case "SET_BET":
                return SET_BET;
            case "GET_WINS":
                return GET_WINS;
            case "SET_WINS":
                return SET_WINS;
            case "GET_CONTINUE":
                return GET_CONTINUE;
            case "GET_TRIUMPH":
                return GET_TRIUMPH;
            case "ASK_CARD":
                return ASK_CARD;
            case "SHOW_TEXT":
                return SHOW_TEXT;
            case "END":
                return END;
            case "INVALID":
                return INVALID;
            default:
                return INVALID;
        }
    }

}
