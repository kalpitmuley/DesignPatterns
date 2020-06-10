package ATS;
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
        import java.io.*;
        import java.lang.*;

class DriverClass
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            RotateMatrixBy90 g = new RotateMatrixBy90();
            g.rotate(arr);
            printMatrix (arr);
        }
    }

    public static void printMatrix(int arr[][])
    {
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
        DriverClass dc = new DriverClass();
        reverse(matrix);
        dc.printMatrix(matrix);
        transpose(matrix);
    }

    static void reverse(int arr[][]) {
        int n = arr[1].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[n-(j+1)][i];
                arr[n-(j+1)][i] = temp;
            }
        }
    }
    static void transpose(int arr[][]) {
        int n = arr[1].length;
        System.out.println(n);
        System.out.println(arr.length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
