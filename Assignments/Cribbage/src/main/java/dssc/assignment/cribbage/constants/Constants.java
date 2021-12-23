package dssc.assignment.cribbage.constants;

import dssc.assignment.cribbage.entities.enums.Rank;

public class Constants {
    public static final int NUMBER_HAND_CARDS = 4;
    public static final int NUMBER_STARTER_CARDS = 1; // You should not change this

    public static final int NUMBER_TOTAL_CARDS = NUMBER_HAND_CARDS + NUMBER_STARTER_CARDS;

    public static final int CHARACTERS_PER_CARD = 2;

    public static final int CRIBBAGE_HAND_CHARACTERS_COUNT = NUMBER_TOTAL_CARDS * CHARACTERS_PER_CARD;

    public static final int RANK_POSITION = 0;
    public static final int SUITE_POSITION = 1;
    public static final boolean RANK_FIRST = true;

    public static final int STARTER_CARD_POSITION = 4;

    public static final int FIFTEEN_TWO_SCORE = 2;
    public static final int FIFTEEN_TWO_TOTAL_RANK_SUM = 15;
    public static final int FIFTEEN_TWO_MINIMUM_NUMBER_OF_CARDS = 2;

    public static final int FLUSH_SCORE = 4;
    public static final int ADDITIONAL_FLUSH_SCORE = 1;

    public static final int PAIR_SCORE = 2;
    public static final int NUMBER_OF_CARDS_FOR_PAIR = 2;

    public static final int NOB_SCORE = 1;
    public static final Rank NOB_SCORE_RANK = Rank.JACK;
}
