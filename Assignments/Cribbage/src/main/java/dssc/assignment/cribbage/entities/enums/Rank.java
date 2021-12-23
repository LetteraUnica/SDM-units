package dssc.assignment.cribbage.entities.enums;

public enum Rank {
    ACE('A'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('0'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    NAN(' ');

    private final char character;

    Rank(char character) {
        this.character = character;
    }

    public Value getRankScore() {
        switch (this) {
            case ACE:
                return Value.ONE;
            case TWO:
                return Value.TWO;
            case THREE:
                return Value.THREE;
            case FOUR:
                return Value.FOUR;
            case FIVE:
                return Value.FIVE;
            case SIX:
                return Value.SIX;
            case SEVEN:
                return Value.SEVEN;
            case EIGHT:
                return Value.EIGHT;
            case NINE:
                return Value.NINE;
            case TEN:
            case JACK:
            case KING:
            case QUEEN:
                return Value.TEN;
            default:
                return Value.NAN;
        }
    }

    public char getCharacter() {
        return character;
    }
}
