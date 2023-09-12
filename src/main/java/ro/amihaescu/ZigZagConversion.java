package ro.amihaescu;

public class ZigZagConversion {

    // P A Y P A L I S H I R I N G
    // 0 1 2 3 4 5 6 7 8 9 10111213

    // P I N A L S I G Y A H R P I
    // 0 6 12 1 5 7 11 13 2 4 8 10 3 9 -> numRow + 2 * (numRow - 2)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            int n = s.length();
            int diff = 2 * (numRows - 1);
            int secondIndex;
            var stringBuilder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                int index = i;
                while (index < n) {
                    stringBuilder.append(s.charAt(index));
                    if (i != 0 && i != numRows - 1) {
                        secondIndex = index + diff - 2 * i;
                        if (secondIndex < n) {
                            stringBuilder.append(s.charAt(secondIndex));
                        }
                    }
                    index += diff;
                }
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        Solution solution = zigZagConversion.new Solution();
//        System.out.println(solution.convert("PAYPALISHIRING", 3));
        String result = solution.convert("PAYPALISHIRING", 4);
        System.out.println(result);
        if (result.equals("PINALSIGYAHRPI")) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }

    // PINALIGYAIHRNPI
    // PINALSIGYAHRPI

}
