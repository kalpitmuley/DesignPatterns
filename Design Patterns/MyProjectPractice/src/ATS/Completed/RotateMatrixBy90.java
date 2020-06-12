package ATS.Completed;
// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            RotateMatrixBy90 g = new RotateMatrixBy90();
            g.rotate(arr);
            printMatrix(arr);
        }
    }

    public static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}// } Driver Code Ends


//User function Template for Java

public class RotateMatrixBy90 {
    static void rotate(int matrix[][]) {
        reverse(matrix);
        transpose(matrix);
    }

    static void reverse(int arr[][]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - (j + 1)];
                arr[i][n - (j + 1)] = temp;
            }
        }
    }

    static void transpose(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }
}
