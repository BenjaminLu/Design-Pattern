package singleton;

public class SingletonFail {
    private static volatile SingletonFail s;
    private SingletonFail() {}

    public static SingletonFail getInstance() {
        if (s == null) {
            s = new SingletonFail();
        }

        return s;
    }
}
