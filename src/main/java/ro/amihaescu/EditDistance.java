package ro.amihaescu;

public class EditDistance {

    boolean oneEditApart(String s1, String s2) {
        if (Math.abs(s2.length() - s1.length()) > 1) return false;
        if (s2.length() > s1.length()) {
            String aux = s2;
            s2 = s1;
            s1 = aux;
        }

        boolean difference = false;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (difference) return false;
                difference = true;
                if (s1.length() > s2.length())
                    j--;
            }
        }
        return true;
    }
}
