package ro.amihaescu;

public class InsertionSort2 {

    static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            for (int print = 0; print < n; ++print)
                System.out.print(arr[print] + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        insertionSort2(6, new int[]{1, 4, 3, 5, 6, 2});
    }
}
