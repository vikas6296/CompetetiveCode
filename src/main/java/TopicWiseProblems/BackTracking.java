package org.example;

import java.util.*;

public class BackTracking {
    public static void main(String[] s) {

        // System.out.println(partition2("aabaa"));

        //System.out.println(findTargetSumWays(new int []{1,1,1,1,1},3));

        //System.out.println(subsets(new int []{1,2,3}));

        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

//    Input: rowIndex = 3
//    Output: [1,3,3,1]

    //    Input: candidates = [2,3,6,7], target = 7
//    Output: [[2,2,3],[7]]
//    Explanation:
//            2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//    These are the only two combinations.
//    Example 2:
//
//    Input: candidates = [2,3,5], target = 8
//    Output: [[2,2,2,2],[2,3,3],[3,5]]
    public static void combinationSum(int[] candidates, int target) {

        List<List<Integer>> l = new ArrayList<>();
        backTrack(0, candidates, new ArrayList<Integer>(), l, target);

        System.out.println(l);
    }

    public static void backTrack(int index, int[] candidates, List<Integer> current, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]); // choosing the element

            backTrack(i, candidates, current, result, target - candidates[i]); // exploring

            current.remove(current.size() - 1); // unchossing bakctracking

        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack1(0, candidates, new ArrayList<Integer>(), l, target);
        System.out.println(l);
        return l;
    }


    public static void backTrack1(int index, int[] candidates, List<Integer> current, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] > target)
                break;


            current.add(candidates[i]); // choosing the element

            backTrack1(i + 1, candidates, current, result, target - candidates[i]); // exploring

            current.remove(current.size() - 1); // unchossing bakctracking

        }

    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack3(1, k, n, new ArrayList<>(), result);
        return result;

    }

    public static void backtrack3(int start, int times, int combination, List<Integer> current, List<List<Integer>> result) {

        if (times == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (times < 0)
            return;

        for (int i = start; i <= combination; i++) {

            current.add(i);

            backtrack3(i + 1, times - 1, combination, current, result);

            current.remove(current.size() - 1);

        }
    }

//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack5(nums, new ArrayList<>(), result);
        return result;

    }

    public static void backtrack5(int nums[], List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));

        }


        for (int i = 0; i < nums.length; i++) {

            if (current.contains(nums[i]))
                continue;

            current.add(nums[i]);

            backtrack5(nums, current, result);

            current.remove(current.size() - 1);

        }

    }

    // [1,2,3] // [] [1][2][3][1,2][1,3][2,3][1.2.3]

    public static List<List<Integer>> getSubset(int num[]) {
        List<List<Integer>> result = new ArrayList<>();

        backtrackSubset(num, result, new ArrayList<>());
        return result;
    }

    public static void backtrackSubset(int num[], List<List<Integer>> result, List<Integer> current) {

        result.add(new ArrayList<>(current));

        for (int i = 0; i < num.length; i++) {

            if (current.contains(num[i]))
                continue;

            current.add(num[i]);

            backtrackSubset(num, result, current);

            current.remove(current.size() - 1);


        }

    }

// for not exploring same result in different place use int start identifier and add i + 1 in recursion method

//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step


//   Input: nums = [1,1,2]
//    Output:
//            [[1,1,2],
//            [1,2,1],
//            [2,1,1]]

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used numbers
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);

            backtrack(nums, used, tempList, result);

            // Backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    //    Input: nums = [1,0,-1,0,-2,2], target = 0
//    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//    Example 2:
//
//    Input: nums = [2,2,2,2,2], target = 8
//    Output: [[2,2,2,2]]


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtracking(0, nums, target, result, new ArrayList<>());

        return result;

    }

    public static void backtracking(int start, int nums[], int target, List<List<Integer>> result, List<Integer> current) {
        if (target == 0 && current.size() == 4) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i])
                continue;

            current.add(nums[i]);

            backtracking(i + 1, nums, target - nums[i], result, current);

            current.remove(current.size() - 1);

        }

    }

//    Input: s = "aab"
//    Output: [["a","a","b"],["aa","b"]]


    public static List<List<String>> partition(String s) {
        StringBuilder sb = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        backtrackPartition(0, new ArrayList<>(), result, s, sb);

        return result;
    }

    public static void backtrackPartition(int start, List<String> current, List<List<String>> result, String s, StringBuilder sb) {
        if (palindromeCheck(sb.toString())) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = start; i < s.length(); i++) {

            current.add(sb.append(s.charAt(i)).toString()); // adding one element

            backtrackPartition(i + 1, current, result, s, sb);

            current.remove(sb.deleteCharAt(sb.length() - 1).toString());

        }


    }

    public static boolean palindromeCheck(String s) {
        char t[] = s.toCharArray();
        int start = 0;
        int end = t.length - 1;

        while (start < end) {
            if (t[start] != t[end])
                return false;


            start++;
            end--;
        }

        return true;
    }


    public static List<List<String>> partition2(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrackPartition1(0, new ArrayList<>(), result, s);
        return result;
    }

    public static void backtrackPartition1(int start, List<String> current, List<List<String>> result, String s) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (palindromeCheck(substring)) {
                current.add(substring);
                backtrackPartition1(i + 1, current, result, s);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    public static boolean palindromeCheck1(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }


    public static int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs1(n, memo);
    }

    private static int climbStairs1(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs1(n - 1, memo) + climbStairs1(n - 2, memo));
        }
        return memo.get(n);
    }


    public static int findTargetSumWays(int[] nums, int target) {
        return backtrackTarget(nums, target, 0, 0);

    }

    private static int backtrackTarget(int nums[], int target, int currentSum, int index) {
        if (index == nums.length)
            return currentSum == target ? 1 : 0;


        int first = backtrackTarget(nums, target, currentSum + nums[index], index + 1);

        int second = backtrackTarget(nums, target, currentSum - nums[index], index + 1);

        return first + second;

    }


    HashMap<Integer, Integer>[] memo;

    public int findTargetSumWays1(int[] nums, int target) {
        memo = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) memo[i] = new HashMap<>();
        return bt(nums, 0, target);
    }

    public int bt(int[] nums, int index, int target) {
        if (index == nums.length) {
            return 0 == target ? 1 : 0;
        }
        if (memo[index].containsKey(target)) return memo[index].get(target);
        int res =
                bt(nums, index + 1, target - nums[index])
                        +
                        bt(nums, index + 1, target + nums[index]);
        memo[index].put(target, res);
        return res;

    }

    //    Example 1:
//
//    Input: nums = [1,2,3]
//    Output: [1,3,2]
//    Example 2:
//
//    Input: nums = [3,2,1]
//    Output: [1,2,3]

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubset(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrackSubset(int[] nums, List<List<Integer>> result, List<Integer> current, int start) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackSubset(nums, result, current, i + 1); // Move forward in index
            current.remove(current.size() - 1); // Backtrack
        }
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates on same tree level
            }
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }


    }



}