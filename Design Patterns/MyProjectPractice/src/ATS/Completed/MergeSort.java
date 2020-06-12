package ATS.Completed;

// { Driver Code Starts

import java.util.Scanner;

class MergeSort {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            MergeSort ms = new MergeSort();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            mergeSort(arr, 0, arr.length - 1);

            ms.printArray(arr);
            T--;
        }
    }
// } Driver Code Ends


    /* The task is to complete merge() which is used
    in below mergeSort() */
    // Merges two subarrays of arr[].  First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int left, int mid, int right) {
        int l = left, r = right;
        int m = mid;
        int lsize = mid + 1 - left;
        int rSize = right - mid;
        int[] lArr = new int[lsize];
        int[] rArr = new int[rSize];

        for (int i = 0; i < lsize; ++i)
            lArr[i] = arr[l + i];
        for (int j = 0; j < rSize; ++j)
            rArr[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < lsize && j < rSize) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while (i < lsize) {
            arr[k] = lArr[i];
            k++;
            i++;

        }
        while (j < rSize) {
            arr[k] = rArr[j];
            k++;
            j++;
        }
    }
}