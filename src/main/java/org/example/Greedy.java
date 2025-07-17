package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//    plaintext
//    Copy code
//    Input: [[1,3], [2,6], [8,10], [15,18]]
//    Output: [[1,6], [8,10], [15,18]]
public class Greedy
{
    int start ;
    int end;
    public Greedy(int start, int end)
    {
        this.start = start;
        this.end = end;

    }
    public static void main(String a[])
    {
//        Greedy b[] = new Greedy[3];
//        b[1] = new Greedy(15,20);
//        b[0] = new Greedy(5,10);
//        b[2] = new Greedy(0,30);


//[[0,30],[5,10],[15,20]] [7,10],[2,4]

//       Interval c []=  checkMergeInterval(b);
////       for(Interval d: c)
////       {
////           System.out.println(d.start + " "+ d.end);
////       }

       // numSubarrayProductLessThanK(new int []{1,2,3},00);

        //System.out.println(checkMinimumRooms(b));

        System.out.println(insert(new int [][]{{1,3},{6,9}},new int []{2,5}));
       // System.out.println(largestNumber(new int []{3,30,34,5,9}));

   }

//    public static Interval[] checkMergeInterval(Interval a[])
//    {
//        Arrays.sort(a, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        int index = 0;
//
//        for(int i = 1 ; i < a.length ; i++)
//        {
//            if(a[index].end >= a[i].start)
//            {
//                a[index].end = Math.max(a[i].end,a[index].end);
//            }
//            else
//            {
//                index++;
//                a[index] = a[i];
//            }
//
//
//        }
//
//        for(int j = 0 ; j <= index ; j++)
//        {
//            System.out.println(a[j].start + " "+ a[j].end  );
//        }
//
//
//        return a;
//    }
//    Input: nums = [10,5,2,6], k = 100
//    Output: 8
//    Explanation: The 8 subarrays that have product less than 100 are:
//        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6] J G S G
    public static int numSubarrayProductLessThanK(int[] nums, int k)
    {
        int start ;
        int count = 0 ;
        int product = 1;

        for(int i = 0 ; i < nums.length ;i++)
        {
            start = i;
            while( start < nums.length && product < k )
            {
                product = product * nums[start];
                if(product < k) {
                    count = count + 1;
                }
                start++;

            }

            product = 1;

        }

        return count;
    }




    //    Input: intervals = [[0,30],[5,10],[15,20]]
//    Output: 2
    public static int checkMinimumRooms(Greedy a[])
    {
        Arrays.sort(a, new Comparator<Greedy>() {
            @Override
            public int compare(Greedy o1, Greedy o2) {
                return o1.start - o2.start;
            }
        });

        int index = 0 ;
        int rooms = 1;

        for(int i = 1 ; i < a.length ; i++)
        {
            if(a[index].end >= a[i].start)
            {
                rooms = rooms + 1;
                index++;
            }


        }

        return rooms;

    }



    // finding the largest number using greedy aproach

    public static String largestNumber(int[] nums)
    {
        String convert[] = new String [nums.length];

        for(int i = 0 ; i < nums.length ; i++)
        {
            convert[i] = String.valueOf(nums[i]);

        }

        Arrays.sort(convert , (a,b) -> (b + a ) .compareTo(a + b));

        if(convert[0] == "0")
            return "0";

        StringBuilder sb = new StringBuilder();

        for(String s : convert)
        {
            sb.append(s);
        }

return sb.toString();

    }


    public static boolean canJump(int []a)
    {
        int reachable = 0 ;

        for(int i = 0 ; i < a.length ; i++)
        {
            if(i > reachable)
                return false;

            reachable = Math.max(reachable,i + a[i]);

        }
        return true;
    }



//    Example 1:
//
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]
//    Example 2:
//
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged newInterval
        result.add(newInterval);

        // Add remaining intervals after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert result list to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int g : gas){
            totalGas += g;
        }

        for(int c : cost){
            totalCost += c;
        }
        if(totalCost > totalGas){
            return -1;
        }

        int idx = 0;
        int currentGas = 0;
        for(int i=0; i<gas.length; i++){
            currentGas += gas[i] - cost[i];
            if(currentGas < 0){
                currentGas = 0;
                idx = i+1;
            }
        }

        return idx;

    }


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            for(int j=nums.length-1; j>i; j--){
                if(nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }

        int start = i + 1;
        int end = nums.length - 1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
