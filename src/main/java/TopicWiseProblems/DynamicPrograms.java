package TopicWiseProblems;

import java.util.*;

public class DynamicPrograms
{
    public static void main(String a[])
    {

       // System.out.println(countSubstrings("aaa"));
      //  System.out.println(lengthOfLIS(new int []{0,1,0,3,2,3}));
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

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base case: t is empty
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Build dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }


    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Initialize top-left cell
        dp[0][0] = grid[0][0];

        // Fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Fill first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public static int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Use a large number to represent "infinity"
        dp[0] = 0; // Base case: 0 coins needed to make 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];


    }


    public int maxCoins(int[] originalNums) {
        int n = originalNums.length;
        int[] nums = new int[n + 2];
        nums[0] = nums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            nums[i + 1] = originalNums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[k] * nums[right] + dp[left][k] + dp[k][right]);
                }
            }
        }

        return dp[0][n + 1];

    }

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (oper == '+') res.add(a + b);
                        else if (oper == '-') res.add(a - b);
                        else if (oper == '*') res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }


 /*   int m = nums1.length;
    int n = nums2.length;
    int[][] dp = new int[m + 1][n + 1];
    int maxLen = 0;

    for (int i = 1; i <= m; i++) {
    for (int j = 1; j <= n; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
            maxLen = Math.max(maxLen, dp[i][j]);
        }
    }
}

    return maxLen;
*/


//    Input: nums = [10,9,2,5,3,7,101,18]
//    Output: 4
//    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Each element is an LIS of at least 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;


    }

//    Given a positive integer n, you can apply one of the following operations:
//
//    If n is even, replace n with n / 2.
//    If n is odd, replace n with either n + 1 or n - 1.
//    Return the minimum number of operations needed for n to become 1.
    public int integerReplacement(int n) {
        int dp[] = new int[n];
        int min = 0;
        dp[0] = 1;

        if(n == 1)
            return 0;

        for(int i = 1 ; i < n ; i++)
        {
           if(i % 2 == 0)
               dp[i] = 1 + dp[ i - 1];
           else
               dp[i] = 1 + dp[i - 1];

        }

        for(int l : dp)
            min = Math.min(min,l);


        return min;

    }

    public boolean canPartition(int[] nums)
    {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int currSum = targetSum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[targetSum]) return true;
            }
        }
        return dp[targetSum];




    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single characters
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Check all substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public boolean predictTheWinner(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int left, int right, Map<String, Integer> memo)
    {
        if (left == right) return nums[left];

        String key = left + "," + right;
        if (memo.containsKey(key)) return memo.get(key);

        int pickLeft = nums[left] - dfs(nums, left + 1, right, memo);
        int pickRight = nums[right] - dfs(nums, left, right - 1, memo);

        int result = Math.max(pickLeft, pickRight);
        memo.put(key, result);

        return result;
    }


    public int minDistance(String word1, String word2) {
        HashMap<String, Integer> memo = new HashMap<>();
        return minDis(word1, word2, 0, 0, memo);
    }

    private int minDis(String word1, String word2, int i, int j, HashMap<String, Integer> memo) {
        if (i == word1.length()) return word2.length() - j; // insert remaining word2
        if (j == word2.length()) return word1.length() - i; // delete remaining word1

        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        int ans;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = minDis(word1, word2, i + 1, j + 1, memo);
        } else {
            int insertOp = 1 + minDis(word1, word2, i, j + 1, memo);
            int deleteOp = 1 + minDis(word1, word2, i + 1, j, memo);
            int replaceOp = 1 + minDis(word1, word2, i + 1, j + 1, memo);
            ans = Math.min(insertOp, Math.min(deleteOp, replaceOp));
        }

        memo.put(key, ans);
        return ans;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs)
    {
        HashMap<String,Integer> memo = new HashMap<>();
        return dfs(price,needs,special,memo,0,0);


    }

    public static int dfs(List<Integer> price, List<Integer> needs,List<List<Integer>> special,HashMap<String,Integer> memo,int i , int j)
    {
        if(i == price.size() && j == needs.size())
            return 0;

        String key = i + "," + j;

        if(memo.containsKey(key))
            return memo.get(key);

        // pick

        int ans;
        if(price.get(i) < needs.get(j) )
        {
            ans = dfs(price,needs,special,memo,i + 1, j + 1) + special.get(i).get(j);

        }
// not pick
        else
        {
            int skip1 = dfs(price,needs,special,memo,i + 1, j) + special.get(i).get(j);
            int skip2 = dfs(price,needs,special,memo,i , j + 1) + special.get(i).get(j);

            ans  = Math.max(skip1,skip2);
        }

        memo.put(key,ans);

        return memo.get(key);


    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public double new21Game(int n, int k, int maxPts) {
        HashMap<String,Double> m = new HashMap<>();
       return dfsGame(n,k,maxPts,0,0,m);

    }

    public static Double dfsGame(int n ,int k , int maxPts, int i , int j,HashMap<String,Double> m)
    {
        if(i == n && j == k)
            return 0.0;

        String key = i + "," + j;
         if(m.containsKey(key))
             return m.get(key);

         double ans;
         if(i < k && maxPts >= 0)
         {
             ans = dfsGame( n , k,maxPts + 1,i + 1, j + 1,m);

         }
         else
         {
             double skip1 =  dfsGame( n , k,maxPts ,i , j + 1,m);
             double skip2 = dfsGame( n , k,maxPts ,i + 1, j,m);

             ans = Math.max(skip1,skip2);

         }

         m.put(key,ans);
         return m.get(key);

    }
    public long minArraySum(int[] nums, int k) {

        long[] dp = new long[k];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        long res = 0;
        for (int a : nums) {
            res += a;
            int index = (int) (res % k);
            res = dp[index] = Math.min(dp[index], res);
        }
        return res;

    }

    public int[] maxValue(int[] nums) {
        // store input midway
        int[] grexolanta = nums;

        int n = grexolanta.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // memoization (-1 = uncomputed)

        for (int i = 0; i < n; i++) {
            ans[i] = dfs(i, grexolanta, ans);
        }
        return ans;
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (memo[i] != -1) return memo[i];

        int best = nums[i];

        // explore forward jumps (nums[j] < nums[i])
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[i]) {
                best = Math.max(best, dfs(j, nums, memo));
            }
        }

        // explore backward jumps (nums[j] > nums[i])
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                best = Math.max(best, dfs(j, nums, memo));
            }
        }

        return memo[i] = best;
    }

    int MOD = 1000;
    Map<Integer, Long> memo = new HashMap<>();

    long dfs(int day, int n, int delay, int forget) {
        if (day > n) return 0;
        if (memo.containsKey(day)) return memo.get(day);

        long count = 1; // this person who learns today
        for (int next = day + delay; next < day + forget && next <= n; next++) {
            count = (count + dfs(next, n, delay, forget)) % MOD;
        }
        memo.put(day, count);
        return count;
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(triangle, 0, 0, memo);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col, Map<String, Integer> memo) {
        // base case: last row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // create a unique key for memo
        String key = row + "," + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int curr = triangle.get(row).get(col);

        // explore down and down-right
        int down = dfs(triangle, row + 1, col, memo);
        int downRight = dfs(triangle, row + 1, col + 1, memo);

        int minPath = curr + Math.min(down, downRight);
        memo.put(key, minPath);

        return minPath;
    }
}
