package ATS.Completed;

// { Driver Code Starts

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class LargestSubarray01 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            int n = maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array

    // return the maximum length of the subarray
    // with equal 0s and 1s
    static int maxLen(int[] arr, int N) {
        // Your code here
        Stack<Integer> zeros = new Stack<>();
        Stack<Integer> ones = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        return maxLenZeroSum(arr, N);
    }

    static int maxLenZeroSum(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }
            if (sum == 0) {
                maxLen = i + 1;
            }
            Integer prevInd = map.get(sum);
            if (prevInd != null) {
                maxLen = Math.max(maxLen, i - prevInd);
            } else map.put(sum, i);
        }
        return maxLen;
    }
}
