package factory.generalfactory;

import factory.generalfactory.products.Pizza;

abstract public class PizzaFactory {
    abstract public Pizza createPizza(String type);
}
