package ro.amihaescu;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    static String isValid(String s) {
        if (s.length() == 1) {
            return "YES";
        }
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character character : s.toCharArray()) {
            frequency.computeIfPresent(character, (key, value) -> value +1);
            frequency.putIfAbsent(character, 1);
        }
        Map<Integer, Integer> occurences = new HashMap<>();
        for (Integer character : frequency.values()) {
            occurences.computeIfPresent(character, (key, value) -> value +1);
            occurences.putIfAbsent(character, 1);
        }
        if (occurences.size() == 2 && occurences.containsValue(1))  {
            Integer[] keys = occurences.keySet().toArray(new Integer[2]);
            if (Math.abs(keys[0] - keys[1]) == 1){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(isValid("abbac"));
    }
}
