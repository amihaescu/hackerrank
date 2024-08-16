package ro.amihaescu;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/***
 * Implement a LRU (Least Recently Used) Cache.
 *
 * There's 2 operations to implement:
 *
 * put(key, item)
 * get(item)
 */
public class Socotra {

  /**
   * put(5)
   *
   * [1,2,3,4,5]
   * get -> element is refreshed -> element moved to front
   * 3 -> [3,1,2,4,5]
   * 4 -> [4,3,1,2,5]
   * put(6) -> [6,4,3,1,2]
   */

  static class LRUCache {

    private final Map<String, String> map = new HashMap<>();
    private final Deque<String> queue = new LinkedList<>();

    private final Integer capacity;

    public LRUCache(Integer capacity) {
      this.capacity = capacity;
    }

    void put(String key, String value) {
      if (map.size() == capacity) {
        // remove the least recently used
        String remove = queue.removeLast();
        map.remove(remove);
      }
      map.put(key, value);
      queue.addFirst(key);
    }

    String get(String key) {
      String s = map.get(key);
      queue.remove(key);
      queue.addFirst(key);
      return s;
    }

  }
}
