package ATS.Completed;


import java.util.Scanner;

public class SearchRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            System.out.println(Search(array, target));
            t--;
        }
    }

    static int Search(int[] array, int target) {
        int result = -1;
        int pivot = findTransition(array, 0, array.length - 1);
        if (pivot == -1) pivot = array.length - 1;
        if (array[pivot] == target) result = pivot;
        if (result == -1) result = binarySearch(array, 0, pivot, target);
        if (result == -1) result = binarySearch(array, pivot + 1, array.length - 1, target);
        return result;
    }

    static int findTransition(int[] arr, int left, int right) {
        int pivot = -1;
        if (right > left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) return mid;
            pivot = findTransition(arr, left, mid);
            if (pivot == -1) pivot = findTransition(arr, mid + 1, right);
        }
        return pivot;
    }

    static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}

