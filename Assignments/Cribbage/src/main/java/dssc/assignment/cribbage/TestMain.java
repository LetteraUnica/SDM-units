package dssc.assignment.cribbage;

import dssc.assignment.cribbage.entities.bean.CribbageHand;
import dssc.assignment.cribbage.exceptions.IllegalRankException;
import dssc.assignment.cribbage.exceptions.IllegalSuiteException;
import dssc.assignment.cribbage.exceptions.IncorrectNumberOfCardsException;
import dssc.assignment.cribbage.parsers.CribbageHandParser;

public class TestMain {
    public static void main(String[] args) {
        String handAsString = "5H5D5SJC5C";
        CribbageHand cribbageHand = null;
        try {
            cribbageHand = CribbageHandParser.parseHand(handAsString);
        } catch (IncorrectNumberOfCardsException | IllegalRankException | IllegalSuiteException e) {
            e.printStackTrace();
        }

        System.out.println(cribbageHand.getAllCards());
    }
}
