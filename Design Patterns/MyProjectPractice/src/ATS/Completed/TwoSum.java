package ATS.Completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] nx = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nx[0]);
            int x = Integer.parseInt(nx[1]);
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);

            if (keypair(a, n, x))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    // A[] : the input array of positive integers
    // N : size of the array arr[]
    // X : the required sum
    public static boolean keypair(int[] A, int N, int X) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (hs.contains(X - A[i])) return true;
            else hs.add(A[i]);
        }
        return false;
    }
}