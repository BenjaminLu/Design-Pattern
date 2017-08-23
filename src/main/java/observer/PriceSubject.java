package observer;

import java.util.ArrayList;
import java.util.List;

public class PriceSubject implements ISubject<Double> {
    private List<IObserver> observers = new ArrayList<IObserver>();
    public double latestPrice = 0;

    public void register(IObserver newObserver) {
        observers.add(newObserver);
    }

    public void unregister(IObserver observer) {
        if (observer != null && observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void update(Double price) {
        this.latestPrice = price;
        this.notifyObservers(price);
    }

    public void notifyObservers(Double price) {
        for (IObserver observer : observers) {
            observer.onPriceChange(price);
        }
    }
}
