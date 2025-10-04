package TopicWiseProblems;

import java.util.*;

public class SlidingWindowProblems
{
    public static  void main(String a[])
    {
       // System.out.println(longestRepeatingCharacter("aabcdea"));

       // System.out.println(lengthOfLongestSubstring("aabcd"));

       // System.out.println(maximumUniqueSubarray(new int []{4,2,4,5,6}));

        System.out.println(longCharacterNonRepeating("aabcdea"));

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

    public static int maximumUniqueSubarray(int[] nums) {



        int start = 0, end = 0;
        int max = 0;
        int sum = 0;
        HashSet<Integer> h = new HashSet<>();

        while (end < nums.length) {
            if (!h.contains(nums[end])) {
                sum += nums[end];
                h.add(nums[end]);
                max = Math.max(max, sum);
                end++;
            } else {
                h.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
        }

        return max;
    }


       public static int longCharacterNonRepeating(String s)
       {
           HashSet<Character> h = new HashSet<>();
           char t[] = s.toCharArray();
           int max = Integer.MIN_VALUE;
           int left = 0;
           int right = 0;

           while(right < t.length)
           {
               if(!h.contains(t[right])) {
                   h.add(t[right]);
                   right++;
               }
               else {
                   max = Math.max(max,right - left);
                   h.remove(t[left]);
                   left++;


               }

       }


           return max;

       }



    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) result.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++; // add right char
            sCount[s.charAt(i - p.length()) - 'a']--; // remove left char

            if (Arrays.equals(pCount, sCount)) result.add(i - p.length() + 1);
        }

        return result;


    }


    public int countGoodSubstrings(String s) {
        int i=0, j=0, count=0;
        while(j<s.length()){
            if(j-i+1==3){
                if(s.charAt(i) != s.charAt(i+1) && s.charAt(i+1) != s.charAt(i+2)
                        && s.charAt(i+2) != s.charAt(i)){
                    count++;
                }
                i++;
            }
            j++;
        }
        return count;
    }

   // https://leetcode.com/problems/alternating-groups-i/description/?envType=problem-list-v2&envId=sliding-window

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int left = 0, count0 = 0, count1 = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '0') {
                count0++;
            } else {
                count1++;
            }

            // shrink window if both exceed k
            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }

            // all substrings ending at right and starting from [left..right]
            result += (right - left + 1);
        }

        return result;
    }

//    Example 1:
//
//    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//    Output: 6
//    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
    public int longestOnes(int[] nums, int k)
    {


        int left = 0, maxLength = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;



    }

    

}
