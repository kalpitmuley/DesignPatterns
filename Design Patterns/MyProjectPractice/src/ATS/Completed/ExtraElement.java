package ATS.Completed;

import java.util.Scanner;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            System.out.println(findExtra(a, b, n));
        }
    }

    public static int findExtra(int[] a, int[] b, int n) {

        if (a[0] != b[0]) return 0;

        int l = 0, r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (m == n - 1 && a[m - 1] == b[m - 1]) return m;
            if ((m == n - 2 || m == n - 1) && a[m] == b[m]) return m + 1;
            if (a[m] == b[m] && a[m + 1] != b[m + 1])
                return m + 1;

            if (a[m] == b[m])
                l = m + 1;

            else
                r = m - 1;
        }
        return -1;
    }
}