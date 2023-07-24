package ro.amihaescu.jenkov;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<String>(3);
        Producer producer = new Producer(blockingDeque);
        Consumer consumer = new Consumer(blockingDeque);
        Consumer consumer1 = new Consumer(blockingDeque);

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer1);
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

    }

    private static class Producer implements Runnable {
        private final BlockingQueue<String> blockingDeque;
        public Producer(BlockingQueue<String> blockingDeque) {
            this.blockingDeque = blockingDeque;
        }

        @Override
        public void run() {
            while(true) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    this.blockingDeque.put("Element " + currentTimeMillis);
                } catch (InterruptedException e) {
                    System.out.println("Producer was interrupted");
                }
                sleep(1000);
            }
        }

        private void sleep(int i) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
    }

    private static class Consumer implements Runnable {

        private final BlockingQueue<String> blockingDeque;
        public Consumer(BlockingQueue<String> blockingDeque) {
            this.blockingDeque = blockingDeque;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String take = this.blockingDeque.take();
                    System.out.println("Consumer " + Thread.currentThread().getName() + " took " + take);
                } catch (InterruptedException e) {
                    System.out.println("Consumer was interrupted");
                }
            }
            
        }
    }
}
