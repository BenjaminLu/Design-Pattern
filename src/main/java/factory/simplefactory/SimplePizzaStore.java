package factory.simplefactory;

import factory.simplefactory.products.SimplePizza;

public class SimplePizzaStore {
    SimplePizzaFactory factory;

    public SimplePizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public SimplePizza orderPizza(String type) {
        SimplePizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
