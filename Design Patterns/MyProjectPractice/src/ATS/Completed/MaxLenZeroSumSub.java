package ATS.Completed;

import java.util.HashMap;
import java.util.Scanner;

class MaxLenZeroSumSub {

    /*
     Input:
     1
     8
     15 -2 2 -8 1 7 10 23
     */

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(maxLen(arr, n));
            T--;
        }
    }

    /**
     *
     * @param arr
     * @param n
     * @return
     */
    public static int maxLen(int arr[], int n) {
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
