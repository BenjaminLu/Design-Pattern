package factory.generalfactory;

import factory.generalfactory.products.*;

public class NYPizzaFactory extends PizzaFactory {
    private String pizzaPackageName = "factory.generalfactory.products";

    public Pizza createPizza(String type) {
        String className = this.pizzaPackageName  + "." + type;

        Pizza pizza = null;
        try {
            Class<?> c = Class.forName(className);
            pizza = (Pizza) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pizza;
    }
}
