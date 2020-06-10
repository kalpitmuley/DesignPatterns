package ATS;

// { Driver Code Starts

import java.io.*;
import java.lang.*;


class TrappedWater {

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
            System.out.println(trappingWater(arr, n));
        }
    }
// } Driver Code Ends


    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) {
//        int secondMax = largestAndSecondLargest(n, arr);
        int max = 0;
        int second = arr[0];
        int trappedWater = 0;
        int temporaryTrapped = 0;
        boolean maxDone = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[max] && !(arr[i] > second)) {
                second = arr[i];
                temporaryTrapped += (arr[max] - arr[i]);
            }
            else if (arr[i] > second) {
                second = arr[i];
                trappedWater += temporaryTrapped;
                temporaryTrapped = 0;
            }
            else {
                max = i;
                second = Integer.MAX_VALUE;
                trappedWater += temporaryTrapped;
                temporaryTrapped = 0;
            }
        }
        if (second == 0 || second < arr[max]) {
            temporaryTrapped += ((n-1) - max) * (second - arr[max]);
        }
        trappedWater += temporaryTrapped;
        return trappedWater;
    }

    // Function to find largest and second largest element in the array
    static int largestAndSecondLargest(int sizeOfArray, int arr[]) {

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < sizeOfArray; i++) {
            if (arr[i] > max) {
                max2 = max == max2 ? max2 : max;
                max = arr[i];
            } else if (arr[i] > max2 && arr[i] != max) max2 = arr[i];
            else if (max2 == Integer.MIN_VALUE) max2 = -1;
        }
        return max2;
    }
}

/*Input:
1
7
8 8 2 4 5 5 1

Its Correct output is:
4

And Your Code's output is:
8*/
