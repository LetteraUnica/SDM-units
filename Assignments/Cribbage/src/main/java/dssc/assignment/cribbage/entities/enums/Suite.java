package dssc.assignment.cribbage.entities.enums;

public enum Suite {
    CLUBS('C'),
    DIAMONDS('D'),
    HEART('H'),
    SPADES('S'),
    NAN(' ');

    private final char character;

    Suite(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }


}
