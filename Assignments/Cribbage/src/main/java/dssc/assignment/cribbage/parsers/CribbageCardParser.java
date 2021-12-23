package dssc.assignment.cribbage.parsers;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.enums.Rank;
import dssc.assignment.cribbage.entities.enums.Suite;


public class CribbageCardParser {
    public static Card parseCard(String cardAsText) {
        Rank rank = parseRank(cardAsText);
        Suite suite = parseSuite(cardAsText);

        return new Card(rank, suite);
    }

    private static Rank parseRank(String cardAsText) {
        char rankCharacter = cardAsText.charAt(Constants.RANK_POSITION);

        for (Rank rank : Rank.values()) {
            if (rank.getCharacter() == rankCharacter) {
                return rank;
            }
        }

        return Rank.NAN;
    }

    private static Suite parseSuite(String cardAsText) {
        char suiteCharacter = cardAsText.charAt(Constants.SUITE_POSITION);

        for (Suite suite : Suite.values()) {
            if (suite.getCharacter() == suiteCharacter) {
                return suite;
            }
        }

        return Suite.NAN;
    }
}
