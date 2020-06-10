package ATS.Completed;

// { Driver Code Starts

import java.util.*;
import java.util.Scanner;

class RemoveDuplicates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
//            RemoveDuplicates g = new RemoveDuplicates();
            ArrayList<Integer> result = new ArrayList<Integer>();
            result = removeDuplicate(arr, n);

            for (int i = 0; i < result.size(); i++)
                System.out.print(result.get(i) + " ");
            System.out.println();
            t--;
        }
    }


// } Driver Code Ends


    static ArrayList<Integer> removeDuplicate(int[] arr, int n) {
        HashMap<Integer, Integer> result = new HashMap<>();
        ArrayList<Integer> resultArr = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if(!result.containsValue(arr[i]))
            result.put(c++, arr[i]);
        }
        for (Integer i : result.values())
            resultArr.add(i);
        return resultArr;
    }
}

