package dssc.assignment.cribbage.parsers;

import dssc.assignment.cribbage.constants.Constants;
import dssc.assignment.cribbage.constants.ExceptionMessages;
import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.bean.CribbageHand;
import dssc.assignment.cribbage.exceptions.IllegalRankException;
import dssc.assignment.cribbage.exceptions.IllegalSuiteException;
import dssc.assignment.cribbage.exceptions.IncorrectNumberOfCardsException;

import java.util.ArrayList;
import java.util.List;

import static dssc.assignment.cribbage.utilities.Utils.joinLists;
import static dssc.assignment.cribbage.utilities.Utils.splitStringEvery;

public class CribbageHandParser {
    public static CribbageHand parseHand(String handAsString) throws IncorrectNumberOfCardsException, IllegalRankException, IllegalSuiteException {
        checkInputLength(handAsString);

        List<Card> parsedCards = parseCards(handAsString);

        checkParsedCards(parsedCards);

        List<Card> handCards = getHandCards(parsedCards);
        Card starterCard = getStarterCard(parsedCards);

        return new CribbageHand(handCards, starterCard);
    }

    private static void checkParsedCards(List<Card> parsedCards) throws IllegalRankException, IllegalSuiteException {
        for (int index = 0; index < parsedCards.size(); index++) {
            if (Card.hasNullRank(parsedCards.get(index))) {
                throw new IllegalRankException("Card number " + (index + 1) + " has invalid rank");
            }

            if (Card.hasNullSuite(parsedCards.get(index))) {
                throw new IllegalSuiteException("Card number " + (index + 1)  + " has invalid suite");
            }
        }

    }

    private static Card getStarterCard(List<Card> parsedCards) {
        return parsedCards.get(Constants.STARTER_CARD_POSITION);
    }

    private static List<Card> getHandCards(List<Card> parsedCards) {
        List<Card> firstHandCards = parsedCards.subList(0, Constants.STARTER_CARD_POSITION);
        List<Card> secondHandCards = parsedCards.subList(Constants.STARTER_CARD_POSITION + Constants.NUMBER_STARTER_CARDS, Constants.NUMBER_TOTAL_CARDS);
        return joinLists(firstHandCards, secondHandCards);
    }

    private static List<Card> parseCards(String handAsString) {
        List<Card> cards = new ArrayList<>();
        List<String> cardsAsString = splitStringEvery(handAsString, Constants.CHARACTERS_PER_CARD);

        for (String cardAsString : cardsAsString) {
            Card card = CribbageCardParser.parseCard(cardAsString);
            cards.add(card);
        }

        return cards;
    }

    public static void checkInputLength(String input) throws IncorrectNumberOfCardsException {
        if (input.length() > Constants.CRIBBAGE_HAND_CHARACTERS_COUNT) {
            throw new IncorrectNumberOfCardsException(ExceptionMessages.EXCEPTION_TOO_MANY_CARDS);
        }
        if (input.length() < Constants.CRIBBAGE_HAND_CHARACTERS_COUNT) {
            throw new IncorrectNumberOfCardsException(ExceptionMessages.EXCEPTION_TOO_FEW_CARDS);
        }
    }
}
