package ro.amihaescu;

import java.util.Scanner;

public class Quicksort {

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot );
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = low;
        for (int i = low + 1; i < high ; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, pivot);
                swap(arr, i, pivot + 1);
                pivot++;
            }
        }
        return pivot;
    }

    static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    static void printArray(int[] arr, int low, int high) {
        for (int i = low; i < high; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, arr.length);
        printArray(arr, 0, arr.length);

    }
}
