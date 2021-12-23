package dssc.assignment.cribbage.entities.bean;

import dssc.assignment.cribbage.entities.enums.Rank;
import dssc.assignment.cribbage.entities.enums.Suite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CribbageHand {
    final ArrayList<Card> handCards;
    final Card starterCard;

    public CribbageHand(List<Card> handCards, Card starterCard) {
        this.handCards = (ArrayList<Card>) handCards;
        this.starterCard = starterCard;
    }

    public List<Card> getHandCards() {
        return new ArrayList<>(handCards);
    }

    public Card getStarterCard() {
        return starterCard;
    }

    public List<Card> getAllCards() {
        ArrayList<Card> allCards = (ArrayList<Card>) getHandCards();
        allCards.add(getStarterCard());
        return allCards;
    }

    public List<Card> getHandCardsOfRank(Rank rank) {
        return getHandCards().
                stream().
                filter(card -> card.getRank() == rank).
                collect(Collectors.toList());
    }

    public List<Card> getHandCardsOfSuite(Suite suite) {
        return getHandCards().
                stream().
                filter(card -> card.getSuite() == suite).
                collect(Collectors.toList());
    }
}
