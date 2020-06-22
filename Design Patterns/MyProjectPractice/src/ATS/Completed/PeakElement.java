package ATS.Completed;

import java.util.Scanner;

class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int A = peakElement(a, n);
            int f = 0;
            if (n == 1)
                f = 1;
            else if (A == 0 && a[0] >= a[1])
                f = 1;
            else if (A == n - 1 && a[n - 1] >= a[n - 2])
                f = 1;
            else if (a[A] >= a[A + 1] && a[A] >= a[A - 1])
                f = 1;
            else
                f = 0;
            System.out.println(f);
        }
    }

    public static int peakElement(int[] a, int n) {
        if (n < 1) return 1;
        if (n == 1) return a[0];
        if (a[0] > a[1]) return 0;
        if (a[n - 1] > a[n - 2]) return n - 1;
        return binarySearch(a, 0, n - 1, n - 1);
    }

    static int binarySearch(int[] arr, int l, int r, int n) {

        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (mid == n) return 1;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;

            if (arr[mid] > arr[mid - 1])
                return binarySearch(arr, l, mid - 1, n);

            return binarySearch(arr, mid + 1, r, n);
        }
        return 1;
    }
}



