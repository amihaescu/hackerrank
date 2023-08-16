package ro.amihaescu;

/**
 * Write a Java program to create two threads, where one thread prints even numbers between 1 and 100, and the other thread prints odd numbers between 1 and 100.
 * The program should ensure that the threads execute in an interleaved manner,
 * printing the numbers in the correct order (1, 2, 3, 4, ...) without any number being skipped or repeated. The program should use a monitor to synchronize the threads.
 */
public class MultiThreadExample {

    private Object monitor;
    private Thread evenThread;


        public MultiThreadExample() {
            var monitor = new Object();
            var evenThread = new Thread(new EvenThread(monitor));
            var oddThread = new Thread(new OddThread(monitor));
            evenThread.start();
            oddThread.start();
        }

        public static void main(String[] args) {

        }

        static class EvenThread implements Runnable {

            private final Object monitor;

            public EvenThread(Object monitor) {
                this.monitor = monitor;
            }

            @Override
            public void run() {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                synchronized (monitor) {
                    for (int i = 2; i <= 100; i += 2) {
                        System.out.println(i);
                        monitor.notify();
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        static class OddThread implements Runnable {

            private final Object monitor;

            public OddThread(Object monitor) {
                this.monitor = monitor;
            }

            @Override
            public void run() {
                synchronized (monitor) {
                    for (int i = 1; i <= 100; i += 2) {
                        System.out.println(i);
                        monitor.notify();
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
}
