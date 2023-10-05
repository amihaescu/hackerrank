package ro.amihaescu;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int index = 0;
        int noDeletions = 0;
        Character character = s.charAt(index);
        while (++index < s.length()) {
            Character itterator = s.charAt(index);
            if (itterator == character) {
                noDeletions++;
            } else {
                character = itterator;
            }
        }
        return noDeletions;
    }

    public static void main(String[] args) {
        System.out.println(new StringBuilder().toString().contains("abc"));
        System.out.println(alternatingCharacters("AAABBB")
        );
    }


}
