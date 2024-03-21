package ro.amihaescu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class SocotraTest {


  @Test
  void testPut() {
    Socotra.LRUCache cache = new Socotra.LRUCache(1);
    cache.put("key", "value");
    assertEquals("value", cache.get("key"));
  }

  @Test
  void testLru() {
    Socotra.LRUCache cache = new Socotra.LRUCache(3);
    cache.put("key", "value");
    cache.put("key2", "value2");
    cache.put("key3", "value2");

    cache.get("key");
    cache.put("key2", "value2");

    cache.put("key4", "value4");
    assertNull( cache.get("key3"));
    assertNotNull( cache.get("key2"));
    assertNotNull( cache.get("key"));
  }

}
