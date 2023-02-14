package bluesight.card;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testDateFromNow(){
        Card card = new Card("Card title", "Card description", LocalDate.of(2022, 12, 31));
        card.nowMinusStartDate();
    }

}