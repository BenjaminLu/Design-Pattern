package singleton;

public class SingletonSlow {
    private static SingletonSlow s;
    private SingletonSlow() {}

    public static synchronized SingletonSlow getInstance() {
        // Double-checked locking
        if (s == null) {
            s = new SingletonSlow();
        }

        return s;
    }
}
