package dssc.assignment.cribbage.rules;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.bean.CribbageHand;

import java.util.List;
import java.util.Set;

import static dssc.assignment.cribbage.utilities.Utils.getAllSubListsOfNElements;

public class FifteenTwoRule implements CribbageScoreRule {
    @Override
    public int computeScore(CribbageHand cribbageHand) {
        List<Card> allCards = cribbageHand.getAllCards();
        int fifteenTwoScore = 0;
        for (int n_cards = Constants.FIFTEEN_TWO_MINIMUM_NUMBER_OF_CARDS; n_cards < allCards.size(); n_cards++) {
            Set<List<Card>> allListsOfNElements = getAllSubListsOfNElements(allCards, n_cards);
            for (List<Card> listOfNElements : allListsOfNElements) {
                if (isFifteenTwo(listOfNElements)) {
                    fifteenTwoScore += Constants.FIFTEEN_TWO_SCORE;
                }
            }
        }
        return fifteenTwoScore;
    }

    private static boolean isFifteenTwo(List<Card> cards) {
        return rankSum(cards) == Constants.FIFTEEN_TWO_TOTAL_RANK_SUM;
    }

    private static int rankSum(List<Card> list) {
        int rankSum = 0;
        for (Card card : list) {
            rankSum += card.getRank().getRankScore().getValue();
        }

        return rankSum;
    }
}
