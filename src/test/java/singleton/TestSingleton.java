package singleton;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestSingleton {
    @Test
    public void testSingleton() {
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            GetSingletonTask task = new GetSingletonTask();
            FutureTask<Singleton> futureTask = new FutureTask<Singleton>(task);
            taskList.add(futureTask);
            executor.submit(futureTask);
        }

        executor.shutdown();

        FutureTask<Singleton> firstTask = taskList.get(0);
        Singleton firstInstance = null;
        try {
            firstInstance = firstTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 100000; i++) {
            FutureTask<Singleton> task = taskList.get(i);
            try {
                Singleton s = task.get();
                assertEquals(firstInstance, s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSingletonSimple() {
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            GetSingletonSimpleTask task = new GetSingletonSimpleTask();
            FutureTask<SingletonSimple> futureTask = new FutureTask<SingletonSimple>(task);
            taskList.add(futureTask);
            executor.submit(futureTask);
        }

        executor.shutdown();

        FutureTask<SingletonSimple> firstTask = taskList.get(0);
        SingletonSimple firstInstance = null;
        try {
            firstInstance = firstTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 100000; i++) {
            FutureTask<SingletonSimple> task = taskList.get(i);
            try {
                SingletonSimple s = task.get();
                assertEquals(firstInstance, s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSingletonFail() {
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            GetSingletonFailTask task = new GetSingletonFailTask();
            FutureTask<SingletonFail> futureTask = new FutureTask<SingletonFail>(task);
            taskList.add(futureTask);
            executor.submit(futureTask);
        }

        executor.shutdown();

        FutureTask<SingletonFail> firstTask = taskList.get(0);
        SingletonFail firstInstance = null;
        try {
            firstInstance = firstTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 100000; i++) {
            FutureTask<SingletonFail> task = taskList.get(i);
            try {
                SingletonFail s = task.get();
                assertEquals(firstInstance, s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSingletonSlow() {
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            GetSingletonSlowTask task = new GetSingletonSlowTask();
            FutureTask<SingletonSlow> futureTask = new FutureTask<SingletonSlow>(task);
            taskList.add(futureTask);
            executor.submit(futureTask);
        }

        executor.shutdown();

        FutureTask<SingletonSlow> firstTask = taskList.get(0);
        SingletonSlow firstInstance = null;
        try {
            firstInstance = firstTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 100000; i++) {
            FutureTask<SingletonSlow> task = taskList.get(i);
            try {
                SingletonSlow s = task.get();
                assertEquals(firstInstance, s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    class GetSingletonTask implements Callable<Singleton> {

        public Singleton call() throws Exception {
            return Singleton.getInstance();
        }
    }

    class GetSingletonSimpleTask implements Callable<SingletonSimple> {

        public SingletonSimple call() throws Exception {
            return SingletonSimple.getInstance();
        }
    }

    class GetSingletonFailTask implements Callable<SingletonFail> {

        public SingletonFail call() throws Exception {
            return SingletonFail.getInstance();
        }
    }

    class GetSingletonSlowTask implements Callable<SingletonSlow> {

        public SingletonSlow call() throws Exception {
            return SingletonSlow.getInstance();
        }
    }
}
