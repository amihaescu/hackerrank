//package ro.amihaescu.java21;
//
//import java.util.ArrayList;
//import java.util.SequencedCollection;
//
//public class CollectionSamples {
//
//  public static void main(String[] args) {
//    SequencedCollection<String> strings = new ArrayList<>();
//    strings.add("b");
//    strings.add("c");
//    strings.add("a");
//
//    strings.addFirst("d");
//    strings.addLast("e");
//    for (String string : strings) {
//      System.out.println(string);
//    }
//    System.out.println("----");
//    SequencedCollection<String> reversed = strings.reversed();
//    for (String string : strings.reversed()) {
//      System.out.println(string);
//    }
//    System.out.println("----");
//    System.out.printf("get first: %s %n", reversed.getFirst());
//    System.out.printf("get last: %s %n", reversed.getLast());
//
//  }
//
//}
