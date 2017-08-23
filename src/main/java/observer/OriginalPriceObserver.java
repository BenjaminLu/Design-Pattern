package observer;

public class OriginalPriceObserver implements IObserver<Double> {
    public double price = 0;

    public void onPriceChange(Double newPrice) {
        this.price = newPrice;
    }

    public void subscribe(ISubject subject) {
        subject.register(this);
    }

    public void unsubscribe(ISubject subject) {
        subject.unregister(this);
    }
}
