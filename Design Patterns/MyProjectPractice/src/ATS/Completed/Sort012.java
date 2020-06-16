package ATS.Completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            new Sort012().segragate012(arr, n);
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr[i] + " ");
            }
            System.out.println(str);
        }
    }
    // The function should do the stated modifications in the given array arr[]
    // Do not return anything.

    // arr[]: Input Array
    // N: Size of the Array arr[]

    public static void segragate012(int arr[], int N) {

        long zeros = 0;
        long ones = 0;
        long twos = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) zeros++;
            if (arr[i] == 1) ones++;
            if (arr[i] == 2) twos++;
        }
        int i = 0;
        while (zeros > 0) {
            arr[i] = 0;
            zeros--;
            i++;
        }
        while (ones > 0) {
            arr[i] = 1;
            ones--;
            i++;
        }
        while (twos > 0) {
            arr[i] = 2;
            twos--;
            i++;
        }
    }
}