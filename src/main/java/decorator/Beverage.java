package decorator;

abstract public class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return this.description;
    }

    abstract public double cost();
}
