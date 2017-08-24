package decorator;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestDecorator {
    @Test
    public void testDecoratorPattern() {
        Beverage espresso = new Espresso();

        assertEquals(espresso.getDescription(), "Espresso");
        assertEquals(espresso.cost(), 1.99, 0);

        Beverage darkRoast = new DarkRoast();

        assertEquals(darkRoast.getDescription(), "DarkRoast");
        assertEquals(darkRoast.cost(), 0.89, 0);

        espresso = new Mocha(espresso);
        espresso = new Mocha(espresso);
        espresso = new Whip(espresso);

        assertEquals(espresso.getDescription(), "Espresso, Mocha, Mocha, Whip");
        assertEquals(espresso.cost(), 1.99 + 0.20 + 0.20 + 0.30, 0);

        darkRoast = new Soy(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);

        assertEquals(darkRoast.getDescription(), "DarkRoast, Soy, Mocha, Whip");
        assertEquals(darkRoast.cost(), 0.89 + 0.10 + 0.20 + 0.30, 0);
    }
}
