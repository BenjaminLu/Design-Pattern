package observer;

public class RoundPriceObserver implements IObserver<Double> {
    public int price = 0;

    public void onPriceChange(Double newPrice) {
        this.price = (int) Math.round(newPrice);
    }

    public void subscribe(ISubject subject) {
        subject.register(this);
    }

    public void unsubscribe(ISubject subject) {
        subject.unregister(this);
    }
}
