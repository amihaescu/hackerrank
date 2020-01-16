package ro.amihaescu;

public class CommonChild {

    static String abbreviation(String a, String b) {
        int count = 0;
        int[][] mapping = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                char currentA = a.charAt(i);
                char currentB = b.charAt(j);
                if (currentA == currentB || currentA == currentB + 32) {
                    mapping[i][j] = 1;
                    count++;
                }
            }
        }
        printMatrix(mapping, a.length(), b.length());
        return count == b.length() ? "YES" : "NO";
    }

    static int commonChild(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int[][] ints = new int[s1Length + 1][s2Length + 1];
        for (int i = 1; i < s1Length + 1; i++) {
            for (int j = 1; j < s2Length + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ints[i][j] = ints[i - 1][j - 1] + 1;
                } else {
                    ints[i][j] = Math.max(ints[i - 1][j], ints[i][j - 1]);
                }
                if (ints[i][j] > max) {
                    max = ints[i][j];
                }
            }
        }
        System.out.println(sb.toString());
        printMatrix(ints, s1Length + 1, s2Length + 1);
        return max;
    }

    static void printMatrix(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(abbreviation("daBcd", "ABC"));
    }
}
