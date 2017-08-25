package factory;

import factory.generalfactory.ChicagoPizzaFactory;
import factory.generalfactory.NYPizzaFactory;
import factory.generalfactory.PizzaStore;
import factory.generalfactory.products.*;
import factory.simplefactory.SimplePizzaStore;
import factory.simplefactory.products.*;
import factory.simplefactory.SimplePizzaFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFactory {

    @Test
    public void testSimpleFactory() {
        SimplePizzaStore pizzaStore = new SimplePizzaStore(new SimplePizzaFactory());

        SimplePizza cheesePizza = pizzaStore.orderPizza("cheese");
        SimplePizza pepperoniPizza = pizzaStore.orderPizza("pepperoni");
        SimplePizza clamPizza = pizzaStore.orderPizza("clam");
        SimplePizza veggiePizza = pizzaStore.orderPizza("veggie");

        assertTrue(cheesePizza instanceof CheesePizza);
        assertTrue(pepperoniPizza instanceof PepperoniPizza);
        assertTrue(clamPizza instanceof ClamPizza);
        assertTrue(veggiePizza instanceof VeggiePizza);
    }

    @Test
    public void testFactory() {
        PizzaStore pizzaStoreNY = new PizzaStore(new NYPizzaFactory());
        PizzaStore pizzaStoreChicago = new PizzaStore(new ChicagoPizzaFactory());

        Pizza pizza1 = pizzaStoreNY.orderPizza("NYStyleCheesePizza");
        Pizza pizza2 = pizzaStoreNY.orderPizza("NYStylePepperoniPizza");
        Pizza pizza3 = pizzaStoreNY.orderPizza("NYStyleClamPizza");
        Pizza pizza4 = pizzaStoreNY.orderPizza("NYStyleVeggiePizza");

        assertTrue(pizza1 instanceof NYStyleCheesePizza);
        assertTrue(pizza2 instanceof NYStylePepperoniPizza);
        assertTrue(pizza3 instanceof NYStyleClamPizza);
        assertTrue(pizza4 instanceof NYStyleVeggiePizza);

        Pizza pizza5 = pizzaStoreChicago.orderPizza("ChicagoCheesePizza");
        Pizza pizza6 = pizzaStoreChicago.orderPizza("ChicagoPepperoniPizza");
        Pizza pizza7 = pizzaStoreChicago.orderPizza("ChicagoClamPizza");
        Pizza pizza8 = pizzaStoreChicago.orderPizza("ChicagoVeggiePizza");

        assertTrue(pizza5 instanceof ChicagoCheesePizza);
        assertTrue(pizza6 instanceof ChicagoPepperoniPizza);
        assertTrue(pizza7 instanceof ChicagoClamPizza);
        assertTrue(pizza8 instanceof ChicagoVeggiePizza);
    }
}
