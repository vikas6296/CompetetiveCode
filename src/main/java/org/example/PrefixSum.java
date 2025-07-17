package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSum
{
    public static void main (String []a)
    {
        System.out.println(subsequence(new int []{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14},22));

    }
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0, -1); // base case

        int maxLength = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (prefixSumToIndex.containsKey(currentSum - k)) {
                int prevIndex = prefixSumToIndex.get(currentSum - k);
                int length = i - prevIndex;
                maxLength = Math.max(maxLength, length);
            }

            // Only store first occurrence to get the longest length
            if (!prefixSumToIndex.containsKey(currentSum)) {
                prefixSumToIndex.put(currentSum, i);
            }
        }

        return maxLength;
    }



    public static int subsequence(int []nums, int target)
    {
        Arrays.sort(nums);
        int powNumber []= new int [nums.length];

        for(int i = 0 ; i < nums.length ; i++)
        {
            powNumber[i] = (int)Math.pow(2,i);
        }

        int start = 0 ;
        int end = nums.length - 1;
        int  result = 0;

        while(start <= end)
        {
            if( nums[start] + nums[end] <= target)
            {
                result = (int )result + powNumber[end - start];
                start++;
            }

            else
            {
                end--;
            }

        }

return (int)result;

    }

}
