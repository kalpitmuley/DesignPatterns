package ATS.Completed;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FloorSearch {

    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String a[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            long x = Long.parseLong(a[(int) 1]);
            String st[] = read.readLine().trim().split("\\s+");

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st[i]);
            }

            System.out.println(new FloorSearch().findFloor(arr, 0, n - 1, x));

        }
    }

    // Function to find floor of x
    // arr: input array
    // left and right as 0 and n-1, where n is the size of array
    static int findFloor(long arr[], int left, int right, long x) {
        if (arr[left] > x) return -1;
        if (arr[right] <= x) return right;
        int mid = left + (right - left) / 2;
        if (arr[mid] == x || arr[mid] < x && arr[mid + 1] > x) return mid;

        if (arr[mid] < x) return findFloor(arr, mid + 1, right, x);
        else if (arr[mid] >= x) return findFloor(arr, left, mid, x);
        else return -1;
    }
}
