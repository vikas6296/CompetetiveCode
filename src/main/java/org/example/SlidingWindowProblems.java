package org.example;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowProblems
{
    public static  void main(String a[])
    {
       // System.out.println(longestRepeatingCharacter("aabcdea"));

        System.out.println(lengthOfLongestSubstring("aabcd"));

    }
    public static int longestRepeatingCharacter(String a)
    {
        int start = 0 ;
        int end = 0 ;
        int max = 0;
        HashMap<Character,Integer> m = new HashMap<>();
        char t[] = a.toCharArray();


        while(end < t.length )
        {
            char y = a.charAt(end);
            m.put(y,m.getOrDefault(y,0) + 1);


            if(m.size() < end - start + 1)
            {
                while(m.size() < end - start + 1)
                {
                    int val = m.get(t[start]);
                    val = val - 1;
                    m.put(t[start],val);

                    if(m.get(t[start]) == 0)
                        m.remove(t[start]);

                    start++;
                }
                end++;
            }

            if(m.size() == end - start + 1)
            {
                max = Math.max(max,end - start + 1);
                end++;
            }



        }


return max;

    }








    public static int lengthOfLongestSubstring(String s) {

        HashMap<StringBuilder, Integer> forRecored = new HashMap<StringBuilder, Integer>();


        int max = 0;
        HashMap<Character, Integer> gd = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char c[] = s.toCharArray();

            if (gd.containsKey(c[i]) == false) {

                gd.put(c[i], 1);
                System.out.println("not conatins-->" + c[i]);
                sb.append(c[i]);
                System.out.println("value of sb --->" + sb);
                System.out.println("length of sb--->" + sb.length());

                if (i == s.length() - 1) {
                    forRecored.put(sb, sb.length());

                }
            } else {
                forRecored.put(sb, sb.length());


                System.out.println("value of for record hashmap -->" + forRecored);
                gd.clear();
                System.out.println("clearing of hashmp");
                sb.delete(0, sb.length());


            }
        }
        System.out.println("value of max-->" + max);
        System.out.println("value of hashmap --> " + forRecored);

        for (Map.Entry<StringBuilder, Integer> entry : forRecored.entrySet()) {
            System.out.println("key = " + entry.getKey() + " " + "entry = " + entry.getValue());
            max = Math.max(max, entry.getValue());
        }
        for (Map.Entry<StringBuilder, Integer> entry : forRecored.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("value of longest substring --> " + entry.getKey());
                return max;
            }
        }
        System.out.println("value of max-->" + max);
        return max;
    }

    public static int longestSubarray2(int[] a) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < a.length; right++) {
            freq.put(a[right], freq.getOrDefault(a[right], 0) + 1);

            // shrink window if more than 2 distinct elements
            while (freq.size() > 2) {
                freq.put(a[left], freq.get(a[left]) - 1);
                if (freq.get(a[left]) == 0) {
                    freq.remove(a[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
