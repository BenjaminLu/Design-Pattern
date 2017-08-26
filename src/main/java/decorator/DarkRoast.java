package decorator;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "DarkRoast";
    }

    public double cost() {
        return .89;
    }
}
