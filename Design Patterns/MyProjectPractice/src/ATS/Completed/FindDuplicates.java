package ATS.Completed;


// { Driver Code Starts
import java.util.*;

class FindDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            ArrayList<Integer> ans = duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
// } Driver Code Ends


    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i]%n] += n;
        }
        for(int i = 0; i<arr.length; i++) {

            if(arr[i]/n > 1) {
                al.add(i);
            }
        }
        if (al.isEmpty()) al.add(-1);
        // Collections.sort(al);
        return al;
    }
}


