package dssc.assignment.cribbage;

import dssc.assignment.cribbage.entities.bean.Card;
import dssc.assignment.cribbage.entities.enums.Rank;
import dssc.assignment.cribbage.entities.enums.Suite;
import dssc.assignment.cribbage.parsers.CribbageCardParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseCribbageHandTest {

    @Test
    void parseOneCard() {
        Card card = CribbageCardParser.parseCard("5H");
        assertAll(
                () -> assertEquals(Rank.FIVE, card.getRank()),
                () -> assertEquals(Suite.HEART, card.getSuite())
        );
    }
}
