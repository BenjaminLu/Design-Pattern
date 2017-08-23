package singleton;

public class SingletonFail {
    private static SingletonFail s;
    private SingletonFail() {}

    public static SingletonFail getInstance() {
        if (s == null) {
            s = new SingletonFail();
        }

        return s;
    }
}
