package ATS.Completed;

// { Driver Code Starts
//Initial Template for Java

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Majority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(majorityElement(arr, n));
        }
    }

    static int majorityElement(int[] a, int size) {
        if (size == 0) return -1;
        if (size == 1) return a[0];

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (hm.containsKey(a[i])) {
                hm.put(a[i], hm.get(a[i]) + 1);
            } else {
                hm.put(a[i], 1);
            }
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > size / 2)
                result = entry.getKey();
        }

        return result;
    }
}