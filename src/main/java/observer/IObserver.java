package observer;

public interface IObserver<T> {
    void onPriceChange(T newPrice);
    void subscribe(ISubject subject);
    void unsubscribe(ISubject subject);
}
