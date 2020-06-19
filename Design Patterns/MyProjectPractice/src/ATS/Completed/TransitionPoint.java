package ATS.Completed;

import java.util.Scanner;

public class TransitionPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(transitionPoint(arr, n));
            T--;
        }
    }

    static int transitionPoint(int[] arr, int n) {
        if (n == 1) {
            if (arr[0] == 0) return -1;
            else return 0;
        }
        return binarySearch(arr, 0, n - 1);
    }

    static int binarySearch(int[] arr, int start, int end) {
        int mid = start + ((end - start) / 2);
        if (start != 0 && mid + 1 > end) return -1;
        if (arr[mid] != 0 && mid - 1 < 0) return 0;
        if (arr[mid] == 1 && arr[mid - 1] == 0) {
            return mid;
        } else if (arr[mid] == 0 && arr[mid + 1] == 1) {
            return mid + 1;
        }

        if (arr[mid] == 1)
            return binarySearch(arr, start, mid);
        else
            return binarySearch(arr, mid + 1, end);
    }
}