package player;

public enum Message {
    
    SET_DECK,

    GET_SCORE,

    SET_SCORE,

    GET_BET,

    SET_BET,

    GET_WINS,

    SET_WINS,

    ASK_CARD,

    INVALID;

    public String toString() {
        switch (this) {
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
            case ASK_CARD:
                return "ASK_CARD";
            case INVALID:
                return "INVALID";
            default:
                return "INVALID";
        }
    }

    public Message getMessage(String message){
        switch (message) {
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
            case "ASK_CARD":
                return ASK_CARD;
            case "INVALID":
                return INVALID;
            default:
                return INVALID;
        }
    }

}
