package observer;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestObserver {
    @Test
    public void testObserverPattern() {
        double newPrice = 15.3;
        double expectedPrice = newPrice;
        int expectedRoundedPrice = (int) Math.round(newPrice);
        ISubject subject = new PriceSubject();
        OriginalPriceObserver originalPriceObserver = new OriginalPriceObserver();
        RoundPriceObserver roundPriceObserver = new RoundPriceObserver();

        originalPriceObserver.subscribe(subject);
        roundPriceObserver.subscribe(subject);

        subject.update(newPrice);
        assertEquals(expectedPrice, originalPriceObserver.price, 0);
        assertEquals(expectedRoundedPrice, roundPriceObserver.price);

        roundPriceObserver.unsubscribe(subject);

        double anotherNewPrice = 16.7;
        expectedPrice = anotherNewPrice;

        subject.update(anotherNewPrice);

        assertEquals(expectedPrice, originalPriceObserver.price, 0);
        assertEquals(expectedRoundedPrice, roundPriceObserver.price);
    }
}
