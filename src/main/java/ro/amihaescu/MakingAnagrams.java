package ro.amihaescu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> freqA = frequency(a);
        Map<Character, Integer> freqB = frequency(b);
        Set<Character> totalChars = new HashSet<>();
        totalChars.addAll(freqA.keySet());
        totalChars.addAll(freqB.keySet());
        int sum = 0;
        for (Character character : totalChars) {
            sum += Math.abs(freqA.getOrDefault(character,0) - freqB.getOrDefault(character, 0));
        }
        return sum;
    }

    private static Map<Character, Integer> frequency(String a) {
        Map<Character, Integer> characterCounter = new HashMap();
        for (char c : a.toCharArray())
           characterCounter.put(c, characterCounter.getOrDefault(c , 0) + 1);
        return characterCounter;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }

}
