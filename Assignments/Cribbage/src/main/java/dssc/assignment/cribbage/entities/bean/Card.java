package dssc.assignment.cribbage.entities.bean;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.entities.enums.Rank;
import dssc.assignment.cribbage.entities.enums.Suite;

import java.util.Objects;

public class Card {
    final Rank rank;
    final Suite suite;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public static boolean hasNullSuite(Card card) {
        return card.getSuite() == Suite.NAN;
    }

    public static boolean hasNullRank(Card card) {
        return card.getRank() == Rank.NAN;
    }

    public Rank getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public boolean hasSameRank(Card otherCard) {
        return getRank() == otherCard.getRank();
    }

    public boolean hasSameSuite(Card otherCard) {
        return getSuite() == otherCard.getSuite();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }

        Card card = (Card) other;

        return hasSameSuite(card) && hasSameRank(card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suite);
    }

    @Override
    public String toString() {
        String suiteString = Character.toString(suite.getCharacter());
        String rankString = Character.toString(rank.getCharacter());
        if (Constants.RANK_FIRST) {
            return rankString + suiteString;
        }
        return suiteString + rankString;
    }
}
