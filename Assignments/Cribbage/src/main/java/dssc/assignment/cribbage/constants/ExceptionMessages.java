package dssc.assignment.cribbage.constants;

public class ExceptionMessages {
    public static final String EXCEPTION_TOO_MANY_CARDS = "A hand must be represented by at most " + Constants.NUMBER_TOTAL_CARDS + " cards";
    public static final String EXCEPTION_TOO_FEW_CARDS = "A hand must be represented by at least " + Constants.NUMBER_TOTAL_CARDS + " cards";

    public static final String EXCEPTION_ILLEGAL_SUITE = " is not a valid suite";
    public static final String EXCEPTION_ILLEGAL_RANK = " is not a valid rank";
}
