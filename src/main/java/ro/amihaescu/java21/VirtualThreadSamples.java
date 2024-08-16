//package ro.amihaescu.java21;
//
//import java.time.Instant;
//import java.util.Date;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//import java.util.stream.IntStream;
//
//public class VirtualThreadSamples {
//
//  public static void main(String[] args) {
//    try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
//      IntStream.range(1, 1000).forEach(value -> executor.submit(new VirtualThreadWorker(value)));
//    }
//  }
//
//  static class VirtualThreadWorker implements Runnable {
//
//    private final int value;
//
//    public VirtualThreadWorker(int value) {
//      this.value = value;
//    }
//
//    @Override
//    public void run() {
//      while (true) {
//        System.out.printf("Thread: %s %s %n", value, Date.from(Instant.now()));
//        try {
//          Thread.sleep(1_000);
//        } catch (InterruptedException e) {
//          throw new RuntimeException(e);
//        }
//      }
//
//    }
//  }
//
//}
