package ro.amihaescu.jenkov;

import java.util.ArrayList;
import java.util.Timer;

public class VirtualThreadExample1 {

    public static void main(String[] args) throws InterruptedException {
        var numberOfThreads = 100_000;
        Runnable runnable = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
//                System.out.println("Hello from virtual thread " + i);
                sum += i;
            }
        };
        System.out.printf("%d platform threads took %dms \n",numberOfThreads, runThreads(numberOfThreads, runnable, false));
        System.out.printf("%d virtual threads took %dms \n", numberOfThreads, runThreads(numberOfThreads, runnable, true));

    }

    private static long runThreads(int numberOfThreads, Runnable runnable, boolean virtual) throws InterruptedException {
        var startTime = System.currentTimeMillis();
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < numberOfThreads; i++) {
            if (virtual) {
                var thread = Thread.startVirtualThread(runnable);
                threads.add(thread);
            } else {
                var thread = new Thread(runnable);
                thread.start();
                threads.add(thread);
            }
        }
        for (var thread : threads) {
            thread.join();
        }
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
