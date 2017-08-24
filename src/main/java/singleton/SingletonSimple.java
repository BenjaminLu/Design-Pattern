package singleton;

public class SingletonSimple {
    private static volatile SingletonSimple s = new SingletonSimple();
    private SingletonSimple() {}

    public static SingletonSimple getInstance() {
        return s;
    }
}
