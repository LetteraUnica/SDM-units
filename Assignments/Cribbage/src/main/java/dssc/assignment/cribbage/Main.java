package dssc.assignment.cribbage;

import dssc.assignment.cribbage.controllers.CribbageHandController;
import dssc.assignment.cribbage.entities.bean.CribbageHand;
import dssc.assignment.cribbage.exceptions.IllegalRankException;
import dssc.assignment.cribbage.exceptions.IllegalSuiteException;
import dssc.assignment.cribbage.exceptions.IncorrectNumberOfCardsException;
import dssc.assignment.cribbage.parsers.CribbageHandParser;
import dssc.assignment.cribbage.rules.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String handAsString = "5H 5D 5S JC 5C";
        handAsString = handAsString.replaceAll(" ", "");

        CribbageHand cribbageHand;
        try {
            cribbageHand = CribbageHandParser.parseHand(handAsString);
        } catch (IncorrectNumberOfCardsException | IllegalRankException | IllegalSuiteException e) {
            System.out.println(e.getMessage());
            return;
        }

        Set<CribbageScoreRule> defaultCribbageScoreRules = Set.of(new FifteenTwoRule(),
                new FlushRule(), new PairsRule(), new NobRule());

        for (var rule : defaultCribbageScoreRules) {
            System.out.println(rule.getClass() + " " + rule.computeScore(cribbageHand));
        }

        int handScore = CribbageHandController.computeHandScore(cribbageHand, defaultCribbageScoreRules);
        System.out.println("Total score: " + handScore);
    }
}
