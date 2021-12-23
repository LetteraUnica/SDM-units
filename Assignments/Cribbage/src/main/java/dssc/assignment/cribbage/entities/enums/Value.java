package dssc.assignment.cribbage.entities.enums;

public enum Value {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    NAN(null);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
