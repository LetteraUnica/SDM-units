package dssc.assignment.cribbage.rules;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.bean.CribbageHand;
import dssc.assignment.cribbage.entities.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dssc.assignment.cribbage.utilities.Math.binomial;

public class PairsRule implements CribbageScoreRule {
    @Override
    public int computeScore(CribbageHand cribbageHand) {
        Map<Rank, Integer> rankCountMap = getRankCountMap(cribbageHand.getAllCards());
        int pairScore = 0;
        for (int occurrences : rankCountMap.values()) {
            pairScore += computePairScoreFromNumberOfOccurrences(occurrences);
        }

        return pairScore;
    }

    private static int computePairScoreFromNumberOfOccurrences(int occurrences) {
        if (occurrences < Constants.NUMBER_OF_CARDS_FOR_PAIR) {
            return 0;
        }
        return Constants.PAIR_SCORE * binomial(occurrences, Constants.NUMBER_OF_CARDS_FOR_PAIR);
    }

    private static Map<Rank, Integer> getRankCountMap(List<Card> cards) {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        for (Card card : cards) {
            rankCountMap.computeIfPresent(card.getRank(), (k, v) -> v + 1);
            rankCountMap.putIfAbsent(card.getRank(), 1);
        }

        return rankCountMap;
    }
}
