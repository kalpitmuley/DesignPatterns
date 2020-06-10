package ATS.Completed;

// { Driver Code Starts
import java.io.*;


class Kadane{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Kadane obj = new Kadane();

            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }

// } Driver Code Ends



    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n)
    {
        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;
        for(int i = 0; i < n; i++) {
            currMax = Math.max(arr[i], currMax+arr[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }

}


