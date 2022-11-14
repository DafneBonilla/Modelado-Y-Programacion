package cards;

/**
 * Class to represent a card factory default
 */
public class CardFactoryDefault implements CardFactory {

    /**
     * Builds a card with the given color and value
     * 
     * @param color the color
     * @param value the value
     * @return the card built
     */
    @Override
    public Card build(int color, int value) {
        Card card = new Card();
        Color colorCard = null;
        switch (color) {
            case 1:
                colorCard = new Red(card);
                break;
            case 2:
                colorCard = new Blue(card);
                break;
            case 3:
                colorCard = new Yellow(card);
                break;
            case 4:
                colorCard = new Green(card);
                break;
            case 5:
                colorCard = new White(card);
                break;
            default:
                break;
        }
        card.setColor(colorCard);
        Value valueCard = null;
        switch (value) {
            case 0:
                valueCard = new Joker(card);
                break;
            case 14:
                valueCard = new Wizard(card);
                break;
            default:
                valueCard = new Number(card, value);
                break;
        }
        card.setValue(valueCard);
        return card;
    }

}
