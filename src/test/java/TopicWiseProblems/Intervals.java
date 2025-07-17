package org.example;

import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Array;
import java.util.*;

public class Intervals
{
    int start ;
    int end ;

    public Intervals(int start , int end)
    {
        this.start = start;
        this.end = end;

    }

//    Input:  [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]

    public static void main(String s[])
    {
//        Intervals [] i = new Intervals[4];
//        i[0] = new Intervals(1,3);
//        i[1] = new Intervals(2,6);
//        i[2] = new Intervals(8,10);
//        i[3] = new Intervals(15,18);
//
//        getTheIntervals(i);

       // System.out.println(Arrays.toString(twoSum(new int []{3,5,1,2,3,6},8)));

       // System.out.println(threeSum(new int []{-1,0,1,2,-1,-4}));

        //System.out.println(fourSum(new int []{2,2,2,2,2}, 8));

      //  System.out.println(Arrays.toString(removeDuplicatesSortedArray(new int []{0,0,1,1,1,1,2,3,3})));

        //System.out.println(longestConsecutive(new int []{100,4,200,1,3,2}));

        //System.out.println(numSubseq(new int []{3,5,6,7},9));

      //  System.out.println(getCOuntSubarray(new int []{1, 1, 1},2));

     //   System.out.println(permute("vikas"));

       // System.out.println(countSubarrays(new int []{1,1,1},2));

        //System.out.println(longestConsecutiveSequence(new int []{100, 4, 200, 1, 3, 2}));
        //System.out.println(Arrays.toString(twoSum2(new int []{2,7,11,15},9)));
        //maxEvents(new int [][]{{1,2},{2,3},{3,4}});
       // System.out.println(permuteUnique(new int []{1,1,2}));

        //System.out.println(combinationSum2(new int []{10,1,2,7,6,1,5},8));

        //System.out.println(Arrays.toString(maxNumber(new int []{2,1,4,1,7,1,5})));

        System.out.println(Arrays.toString(getProductNumber(new int []{1,2,3,4})));
    }
//    Input: "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.

    public static int longestNonRepeatingCharacters(String s)
    {
        char t [] = s.toCharArray();
        int start = 0 ;
        int end = 0 ;
        HashMap<Character,Integer> m = new HashMap<>();
        int max = 0;

        while(end < t.length)
        {
            m.put(t[end],m.getOrDefault(t[end], 0)  + 1);

            if(m.size() == end - start + 1)
            {
                max = Math.max(max,end - start + 1);
                end++;

            }

            else if(m.size() < end - start + 1)
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



        }

        return max;

    }



   /* public static Intervals[] getTheIntervals(Intervals[] interval)
    {
        Arrays.sort(interval, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.start - o2.start;
            }
        });

      int index = 0;

      for(int i = 1 ; i < interval.length; i++)
      {
          if(interval[index].end > interval[i].start)
          {
              interval[index].end = Math.max(interval[index].end,interval[i].end);
          }

          else
          {
              index++;
              interval[index] = interval[i];
          }

      }




      for(int i = 0 ; i <= index ; i++)
      {
          System.out.println(" start :" + interval[i].start + " end : "+ interval[i].end);
      }


      return interval;
    }*/


    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i : nums)
        {
            int diff = target - i ;

            if(m.containsKey(diff))
                return new int [] {diff,m.get(diff)};

            m.put(i,diff);

        }

        return null;
    }

    public static  List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length - 2 ; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end)
            {
                if(nums[i] + nums[start] + nums[end] == 0)
                {
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[start],nums[end])));


                    while( start < end && nums[start] == nums[start + 1])
                        start++;

                    while( start < end && nums[end] == nums[end - 1])
                        end--;



                    start++;
                    end --;
                }


                else if(nums[i] + nums[start] + nums[end]  < 0)
                 start++;

                else
                    end--;


            }




        }


return result;

    }


    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length - 3 ; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            for(int j = i + 1 ; j < nums.length - 2 ; j++)
            {
                if(j > 0 && nums[j] == nums[ j - 1])
                    continue;


                int start = j + 1;
                int end = nums.length - 1;


                while(start < end)
                {
                    if(nums[i] + nums[j] + nums[start] + nums[end] == target)
                    {

                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[start],nums[end])));

                        start++;
                        end--;

                        while(start < end && nums[start] == nums[start + 1])
                            start++;

                        while(start < end && nums[end] == nums[end - 1])
                            end--;


                    }

                    else if(nums[i] + nums[j] + nums[start] + nums[end] < target)
                        start++;

                    else
                        end--;



                }




            }


        }

        return result;
    }
//
//    Input: nums = [3,2,3]
//    Output: 3
//
//    Input: nums = [2,2,1,1,1,2,2]
//    Output: 2

    public static int majorityElement(int a[])
    {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i : a)
            m.put(i,m.getOrDefault(i,0) + 1);

        for(int i : m.keySet())
        {
            if(m.get(i) > a.length / 2)
                return i;

        }


        return -1;
    }

    public static int[] removeDuplicatesSortedAssary(int a[])
    {  HashMap<Integer,Integer> m = new HashMap<>();

        for(int i : a)
            m.put(i,m.getOrDefault(i,0) + 1);

        for(int i : m.keySet())
        {
            if(m.get(i) > 2)
                m.put(i,2);

        }
         int index = 0;
        for(int i: m.keySet())
        {
            int j = m.get(i);
            while(j > 0)
            {
                a[index++] = i;
                j--;
            }


        }

        return a;

    }
//    Input: nums = [0,0,1,1,1,1,2,3,3]
//    Output: 7, nums = [0,0,1,1,2,3,3,_,_]

    public static int[] removeDuplicatesSortedArray(int a[])
    {
        int i = 0;

        for(int n : a)
        {
            if(i < 2 || n != a[i - 2 ])
            {
                a[i] = n;
                i++;
            }

        }

return a;

    }

    //  longest consecutive sequence in the unsorted array
    //int[] nums = {100,4,200,1,3,2};
    public static int longestConsecutive(int[] nums)
    {
        HashSet<Integer> h = new HashSet<>();
        int maxStreak = 0;

        for(int i : nums)
            h.add(i);


        for(int i : h)
        {
            if(!h.contains(i - 1))
            {
                int current = i ;
                int currentStreak = 1;

                while(h.contains(current + 1))
                {
                    currentStreak++;
                    current++;
                }

                maxStreak = Math.max(maxStreak,currentStreak);

            }

        }

         return maxStreak;
    }

//    Input: nums = [2,3,1,1,4]
//    Output: true

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

//    Input: nums = [3,5,6,7], target = 9
//    Output: 4
//    Explanation: There are 4 subsequences that satisfy the condition.
//[3] -> Min value + max value <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//        [3,5,6] -> (3 + 6 <= 9)
//        [3,6] -> (3 + 6 <= 9)

    public static int numSubseq(int[] nums, int target)
    {
        HashSet<Integer> h = new HashSet<>();
        int count = 0 ;

      for(int i : nums)
          h.add(i);


      for(int j : nums)
      {
          if(!h.contains(j - 1))
          {
              int current  = j;

              while(h.contains(current + 1))
              {
                  if(current + current + 1 <= target )
                    count++;

                  current++;
              }

          }
      }

return count;

    }


//    Input:
//    nums = [1, 1, 1], k = 2
//    Output: 2
//    Explanation:
//        [1,1] starting at index 0 and [1,1] starting at index 1.

    public static int getCOuntSubarray(int a[], int k)
    {
        int start = 0;
        int end = 0;
        int maxCount = 0 ;
        int sum = 0;


        while(end < a.length)
        {
            sum = sum + a[end];

            if(sum == k)
            {
                maxCount = Math.max(maxCount,end - start + 1);
                end++;
                sum = 0;
            }

             if( sum > k)
            {
                while(sum > k)
                {
                    start++;
                }
                end++;
            }


        }


        return maxCount;
    }


    public static void prefixSum(int a[],int k)
    {
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);

        int sum = 0 ;

        for(int i = 0 ; i < a.length ; i++)
        {
            sum = sum + a[i];

            int currentSum = sum - k ;


        }


    }

 //   Print all permutations of a given string

    public static List<String> permute(String a)
    {
        List<String> result = new ArrayList<>();
        stringPermutation(new StringBuilder(a),result,0);
        return result;

    }

    public static void stringPermutation(StringBuilder sb,List<String>current,int start )
    {
        if(start == sb.length() - 1)
        {
            current.add(sb.toString());
        }


        for(int i = start ; i < sb.length() ; i++)
        {
            swap(sb,start,i);  // adding to the stringbuilder
            stringPermutation(sb,current,start + 1);
            swap(sb,start,i); // backtrack


        }

    }

    public static void swap(StringBuilder sb , int start , int end)
    {
        char temp = sb.charAt(start);
       sb.setCharAt(start,sb.charAt(end));
       sb.setCharAt(end,temp);

    }

    public static int countSubarrays(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int longestConsecutiveSequence(int a[])
    {
       HashSet<Integer> h  = new HashSet<>();

       // adding all numbers to the set
       for(int n : a)
           h.add(n);

       int longest = 0;

       for(int j : a)
       {
           if(!h.contains(j - 1))
           {
               int currentNum = j;
               int count = 1;

               while(h.contains(currentNum + 1))
               {
                   currentNum++;
                   count++;
               }

               longest = Math.max(longest,count);

           }


       }



return longest;
    }

public static boolean hasCycle(ListNode head)
{

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null)
    {
        slow = slow.next;
        fast = fast.next.next;


        if(slow == fast)
            return true;

    }
    return false;

}

public static int[] twoSum2(int a[],int target)
{
    HashMap<Integer,Integer> m = new HashMap<>();

    for(int i = 0 ; i < a.length ; i++)
    {
        int remainder =  target - a[i];

        if(m.containsKey(remainder))
        {
            return new int []{m.get(remainder),i};
        }

        m.put(a[i],i);

    }
return new int[]{};

}

    public static int  maxEvents(int[][] events)
    {
        Arrays.sort(events,(a,b) -> Integer.compare(a[0],b[0]));

        int day = 1;
        int count = 0;
        int i = 0 ;
        int n = events.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while(i < n || !minHeap.isEmpty())
        {
            if(minHeap.isEmpty())
            {
                day = events[0][i];
            }

            System.out.println("value of day --->"+day);

            while (i < n && events[i][0] == day)
            {
                minHeap.offer(events[i][1]);
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek() < day)
            {
                minHeap.poll();
            }

            if(!minHeap.isEmpty())
            {
                minHeap.poll();
                count++;
            }

            day++;
        }
return count;

    }
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    public static List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        boolean [] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrackPermutation(nums,result,new ArrayList<>(),isVisited);

        return result;

    }

    public static void backtrackPermutation(int []nums,List<List<Integer>> result,List<Integer> current,boolean isVisisted[])
    {
       if(current.size() == nums.length)
       {
           result.add(new ArrayList<>(current));
       }

//       if(current.size() > nums.length)
//           return;


        for(int i = 0; i < nums.length ; i++)
        {

            if(i > 0 && nums[i] == nums[i - 1] && !isVisisted[i - 1])
                continue;

            if(!isVisisted[i]) {

                current.add(nums[i]);
                isVisisted[i] = true;

                backtrackPermutation(nums, result, current,isVisisted);

                current.remove(current.size() - 1);
                isVisisted[i] = false;
            }
        }

    }


  // binary tree nodes root leaves

    // traversal preorder postorder inorder
    // preorder root left right
    // postorder left right root
    // inorder left root right

    public int maxValue(int[][] events, int k)
    {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;

        int[] endDays = new int[n];
        for (int i = 0; i < n; i++) {
            endDays[i] = events[i][1];
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0];
            int value = events[i - 1][2];

            // Find the latest event ending before start
            int left = 0, right = i - 2;
            int p = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (endDays[mid] < start) {
                    p = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[p + 1][j - 1] + value
                );
            }
        }

        return dp[n][k];


    }
//    Input: candidates = [10,1,2,7,6,1,5], target = 8
//    Output:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]

    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> result1 = new ArrayList<>();

        backtrackCombination(candidates,target,result,new ArrayList<>(),0);

        HashSet<List<Integer>> h = new HashSet<>();

        for(List<Integer> l :result)
        {
            h.add(l);
        }
        for(List<Integer> k : h)
        {
            result1.add(k);
        }


        return result;


    }

    public static void backtrackCombination(int []candidates,int target,List<List<Integer>> result,List<Integer> current,int start)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(current));
        }


        for(int i = start ; i < candidates.length ; i++)
        {


            current.add(candidates[i]);

            backtrackCombination(candidates,target - candidates[i],result,current,i + 1);

            current.remove(current.size() - 1);



        }


    }

    // [10,9,2,5,3,7,101,18]
    public static void lengthLis(int []nums)
    {
        int len = 0;
        int st[] = new int [nums.length];

      for(int n : nums) {
          int i = 0;
          int j = len;

          while(i != j)
          {
              int mid = (i + j) / 2;

              if(st[mid] < n)
                  i = mid + 1;

              else
                  j = mid;

          }

          st[i] = n;

          if(i == len)
              len++;

      }
    }


    // largest three no and second largest no

    public static int[] maxNumber(int []a)
    {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int n : a)
        {
            p.offer(n);

            if(p.size() > 2)
            {
                p.poll();
            }

        }
        return new int []{p.peek()};

//        int b[] = new int[p.size()];
//        int idx = 0;
//        while(!p.isEmpty())
//        {
//            b[idx++] = p.poll();
//        }

    }

    // 1 2 3 4
    // 1 1 2 6
    // 24 12 4 1

    public static int[] getProductNumber(int a[])
    {
      int leftProduct[] = new int[a.length];
      int rightProduct[] = new int [a.length];
      int result[] = new int[a.length];
      leftProduct[0] = 1;
      rightProduct[rightProduct.length - 1] = 1;


      for(int i = 1 ; i < a.length ; i++)
      {
          leftProduct[i] = a[i - 1] * leftProduct[i - 1];
      }

      for(int i = a.length - 2 ; i >= 0 ; i--)
      {
          rightProduct[i] = a[i + 1] * rightProduct[ i + 1];
      }

     for(int i = 0 ; i < a.length ; i++)
     {
         result[i] = leftProduct[i] * rightProduct[i];
     }

     return result;

    }



}
