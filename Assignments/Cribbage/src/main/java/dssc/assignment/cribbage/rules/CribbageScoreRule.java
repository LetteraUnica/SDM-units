package dssc.assignment.cribbage.rules;

import dssc.assignment.cribbage.entities.bean.CribbageHand;

public interface CribbageScoreRule {
    int computeScore(CribbageHand cribbageHand);
}
