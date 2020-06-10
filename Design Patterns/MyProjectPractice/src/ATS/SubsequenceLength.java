package ATS;

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class SubsequenceLength {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();

            System.out.println(SubsequenceLength(s));

            t--;
        }
    }




// } Driver Code Ends


//User function Template for Java



    static int SubsequenceLength(String s)
    {
        int max = 0;
        int currMax = 0;
        HashMap<Character, Boolean> isPresent = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(!isPresent.containsKey(s.charAt(i))) {
                currMax++;
                isPresent.put(s.charAt(i),true);
            }
            else {
                max = Math.max(currMax, max);
                currMax--;
//                isPresent.remove(s.charAt(i));
            }
        }
        max = Math.max(currMax, max);
        return max;
    }

}
// abcdefaghijklmnop - 16
// 1
//abcdbfgalk - 8
//https://jobs.amdocs.com/job/0-Software-Engineer-%28C%2B%2B-Development-&-Support%29-MH/624113100/

//2
//geeksforgeeks
//abbcdb