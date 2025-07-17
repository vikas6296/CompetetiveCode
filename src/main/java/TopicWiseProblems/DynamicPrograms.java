package org.example;

import java.util.ArrayList;
import java.util.List;

public class DynamicPrograms
{
    public static void main(String a[])
    {

        System.out.println(countSubstrings("aaa"));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int one = 0;
            int zero = 0;
            for(char c : str.toCharArray()){
                if(c == '1')
                    one++;
                else
                    zero++;
            }
            for(int i = m; i >= zero; i--){
                for(int j = n; j >= one; j--){
                    if(one <= j && zero <= i)
                        dp[i][j] = Math.max(dp[i][j],dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }


//    Input: s = "abc"
//    Output: 3
//    Explanation: Three palindromic strings: "a", "b", "c".
//    Example 2:
//
//    Input: s = "aaa"
//    Output: 6
//    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

//    public static int countSubstrings(String s)
//    {
//        List<Integer> result = new ArrayList<>();
//        palindromic(new StringBuilder(s),0,result);
//
//    }

//    public static void palindromic(StringBuilder sb, int start ,  List<Integer> result)
//    {
//
//        for(int i = start ; i < sb.length() ; i++)
//        {
//            String check = sb.substring(start , i + 1);
//            if(palidnromicCheck(check))
//            {
//                sb.append()
//
//            }
//
//
//        }
//
//    }

    public static void swap(StringBuilder sb , int start , int end)
    {

        char temp = sb.charAt(start);
        sb.setCharAt(start,sb.charAt(end));
        sb.setCharAt(end,temp);

    }

    public static boolean palidnromicCheck(String s)
    {
        int start = 0 ;
        int end = s.length() - 1;
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end++))
                return false;
        }

        return true;
    }

    private static  int count = 0;
    public static int countSubstrings(String s)
    {
        if(s.length() < 2)
            return s.length();


       // String maxString = s.substring(0,1);

        for(int i = 0 ; i < s.length()   ; i++)
        {
            expandFromCenter(s,i , i);
            expandFromCenter(s,i,i + 1 );

        }

        return count;
    }

    public static void expandFromCenter(String c , int start , int end )
    {
        while(start >= 0 &&  end < c.length() && c.charAt(start) == c.charAt(end))
        {
            start--;
            end++;
            count++;
        }

    }

}
