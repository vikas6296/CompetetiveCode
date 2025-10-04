package TopicWiseProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch
{
    public static void main(String [] s)
    {

        //System.out.println(binarySearch(new int []{1,2,3,4,5,6,7,8},6));

        System.out.println(search(new int []{1},0));
    }
    public static int binarySearch(int []nums, int k)
    {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            int mid = ( start + end ) / 2 ;

            if(nums[mid] == k)
                return mid;

            else if (nums[mid] < k)
            {
                start = mid + 1;
            }

            else
                end = mid - 1;


        }

return start;
    }

    public int binarySearch(List<Integer> list, int target)
    {
        int l=0, r=list.size()-1;

        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(list.get(mid)==target)
            {
                return list.get(mid);
            }
            else if(list.get(mid)<target)
            {
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(l>list.size()-1) return list.get(list.size()-1);
        if(r<0) return list.get(0);
        return Math.abs(list.get(r)-target)<=Math.abs(list.get(l)-target) ? list.get(r) : list.get(l);
    }
    public int[] shortestToChar(String s, char c) {
        int n=s.length();
        int[] res=new int[n];
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++)    if(s.charAt(i)==c)  l.add(i);
        for(int i=0;i<n;i++)    res[i]=Math.abs(i-binarySearch(l, i));
        return res;
    }

    public static int gcd( int a , int b )
    {

        return   b == 0 ? a : gcd(a , b);

    }


//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4

    public static  int search(int[] nums, int target)
    {
        int output = -1 ;
        for(int i = 0 ; i < nums.length ; i++)
        {
             if(target == nums[i])
                 output = i;
        }

        Arrays.sort(nums);

        if(binary(nums,0,nums.length - 1,target))
            return output;

        else
            return -1;

    }

    public static boolean binary(int a[],int start, int end, int target) {
        while (start <=  end) {
            int mid = start + (end - start) / 2;

            if (mid == target)
                return true;

            else if (mid < target) {
                start = mid + 1;

            } else
                end = mid - 1;

        }

        return false;
    }





    public int search3(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    // finding minimum in sorted array in O(logn) time complexoty

    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    public int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        if (nums[lo] < nums[hi]) return nums[lo];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }

        return nums[hi];
    }
//
//    Example 1:
//
//    Input: nums = [-1,0,3,5,9,12], target = 9
//    Output: 4
//    Explanation: 9 exists in nums and its index is 4
//    Example 2:
//
//    Input: nums = [-1,0,3,5,9,12], target = 2
//    Output: -1
//    Explanation: 2 does not exist in nums so return -1


    public boolean isPerfectSquare(int num)
    {

        int start = 1 ;
        int end = num;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            long midSquare = (long) mid * mid;

            if(midSquare == num)
                return true;

            else if( midSquare > num)
                end = mid - 1;

            else
                start = mid + 1;

        }

return false;
    }


//    public int bsearch(int start,int end) {
//        if(start >= end)
//            return start;
//
//        int mid = start + (end - start) / 2;
//
//        // int mid = (start+end)/2;
//        if(isBadVersion(mid)) {
//            return bsearch(start, mid);
//        }else {
//            return bsearch(mid+1, end);
//        }
//
//    }



    public static int guess(int n ) {return 0;}

    public int guessNumber(int n) {
        int start = 0;
        int end = n;

        while(start <= end)
        {
            int mid = start + (end - start)/2;


            if(guess(mid) == 0 )
            {
                return mid;

            }

            else if( guess(mid) == -1)
            {
                end = mid - 1;
            }

            else
                start = mid + 1;


        }

        return 0;
    }

    public int mySqrt(int x) {

        if (x == 0 || x == 1) return x;

        int start = 1, end = x, ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((long)mid * mid == x) {
                return mid;
            } else if ((long)mid * mid < x) {
                ans = mid;       // store possible answer
                start = mid + 1; // move right
            } else {
                end = mid - 1;   // move left
            }
        }

        return ans;
    }


    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length]; // 1. This is our "staircase" - stores the SMALLEST last steps we've seen for each length.
        int len = 0;                        // 2. How many steps do we have in our staircase right now?
// JGSG
        // 3. Let's go through each step size we have available...
        for (int num : nums) {
            int i = 0, j = len;          // 4. We're going to find the right spot on the staircase to place this new step.

            // 5. Binary Search: Find the SMALLEST step in the staircase that's BIGGER OR EQUAL to our current step. 🔍
            while (i != j) {
                int mid = (i + j) / 2;   // 6. Check the middle step.
                if (sub[mid] < num)       // 7. Is this step TOO SMALL? Go higher.
                    i = mid + 1;
                else                        // 8. It's BIG ENOUGH! Try to go even lower.
                    j = mid;
            }

            // 9. Place the step! Either REPLACE an existing step or ADD a new one at the end.
            sub[i] = num;

            // 10. Did we add a NEW step to the END of our staircase? If so, make it longer!
            if (i == len)
                len++;
        }

        // 11. Return the total number of steps in our staircase! 🪜 That's the length of the longest increasing subsequence.
        return len;
    }

    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(arr[mid] - ( mid + 1 ) >= k)
            {

                end = mid - 1;

            }

            else
                start = mid + 1;
        }

        return start + k;

    }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (isPerfectSquare1(b)) return true;
        }
        return false;
    }

    private boolean isPerfectSquare1(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    /*Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined*/
    public int longestOnes(int[] nums, int k)
    {
       int left = 0 ;
       int right = 0;
       int max = 0;
       int count = 0;

       for(left = 0 ; left < nums.length; left++)
       {
           if(nums[left] == 0)
               right++;

           else
           {

               count++;


           }



       }

   return  0 ;
    }





}
