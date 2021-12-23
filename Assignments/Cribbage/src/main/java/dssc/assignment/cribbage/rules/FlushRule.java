package dssc.assignment.cribbage.rules;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.bean.CribbageHand;

import java.util.List;
import java.util.stream.Collectors;

public class FlushRule implements CribbageScoreRule {
    @Override
    public int computeScore(CribbageHand cribbageHand) {
        if (isFlush(cribbageHand)) {
            return Constants.FLUSH_SCORE + computeAdditionalFlushScore(cribbageHand);
        }
        return 0;
    }

    private static boolean isFlush(CribbageHand cribbageHand) {
        List<Card> handCards = cribbageHand.getHandCards();

        return numberOfUniqueSuits(handCards) == 1;
    }

    private static int numberOfUniqueSuits(List<Card> handCards) {
        return handCards.
                stream().
                map(Card::getSuite).
                collect(Collectors.toSet()).
                size();
    }


    private static int computeAdditionalFlushScore(CribbageHand cribbageHand) {
        if (numberOfUniqueSuits(cribbageHand.getAllCards()) == 1) {
            return Constants.ADDITIONAL_FLUSH_SCORE;
        }
        return 0;
    }

}
