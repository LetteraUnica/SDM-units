package dssc.assignment.cribbage.rules;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.bean.CribbageHand;

import java.util.List;

public class NobRule implements CribbageScoreRule {
    @Override
    public int computeScore(CribbageHand cribbageHand) {
        List<Card> possibleNobCards = cribbageHand.getHandCardsOfRank(Constants.NOB_SCORE_RANK);
        if (isNob(possibleNobCards, cribbageHand.getStarterCard())) {
            return Constants.NOB_SCORE;
        }
        return 0;
    }

    private boolean isNob(List<Card> possibleNobCards, Card starterCard) {
        for (Card card : possibleNobCards) {
            if (card.hasSameSuite(starterCard)) {
                return true;
            }
        }
        return false;
    }
}
