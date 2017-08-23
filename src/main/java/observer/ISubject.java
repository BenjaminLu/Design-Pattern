package observer;

public interface ISubject<T> {
    void update(T price);
    void notifyObservers(T price);
    void register(IObserver observer);
    void unregister(IObserver observer);
}
