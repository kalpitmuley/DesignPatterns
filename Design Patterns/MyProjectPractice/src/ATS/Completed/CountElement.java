package ATS.Completed;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CountElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new CountElement().countOccurence(arr, n, k));
        }
    }

    // Function to find element with count more than n/k times
    // arr: input array
    public int countOccurence(int[] arr, int n, int k) {
        int result = 0;
        int divisor = n / k;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            } else {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > divisor) result++;
        }
        return result;
    }
}
