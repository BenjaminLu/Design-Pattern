package singleton;

public class Singleton {
    private static volatile Singleton s;
    private Singleton() {}

    public static Singleton getInstance() {
        // Double-checked locking
        if (s == null) {
            // only one thread can enter this section
            synchronized (Singleton.class) {
                if (s == null) {
                    // lazy instantiate
                    s = new Singleton();
                }
            }
        }

        return s;
    }
}
