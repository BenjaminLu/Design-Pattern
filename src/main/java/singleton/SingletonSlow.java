package singleton;

public class SingletonSlow {
    private static volatile SingletonSlow s;
    private SingletonSlow() {}

    public static synchronized SingletonSlow getInstance() {
        if (s == null) {
            s = new SingletonSlow();
        }

        return s;
    }
}
