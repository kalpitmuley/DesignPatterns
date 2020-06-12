package ATS.Completed;

// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RotateArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] starr = str.split(" ");
            int n = Integer.parseInt(starr[0]);
            int d = Integer.parseInt(starr[1]);
            int[] arr = new int[n];
            String str1 = br.readLine();
            String[] starr1 = str1.split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(starr1[j]);
            }
            new RotateArray().rotateArr(arr, d, n);
            StringBuffer sb = new StringBuffer();
            for (int t1 = 0; t1 < n; t1++)
                sb.append(arr[t1] + " ");
            System.out.println(sb);
        }
    }
// } Driver Code Ends
//User function Template for Java


    static void rotateArr(int arr[], int d, int n) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    static void reverse(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}