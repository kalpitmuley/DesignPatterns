package ATS;

import java.io.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'changedSort' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String changedSort(String s) {
        // Write your code here
        String ss = new String();
        String tempStr;

        char tempChar = smallestAlphabet(s, '0');
        ss = ss+String.valueOf(tempChar);
        int i = s.length();
        tempStr = s.substring(1);
        int j = 1;

        while(j < i-2) {
            while(true) {
                if(greatestAlphabet(ss, '0') == '0' || tempStr.length() == 1) break;
                ss = ss+String.valueOf(tempChar);
                tempStr = tempStr.substring(1);
                tempChar = smallestAlphabet(tempStr, tempChar);
                j++;
            }
            tempChar = greatestAlphabet(tempStr, '0');
            while(true) {
                if(smallestAlphabet(ss, '0') == '0'|| tempStr.length() == 1) break;
                ss = ss+String.valueOf(tempChar);
                tempStr = tempStr.substring(1);
                tempChar = greatestAlphabet(tempStr, tempChar);
                j++;
            }
        }

        return ss;

    }

    private static char smallestAlphabet(String str, char r) {
        char min = r == '0' ? 'z' : r;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) > min) {
                min = str.charAt(i);
            }
        }
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) < min) {
                min = str.charAt(i);
            }
        }
        return min;
    }
    private static char greatestAlphabet(String str, char r) {
        char max = r == '0' ? 'a' : r;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) < max) {
                max = str.charAt(i);
            }
        }
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > max) {
                max = str.charAt(i);
            }
        }
        return max;
    }
}

class Solution1 {
    public static void main(String[] args) throws IOException {

        String s = "babcbb";

        String result = Result.changedSort(s);
        System.out.println(result);
    }
}