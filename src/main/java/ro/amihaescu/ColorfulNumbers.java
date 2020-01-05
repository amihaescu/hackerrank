package ro.amihaescu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ColorfulNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] digits = extractDigits(line);
        System.out.println("Output: " + (checkSums(digits) ? "Colorful" : "Not Colorful"));
    }

    private static boolean checkSums(int[] digits) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int digit : digits) {
            if (hashSet.contains(digit)) {
                return false;
            }
            Set<Integer> products = new HashSet<>();
            for (Integer integer : hashSet) {
                Integer product = integer * digit;
                if (hashSet.contains(product)) {
                    return false;
                } else {
                    products.add(product);
                }
            }
            hashSet.addAll(products);
            hashSet.add(digit);
        }
        return true;
    }

    private static int[] extractDigits(String line) {
        int[] digits = new int[line.length()];
        for (int index = 0; index < line.length(); index++) {
            digits[index] = Integer.parseInt(String.valueOf(line.charAt(index)));
        }
        return digits;
    }
}
