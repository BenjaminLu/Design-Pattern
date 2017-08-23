package singleton;

public class SingletonSimple {
    private static SingletonSimple s = new SingletonSimple();
    private SingletonSimple() {}

    public static SingletonSimple getInstance() {
        return s;
    }
}
