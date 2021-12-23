package dssc.assignment.cribbage.controllers;

import dssc.assignment.cribbage.rules.*;
import dssc.assignment.cribbage.entities.bean.CribbageHand;

import java.util.Set;


public class CribbageHandController {
    public static int computeHandScore(CribbageHand cribbageHand, Set<CribbageScoreRule> cribbageScoreRules) {
        int totalScore = 0;
        for (CribbageScoreRule rule : cribbageScoreRules) {
            totalScore += rule.computeScore(cribbageHand);
        }
        return totalScore;
    }
}
