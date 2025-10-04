package TopicWiseProblems;

import java.util.*;

public class ArrayProblems {
    //    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]

    public static void main(String[] a) {

        //System.out.println(threeSum(new int []{0,0,0}));
        //System.out.println(threeSum3(new int []{-1,0,1,2,-1,-4}));

        //System.out.println(twoSum(new int []{5,3,2,1,4,-2,2-4,1,4,7},6));

        // System.out.println(fourSum(new int []{5,3,2,1,4,-2,2-4,1,4,7},11));

        //  System.out.println(threeSumClosest(new int []{-1,2,1,-4},1));

        // System.out.println(Arrays.toString(twoSum3(new int []{1, 2, 3,5 ,8,2,1 ,-1},5)));

        //  System.out.println(allPermutations("code",new String[]{"ax","d","bb","e","ed","co"}));

        // System.out.println(Arrays.toString(twuoSumO(new int []{1,2 ,3 ,4 ,2},6)));

        //   System.out.println(Arrays.toString(twoDifference(new int []{1 ,2, 3, 4, 5, 6},4)));


     /*   HashSet<int[]> h = twoSumWithTwoSort(new int []{1,2,3,4,5,-8,2},6);

        int[][] array = h.toArray(new int[h.size()][]);
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }*/

        // System.out.println(maxProfit(new int []{7,6,4,3,1}));

        // System.out.println(maxProfit1(new int []{1,2,3,4,5}));

        /// System.out.println( repeatedNTimes(new int []{5,1,5,2,5,3,5,4}));

        // System.out.println(maxProduct(new int []{2,3,-2,4}));

        //  System.out.println(threeSum5(new int []{-1,0,1,2,-1,-4}));

        // System.out.println(fib(15));

        // System.out.println(containsNearbyAlmostDuplicate(new int []{1,5,9,1,5,9},2,3));

        // System.out.println(findMin(new int []{4,5,6,7,0,1,2}));

        //System.out.println(isHappy(2));

        // System.out.println(palindromePossibility1("racectar"));

        //System.out.println(Arrays.toString(nextGreaterElement1(new int []{4,1,2},new int []{1,3,4,2})));


        System.out.println(Arrays.toString(getSum(new int[]{5, 2, 7, 1, 4}, 10)));
        // System.out.println(countDigitOne(0));

        //System.out.println(bulbSwitch(4));

        // System.out.println(findDuplicate(new int []{3,1,3,4,2}));

        //System.out.println(check(new int []{3,4,5,1,2}));

        //  System.out.println(addDigits(0));

        // System.out.println(getHint("11","10"));

        ///  System.out.println(isPowerOfThree(0));

        //  System.out.println(maximumDifference(new int []{1,5,2,10}));

        // System.out.println(maxAscendingSum(new int []{10,20,30,5,10,50}));

        // System.out.println(divideArray(new int []{3,2,3,2,2,2}));

        // System.out.println(longestSubarray(new int []{1, 2, 3, 2, 2}));

        //  System.out.println(fourSumCount(new int []{0},new int []{0},new int []{0},new int []{0}));
//    Input:  [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
        // System.out.println(merge1(new int [][]{{1,3},{2,6},{8,10},{15,18}}));

        // System.out.println(removeDuplicates(new int []{0,0,1,1,1,2,2,3,3,4}));
        // System.out.println(subArraySum(new int []{1,1,1},2));

        //  System.out.println(Arrays.toString(checkDNF(new int []{2,0,1,3,0,1,2,3,0,3})));

        //  System.out.println(findShortestSubArray(new int []{1,2,2,3,1,4,2}));

        // System.out.println(maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},10));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);

        HashSet<List<Integer>> uniqueTriplets = new HashSet<>();
        for (List<Integer> triplet : result) {
            List<Integer> sortedTriplet = new ArrayList<>(triplet);
            Collections.sort(sortedTriplet);  // Sort before putting into set
            uniqueTriplets.add(sortedTriplet);
        }

        return new ArrayList<>(uniqueTriplets);

    }

    public static void backtrack(int nums[], List<List<Integer>> result, List<Integer> current, int start) {
        if (current.size() == 3 && checkSum(current)) {

            result.add(new ArrayList<>(current));
            return;

        }

        if (current.size() > 3)
            return;


        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i - 1] == nums[i])
                continue;
            current.add(nums[i]);

            backtrack(nums, result, current, i + 1);

            current.remove(current.size() - 1);

        }

    }

    public static boolean checkSum(List<Integer> current) {
        int sum = 0;
        for (int i : current) {
            sum = sum + i;
        }

        return sum == 0 ? true : false;
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for i

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left and right to the next different numbers to skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum3(int a[]) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1])
                continue;  // skip duplicates

            int left = i + 1;
            int right = a.length - 1;

            while (left < right) {
                int sum = a[i] + a[left] + a[right];

                if (sum == 0) {

                    result.add(Arrays.asList(a[i], a[left], a[right]));

                    while (left < right && a[left] == a[left + 1])
                        left++;

                    while (left < right && a[right] == a[right - 1])
                        right--;


                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;


            }

        }

        return result;
    }

    // 5,3,2,1,4,-4,1,10,7


    public static List<List<Integer>> twoSum(int a[], int target) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target)
                    result.add(Arrays.asList(a[i], a[j]));

            }

        }

        return result;

    }


    public static List<List<Integer>> twoSum1(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>(); // To avoid duplicate pairs

        for (int num : a) {
            int complement = target - num;
            if (seen.contains(complement)) {
                // Create a sorted pair to avoid duplicates like (3,7) and (7,3)
                int first = Math.min(num, complement);
                int second = Math.max(num, complement);
                String pairKey = first + ":" + second;

                if (!uniquePairs.contains(pairKey)) {
                    result.add(Arrays.asList(first, second));
                    uniquePairs.add(pairKey);
                }
            }
            seen.add(num);
        }

        return result;
    }


    public static List<List<Integer>> fourSum(int a[], int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(a);

        for (int i = 0; i < a.length - 3; i++) {


            for (int j = i + 1; j < a.length - 2; j++) {

                if (i > 0 && a[i] == a[i - 1]) // skip duplicates
                    continue;

                if (j > 0 && a[j] == a[j - 1])  // skip duplicates
                    continue;


                int left = j + 1;
                int right = a.length - 1;

                while (left < right) {

                    int sum = a[i] + a[j] + a[left] + a[right];

                    if (sum == target) {

                        result.add(Arrays.asList(a[i], a[j], a[left], a[right]));


                        while (left < right && a[left] == a[left + 1]) // skip duplciates
                            left++;

                        while (left < right && a[right] == a[right - 1])// skip duplciates
                            right--;


                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else
                        right--;

                }

            }

        }

        return result;
    }

//    Input: nums = [-1,2,1,-4], target = 1
//    Output: 2
//    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


    public static int threeSumClosest(int[] nums, int target) {
        int minDiffernece = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                int difference = Math.abs(sum - target);

                if (difference < minDiffernece)
                    minDiffernece = Math.min(difference, sum);


                while (left < right && nums[left] == nums[left + 1])
                    left++;

                while (left < right && nums[right] == nums[right - 1])
                    right--;


                left++;
                right--;

            }


        }


        return minDiffernece;
    }

    public static int threeSumClosesst(int[] nums, int target) {
        Arrays.sort(nums); // Required for two-pointer approach

        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first possible sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Exact match
                    return target;
                }
            }
        }

        return closestSum;
    }


    // { 1, 2, 3,4 ,6,2,1 ,-1} target = 5
    public static int[] twoSum3(int a[], int target) {
        int result[] = new int[2];
        int minDiference = Integer.MAX_VALUE;

        Arrays.sort(a);
        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            int sum = a[start] + a[end];

            int diff = Math.abs(sum - target);

            if (diff < minDiference) {
                minDiference = diff;

                result[0] = a[start];
                result[1] = a[end];

            }

            if (sum < target)
                start++;

            else
                end--;


        }


        return result;
    }

    //    Input 1 Array :{"ax","d","bb","e","ed","co"}
//    INput 2 Word  : code
//            (edited)
//12:56
//    c o d e
//12:56
//    co de
//12:56
//    c od e

    public static int allPermutations(String a, String b[]) {
        List<String> result = new ArrayList<>();
        //StringBuilder sb = new StringBuilder();
        int start = 0;
        backtrack(start, a, result, new StringBuilder());

        int count = 0;
        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < b.length; j++) {
                if (result.get(i).equals(b[j]))
                    count++;
            }

        }

        return count;

    }


    public static void backtrack(int start, String a, List<String> result, StringBuilder sb) {

        result.add(sb.toString());


        for (int i = start; i < a.length(); i++) {

            sb.append(a.charAt(i));
            //current.add(String.valueOf(a.charAt(i)));

            backtrack(i + 1, a, result, sb);

            //current.remove(current.size() - 1);
            sb.deleteCharAt(sb.length() - 1);

        }


    }

    public static void allPermutations(String input) {
        List<String> result = new ArrayList<>();
        permute(new StringBuilder(input), 0, result);
        System.out.println(result);
    }

    public static void permute(StringBuilder sb, int start, List<String> result) {
        if (start == sb.length() - 1) {
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < sb.length(); i++) {
            swap(sb, start, i);
            permute(sb, start + 1, result);
            swap(sb, start, i); // backtrack
        }
    }

    private static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    // 12 3 4 2  6
    public static int[] twuoSumO(int a[], int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int rem = target - a[i];

            if (m.containsKey(rem))
                return new int[]{i, m.get(rem)};

            m.put(a[i], i);


        }

        return new int[]{};

    }


    // 1 2 3 4
    public int findKthLargest(int[] nums, int k) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];

            } else if (nums[i] > secondLargest && nums[i] != largest)
                secondLargest = nums[i];

        }
        return 0;

    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }


    // 1 2, 3 4 5 6  taregt 4


    public static int[] twoDifference(int a[], int target) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) == target)
                    return new int[]{a[i], a[j]};

            }

        }
        return null;
    }


    public static int[] twoDifference2(int[] a, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : a) {
            if (seen.contains(num + target)) {
                return new int[]{num, num + target};
            }
            if (seen.contains(num - target)) {
                return new int[]{num, num - target};
            }
            seen.add(num);
        }

        return null; // No such pair found
    }


    public static HashSet<int[]> twoSumWithTwoSort(int a[], int target) {
        HashSet<int[]> h = new HashSet<>();

        int start = 0;
        int end = a.length - 1;
        Arrays.sort(a);
        System.out.println("sorted array --> " + Arrays.toString(a));

        while (start < end) {
            int sum = Math.abs(a[start] + a[end]);
            System.out.println("value of sum -->" + sum);

            if (sum == target) {
                h.add(new int[]{a[start], a[end]});
                start++;
                end--;
            } else if (sum < target)
                start++;

            else
                end--;


        }

        return h;
    }


//    Input: nums = [1,2,3,1]
//    Output: 4
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//    Total amount you can rob = 1 + 3 = 4.

    public static int rob(int[] nums) {
        int maxCheckOdd = 0;
        int maxCheckEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                maxCheckEven = maxCheckEven + nums[i];

            else
                maxCheckOdd = maxCheckOdd + nums[i];

        }

        return Math.max(maxCheckEven, maxCheckOdd);


    }

    public int rob1(int[] nums) {
        int prevRob = 0;
        int maxRob = 0;

        for (int curValue : nums) {
            int temp = Math.max(maxRob, prevRob + curValue);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }

    //   Input: nums = [1,2,3,1]
//    Output: 4
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//    Total amount you can rob = 1 + 3 = 4.


    public static int houseRob(int a[]) {
        int prevRob = 0;
        int maxRob = 0;

        for (int i : a) {
            int temp = Math.max(maxRob, prevRob + i);
            prevRob = maxRob;
            maxRob = temp;

        }

        return maxRob;
    }


//    Input: prices = [7,3,5,2,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


    public static int maxProfit(int[] prices) {
        int maxPro = 0;
        int currentPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (currentPrice < prices[i])
                maxPro = Math.max(maxPro, prices[i] - currentPrice);

            else
                currentPrice = prices[i];

        }

        return maxPro;

    }


//    Input: prices = [7,1,5,3,6,4]
//    Output: 7
//    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//    Total profit is 4 + 3 = 7.

    public static int maxProfit1(int[] prices) {

        int maxprofit = 0;
        int currentPrice = prices[0];
        int max = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < prices.length; i++) {
            if (currentPrice < prices[i]) {
                maxprofit = Math.max(maxprofit, prices[i] - currentPrice);
                a.offer(maxprofit);
                max = max + maxprofit;
                maxprofit = 0;
                currentPrice = prices[i];

            } else {
                currentPrice = prices[i];
            }


        }

        System.out.println("maximum profit -->" + max);
        System.out.println("pririoty queue values -->" + a);

        int maximumProfit = a.poll() + a.poll();


        return maximumProfit;


    }


//
//    Input: nums = [1,2,3,3]
//    Output: 3
//    Example 2:
//
//    Input: nums = [2,1,2,5,3,2]
//    Output: 2
//    Example 3:
//
//    Input: nums = [5,1,5,2,5,3,5,4]


    public static int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i : nums)
            m.put(i, m.getOrDefault(i, 0) + 1);

        for (int y : m.keySet()) {
            if (nums.length / m.get(y) == 2)
                return y;

        }

        return 0;
    }


    // (*))
    public boolean checkValidString3(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }

//    Input: nums = [3,4,2]
//    Output: 6
//    Explanation: You can perform the following operations:
//        - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//        - Delete 2 to earn 2 points. nums = [].

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i : nums)
            m.put(i, m.getOrDefault(i, 0) + 1);


        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {


            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> u : m.entrySet())
            p.offer(u);


        while (!p.isEmpty()) {

        }
        return 0;
    }


    public int deleteAndEarn1(int[] nums) {
        var numToCount = new HashMap<Integer, Integer>();
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var num : nums) {
            numToCount.compute(num, (k, v) -> v == null ? 1 : ++v);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        var prevIncEarn = 0;
        var prevExcEarn = 0;
        for (var i = min; i <= max; i++) {
            var incEarn = prevExcEarn + i * numToCount.getOrDefault(i, 0);
            var excEarn = Math.max(prevIncEarn, prevExcEarn);
            prevIncEarn = incEarn;
            prevExcEarn = excEarn;
        }
        return Math.max(prevIncEarn, prevExcEarn);
    }


    //    Input: nums = [1,2,3,1]
//    Output: 4
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//    Total amount you can rob = 1 + 3 = 4.
    public static int rob12(int[] nums) {
        int prevRob = 0;
        int maxRob = 0;

        for (int i : nums) {
            int temp = Math.max(maxRob, prevRob + i);
            prevRob = maxRob;
            maxRob = temp;

        }

        return maxRob;

    }

//    Input: nums = [2,3,-2,4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.

    public static int maxProduct(int[] nums) {
        int maxProd = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxProd = maxProd * nums[i];

            max = Math.max(max, maxProd);

            if (maxProd < 1)
                maxProd = 1;

        }

        return max;

    }

    // -2 0 -1
    public static int maxProduct1(int[] nums) {
        int prod = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];

            max = Math.max(max, prod);

            if (prod == 0)
                prod = 1;


        }

        prod = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];

            max = Math.max(max, prod);

            if (prod == 0)
                prod = 1;

        }

        return max;
    }

//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]


    public static List<List<Integer>> threeSum5(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    while (start < end && nums[start] == nums[start + 1])
                        start++;

                    while (start < end && nums[end] == nums[end - 1])
                        end--;


                    start++;
                    end--;


                } else if (sum < 0)
                    start++;

                else
                    end--;

            }


        }


        return result;
    }


    //    Input: nums = [1,2,3,1], k = 3
//    Output: true
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (seen.containsKey(val) && i - seen.get(val) <= k)
                return true;


            seen.put(val, i);
        }
        return false;
    }


    public static int fib(int i) {

        int rowIndex = i;
        int colIndex = i;
        int dp[][] = new int[rowIndex + 1][colIndex + 1];

        int max = Integer.MIN_VALUE;

        for (int j = 2; j < i; j++) {
            max = Math.max(max, dp[rowIndex - 1][colIndex - 1]) + Math.max(max, dp[rowIndex - 2][colIndex - 2]);
            rowIndex = j;
            colIndex = j;
        }


        return dp[rowIndex + 1][colIndex + 1];
    }



/*
    Input: nums = [2,3,2]   [1,2,3,1]
    Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent hous
    */

    public static int rob5(int[] nums) {
        int prevRob = 0;
        int maxRob = 0;
        for (int i : nums) {
            int temp = Math.max(maxRob, nums[i] + prevRob);
            prevRob = maxRob;
            maxRob = temp;

        }

        return maxRob;
    }

    // 8,7,15,1,6,1,9,15
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (m.containsKey(val) && Math.abs(m.get(val) - i) <= indexDiff)
                return true;


            m.put(val, i);
        }

        return false;

    }


//    Input: nums = [2,2,1]
//
//    Output: 1
//
//    Example 2:
//
//    Input: nums = [4,1,2,1,2]
//
//    Output: 4

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i : nums)
            m.put(i, m.getOrDefault(i, 0) + 1);

        for (int j : m.keySet()) {
            if (m.get(j) == 1)
                return j;
        }

        return 0;
    }


    public int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime1(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime1(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    // seive of erathesenes algo
    public int countPrimes1(int n) {
        if (n < 2)
            return 0;

        boolean prime[] = new boolean[n];

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    prime[j] = false;

                }


            }


        }
        int count = 0;
        for (boolean p : prime) {
            if (p)
                count++;
        }

        return count;
    }


    public static int findMin(int[] nums) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : nums) {
            p.offer(i);

        }

        return p.peek();
    }

    //12 + 92 = 82
//        82 + 22 = 68
//        62 + 82 = 100
//        12 + 02 + 02 = 1
    public static boolean isHappy(int n) {

        HashSet<Integer> hs = new HashSet<>();

        while (n != 1 && !hs.contains(n)) {

            hs.add(n);
            int sum = 0;
            while (n != 0) {

                int f = n % 10;

                sum = sum + (f * f);

                n = n / 10;

            }

            n = sum;
        }
        return n == 1;


    }

    public boolean isHappy1(int n) {

        int slow = n;
        int fast = n;
//while loop is not used here because initially slow and
//fast pointer will be equal only, so the loop won't run.
        do {
//slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

//if a cycle exists, then the number is not a happy number
//and slow will have a value other than 1

        return slow == 1;
    }

//Finding the square of the digits of a number

    public int square(int num) {

        int ans = 0;

        while (num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }

    public static boolean isPalindromePossible(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;

        // Count how many characters have odd frequencies
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // If more than 1 character has an odd count → can't form a palindrome
        return oddCount <= 1;
    }


    public static boolean palindromePossibility1(String s) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        HashMap<Character, Integer> m = new HashMap<>();
        char t[] = s.toCharArray();

        for (char y : t)
            m.put(y, m.getOrDefault(y, 0) + 1);

        int oddCount = 0;

        for (char u : m.keySet()) {
            if (m.get(u) % 2 != 0)
                oddCount++;
        }

        return oddCount <= 1;

    }

//    Input: num = "1432219", k = 3
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    //    Input: target = 7, nums = [2,3,1,2,4,3]
//    Output: 2
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum == target)
                max = Math.max(max, nums.length);


        }

        return 0;

    }

    public int minSubArrayLen1(int target, int[] nums) {
        int j = 0, i = 0, min = Integer.MAX_VALUE, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(min, (j - i + 1));
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }


//    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//    Output: [-1,3,-1]
//    Explanation: The next greater element for each value of nums1 is as follows:
//        - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//        - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//        - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            int result = 0;

            for (int j = 0; j < nums2.length; j++) {
                s.push(nums2[i]);
                if (nums1[i] < s.peek())
                    result = s.peek();
            }

            if (result == 0) {
                ans[i] = -1;
                s.clear();
            } else {
                ans[i] = result;
                s.clear();
            }


        }


        return null;
    }


    public static int[] closestpairSum(int a[], int target) {
        Arrays.sort(a);

        int minDiff = Integer.MAX_VALUE;
        int[] pair = new int[2];
        int sum = 0;
        int currentSum = 0;

        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            sum = a[start] + a[end];

            currentSum = Math.abs(target - sum);


            if (sum == target)
                return new int[]{a[start], a[end]};

            if (currentSum < minDiff) {

                minDiff = Math.min(minDiff, currentSum);
                pair[0] = a[start];
                pair[1] = a[end];

            }

            if (sum < target)
                start++;

            else end--;


        }


        return pair;


    }


    public boolean canWinNim(int n) {
        return n % 4 != 0 ? true : false;

    }


    public static int countDigitOne(int n) {
        int countOne = 0;

        for (int i = 0; i <= n; i++) {
            countOne = countOne + countOneMethod(i);
        }

        return countOne;
    }

    public static int countOneMethod(int n) {
        int count = 0;

        while (n != 0) {
            int remainder = n % 10;
            if (remainder == 1)
                count = count + 1;

            n = n / 10;

        }

        return count;
    }

    public static int countDigitOne1(int n) {
        int count = 0;
        long pos = 1;  // use long to avoid overflow when pos becomes large

        while (n / pos > 0) {
            long higher = n / (pos * 10);
            long current = (n / pos) % 10;
            long lower = n % pos;

            if (current == 0) {
                count += higher * pos;
            } else if (current == 1) {
                count += higher * pos + (lower + 1);
            } else {
                count += (higher + 1) * pos;
            }

            pos *= 10;
        }

        return count;
    }


    public int countDigitOne2(int n) {

        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit > 1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;

    }

//    Input: n = 3
//    Output: 1
//    Explanation: At first, the three bulbs are [off, off, off].
//    After the first round, the three bulbs are [on, on, on].

    public static int bulbSwitch(int n) {
        boolean on = false;
        boolean off = false;

        boolean bulbs[] = new boolean[n];
        int countOnBulbs = 0;

        Arrays.fill(bulbs, true);

        for (int i = 1; i < n; i++) {
            if (bulbs[i])
                bulbs[i] = false;

            else
                bulbs[i] = true;


        }


        for (boolean i : bulbs) {
            if (i)
                countOnBulbs++;
        }


        return countOnBulbs;
    }


    public static int findDuplicate(int[] nums) {
        HashSet<Integer> h = new HashSet<>();

        for (int i : nums) {
            if (h.contains(i))
                return i;

            h.add(i);
        }
        return 0;

    }
//    Input: s = "12233", k = 4
//
//    Output: -1
//
//    Explanation:
//
//    For the substring "12233", the frequency of '1' is 1 and the frequency of '3' is 2. The difference is 1 - 2 = -1
//    public int maxDifference(String s, int k) {
//        if(k > s.length())
//            return -1;
//
//        HashMap<Integer,Integer> m = new HashMap<>();
//        char t [] = s.toCharArray();
//
//        for(char y : t )
//        {
//            int key = Character.getNumericValue(y);
//            m.put(key,m.getOrDefault(key,0) + 1);
//        }
//
//        char getChar = s.charAt(k);
//        int getKey = Character.getNumericValue(getChar);
//
//
//
//    }

    public static boolean check(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);

        }

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == min)
                minIndex = i;

            if (i == max)
                maxIndex = i;
        }

        if (minIndex == maxIndex + 1) {
            swapArray(nums, minIndex, nums.length - 1);
            swapArray(nums, 0, maxIndex);
            swapArray(nums, 0, nums.length - 1);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1])
                return false;
        }

        return true;
    }

    public static void swapArray(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;

        }

    }

    //  Check if Array Is Sorted and Rotated

    public boolean check1(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n])  // this is used to make the array check in circular way
            {
                count++;
            }
        }

        return count <= 1;
    }


//    Example 1:
//
//    Input: nums = [10,2]
//    Output: "210"
//    Example 2:
//
//    Input: nums = [3,30,34,5,9]
//    Output: "9534330"


    public boolean isPerfectSquare(int num) {
        int x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;

    }


//    Input: num = 38
//    Output: 2
//    Explanation: The process is
//38 --> 3 + 8 --> 11
//        11 --> 1 + 1 --> 2
//    Since 2 has only one digit, return it.


    public static int addDigits(int num) {
        int sum = 0;

        while (num > 0) {
            int remainder = num % 10;
            sum += remainder;

            num = num / 10;

            if (num == 0) {
                if (sum < 10)
                    return sum;
                else {
                    num = sum;
                    sum = 0;
                }
            }


        }

        return 0;
    }

    //    Input: secret = "1807", guess = "7810"
//    Output: "1A3B"
    public static String getHint(String secret, String guess) {
        int countBull = 0;
        int countCow = 0;
        char secretChar[] = secret.toCharArray();
        char guessChar[] = guess.toCharArray();

        for (int i = 0; i < secretChar.length; i++) {
            if (Character.getNumericValue(secretChar[i]) == Character.getNumericValue(guessChar[i]))
                countBull++;
        }

        System.out.println("value of countbull " + countBull);
        HashMap<Character, Integer> m = new HashMap<>();

        for (char t : secretChar)
            m.put(t, m.getOrDefault(t, 0) + 1);

        for (char u : guessChar)
            m.put(u, m.getOrDefault(u, 0) - 1);

        System.out.println("value of hashmap -->" + m);
        for (char y : m.keySet()) {
            if (m.get(y) == 0)
                countCow++;
        }


        if (countCow != 0)
            countCow = Math.abs(countCow - countBull);


        return countBull + "A" + countCow + "B";


    }

    public static String getHint1(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretCount[s - '0']++;
                guessCount[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

    }

    //    Input: n = 27
//    Output: true
//    Explanation: 27 = 33
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;   /// same logic for power of 2 also

    }

//    Input: nums = [7,1,5,4]
//    Output: 4
//    Explanation:

    public static int maximumDifference(int[] nums) {

        int maxDiff = Integer.MIN_VALUE;
        int currentDiff = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - currentDiff;

            if (diff > maxDiff)
                maxDiff = Math.max(maxDiff, diff);

            if (currentDiff > nums[i])
                currentDiff = nums[i];

        }

        return maxDiff > 0 ? maxDiff : -1;
    }


    //    Input: nums = [10,20,30,5,10,50]
//    Output: 65 JGSG
//    Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
    public static int maxAscendingSum(int[] nums) {
        int curr = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i] > nums[i - 1] ? curr + nums[i] : nums[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        HashMap<Character, Integer> m = new HashMap<>();
        char t[] = s1.toCharArray();
        char y[] = s2.toCharArray();

        for (char p : t)
            m.put(p, m.getOrDefault(p, 0) + 1);

        for (char u : y)
            m.put(u, m.getOrDefault(u, 0) - 1);


        for (char u : m.keySet()) {
            if (m.get(u) != 0)
                return false;
        }

        int countChange = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < t.length && index2 < y.length) {
            if (t[index1] != y[index2])
                countChange++;

            index1++;
            index2++;

        }

        if (countChange > 2)
            return false;


        return 2 > 1;

    }

//    Input: nums = [1,4,3,3,2]
//
//    Output: 2

    public static int longestMonotonicSubarray(int[] nums) {
        int increment = 1;
        int decrement = 1;
        int maxLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                increment++;
                decrement = 1;
            } else if (nums[i + 1] < nums[i]) {
                decrement++;
                increment = 1;
            } else {
                increment = 1;
                decrement = 1;
            }

            maxLength = Math.max(maxLength, Math.max(increment, decrement));
        }

        return maxLength;

    }

    public int lengthOfLastWord(String s) {

        String[] words = s.split("//s+");

        return words[words.length - 1].length();


    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }

    public boolean isUgly(int num) {

        for (int i = 2; i < 6 && num > 0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }


    public static boolean divideArray(int[] nums) {
        int countpair = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                countpair++;
                set.remove(i);

            }

            set.add(i);

        }

        System.out.println("value of set -->" + set);
        System.out.println("value of countpair -->" + countpair);
        return countpair == nums.length / 2 ? true : false;

    }


//    Input: nums = [1, 2, 3, 2, 2]
//    Output: 4
//    Explanation: The longest subarray is [2, 3, 2, 2].

    public static int longestSubarray(int[] a) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int longestLength = Integer.MIN_VALUE;
        int length = 0;


        for (int i = 0; i < a.length; i++) {
            if (m.size() <= 2) {
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
                length++;

                longestLength = Math.max(longestLength, length);


            } else {
                length = 0;
                m.clear();


                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
                length++;

            }


        }


        return longestLength;

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


    public int countLargestGroup(int n) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            int x = digsum(i);
            mpp.put(x, mpp.getOrDefault(x, 0) + 1);
            maxi = Math.max(maxi, mpp.get(x));
        }

        for (int val : mpp.values()) if (val == maxi) count++;
        return count;
    }

    private int digsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //    Input: nums = [2,3,1,1,4]
//    Output: true
//    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    public static boolean canJump(int[] nums) {
        int previous = 0;
        int next = 0;

        for (int i = 0; i < nums.length; i++) {

            int temp = previous + nums[i];

            previous = next;
            next = temp;


        }


        return false;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                long product = (long) nums1[i] * nums2[j];
                maxHeap.offer(product);
                if (maxHeap.size() > k) {
                    maxHeap.poll(); // Remove largest to keep smallest k elements
                }
            }
        }

        return maxHeap.peek();

    }


    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        long value = 0;
        long pow = 1;

        // Count all zeros
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (value + pow > k) {
                    continue; // Skip this '1' as it would exceed k
                }
                value += pow;
                ones++;
            }
            pow <<= 1;
            // Prevent pow from overflowing; if pow is beyond k, no more '1's can be added
            if (pow > k) {
                // Once pow exceeds k, further bits can't be added as their value is too large
                break;
            }
        }
        return zeros + ones;

    }


    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> m = new HashMap<>();


        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                m.put(sum, m.getOrDefault(sum, 0) + 1);
            }


        }

        int count = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                int sum = -(i + j);

                count = count + m.getOrDefault(sum, 0);


            }

        }

        return count;

    }

    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        System.out.println("value of interval -->" + res);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            System.out.println("interval last -->" + Arrays.toString(last));
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);

            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static int possibleStringCount(String word, int k) {
        HashMap<Character, Integer> m = new HashMap<>();

        char t[] = word.toCharArray();
        for (char y : t)
            m.put(y, m.getOrDefault(y, 0) + 1);

        int n = word.length();
        int count = n;


        for (int i = 1; i < t.length; i++) {
            if (t[i] != t[i - 1])
                count--;
        }

        return count;
    }


    public int trap(int[] arr) {
        int l = 0, r = arr.length - 1;
        int lmax = 0, rmax = 0, ans = 0;

        while (l < r) {
            lmax = Math.max(lmax, arr[l]);
            rmax = Math.max(rmax, arr[r]);

            if (lmax < rmax) {
                ans += lmax - arr[l];
                l++;
            } else {
                ans += rmax - arr[r];
                r--;
            }
        }
        return ans;
    }

    public static int removeDuplicates(int a[]) {
        int index = 1;

        for (int i : a) {
            if (i != a[index - 1]) {
                a[index] = i;
                index++;
            }
        }

        return index;
    }

    public static int subArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        int count = 0;
        m.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (m.containsKey(sum - k)) {
                count = count + m.get(sum - k);
            }

            m.put(sum, m.getOrDefault(sum, 0) + 1);

        }


        return count;
    }

    public String intToRoman(int num) {
        String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hrns[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String ths[] = {"", "M", "MM", "MMM"};

        return ths[num / 1000] + hrns[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();
        for (int i : nums1)
            set.add(i);

        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            ans[index] = i;
            index++;
        }

        return ans;


    }


    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;

    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    l.add(nums1[i]);
                    nums2[j] = -1; // used
                    break;
                }


            }
        }

        int result[] = new int[l.size()];

        for (int k = 0; k < result.length; k++) {
            result[k] = l.get(k);
        }

        return result;


    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!seen.contains(i)) {
                result.add(i);
            }
        }

        return result;

    }

    public int maximumLength(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num % 2 == 0) cnt1++;
            else cnt2++;
        }

        int eve = 0, odd = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                eve = Math.max(eve, odd + 1);
            else
                odd = Math.max(odd, eve + 1);
        }

        return Math.max(Math.max(cnt1, cnt2), Math.max(eve, odd));
    }


    //nums = [2,0,2,1,1,0]

    public static int[] getSortedFlag(int a[]) {
        int result[] = new int[a.length];
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int i : a) {
            if (i == 0)
                zero++;
            else if (i == 1)
                one++;
            else
                two++;

        }

        int index = 0;
        while (zero != 0) {
            result[index++] = 0;
            zero--;
        }
        while (one != 0) {
            result[index++] = 1;
            one--;
        }
        while (two != 0) {
            result[index++] = 2;
            two--;
        }

        return result;
    }


    public static int[] checkDNF(int[] a) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : a)
            p.offer(i);

        int index = 0;

        while (!p.isEmpty()) {
            a[index++] = p.poll();
        }

        return a;
    }

    public static void sortFourColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        int end = high;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low++, mid++);
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high--);
            } else if (arr[mid] == 3) {
                swap(arr, high, end--);
                if (arr[mid] != 2 && arr[mid] != 3) mid++;
            }
        }
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high--);
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int valueAfterKSeconds(int n, int k) {
        int[] sum = new int[n];
        Arrays.fill(sum, 1);
        while (k-- > 0)
            for (int i = 1; i < n; i++)
                sum[i] = (sum[i] + sum[i - 1]) % 1000000007;
        return sum[n - 1];

    }


    public int numEquivDominoPairs(int[][] dominoes) {
        // Array to store counts of each unique domino (no HashMap needed!)
        int[] counts = new int[100];
        int result = 0;

        for (int[] domino : dominoes) {
            // Normalize the domino representation (smaller value first)
            int val1 = domino[0];
            int val2 = domino[1];

            // Math trick: create a unique key for this domino
            int key = Math.min(val1, val2) * 10 + Math.max(val1, val2);

            // Add the count of pairs we can form with existing dominoes
            result += counts[key];

            // Increment the count for this domino
            counts[key]++;
        }

        // Final result - all pairs found in O(n) time! 🔥
        return result;


    }

    public static int getSecondHighestFreqLinear(int[] a) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i : a)
            m.put(i, m.getOrDefault(i, 0) + 1);

        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int l : m.keySet()) {
            p.offer(m.get(l));

            if (p.size() > 2)
                p.poll();
        }

        int secondHieghest = 0;

        if(!p.isEmpty())
         secondHieghest = p.peek();

        for (Map.Entry<Integer, Integer> k : m.entrySet()) {
            if (k.getValue() == secondHieghest)
                return k.getKey();
        }

        return 0;
    }


    public boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s, start + 1, end) ||
                        isPalindrome(s, start, end - 1);
            }


        }

        return true;

    }

    public boolean isPalindrome(String f, int left, int right) {
        while (left < right) {
            if (f.charAt(left++) != f.charAt(right--))
                return false;
        }
        return true;

    }

    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int odd = 0, even = 1; // initial even prefix sum count (sum = 0)
        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                count = (count + odd) % MOD;
                even++;
            } else
            {
                count = (count + even) % MOD;
                odd++;
            }
        }
        return count;
    }


    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> h = new HashSet<>();

        for (int i : arr)
            h.add(i);

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int prev = arr[j];
                int curr = arr[i] + arr[j];
                int len = 2;

                while (h.contains(curr)) {
                    int temp = curr;
                    curr = curr + prev;
                    prev = temp;

                    max = Math.max(max, ++len);

                }


            }


        }


        return max;
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = Arrays.copyOf(nums, nums.length);
        HashMap<Integer, Integer> m = new HashMap<>();

        Arrays.sort(result);

        for (int i = 0; i < nums.length; i++)
            m.putIfAbsent(result[i], i);


        int res[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = m.get(nums[i]);
        }

        return res;


    }

    public int[] arrayRankTransform(int[] arr) {
        int result[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        HashMap<Integer, Integer> m = new HashMap<>();
        int rank = 1;


        for (int i = 0; i < result.length; i++) {
            if (!m.containsKey(result[i]))
                m.put(result[i], rank++);

        }

        int res[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = m.get(arr[i]);
        }

        return res;


    }


    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int degree = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (!first.containsKey(num)) {
                first.put(num, i); // store first occurrence
            }

            if (freq.get(num) > degree) {
                degree = freq.get(num);
                minLength = i - first.get(num) + 1;
            } else if (freq.get(num) == degree) {
                minLength = Math.min(minLength, i - first.get(num) + 1);
            }
        }

        return minLength;

    }


    // Given the input lists `𝗽𝗿𝗲𝘀𝗲𝗻𝘁 = [𝟱, 𝟰, 𝟲, 𝟮, 𝟯]`, `𝗳𝘂𝘁𝘂𝗿𝗲 = [𝟴, 𝟱, 𝟰, 𝟯, 𝟱]`, and a budget of 10, what is the maximum profit you can achieve? For example, you can buy stocks at indices 0, 3, and 4 for a total of 5 + 2 + 3 = 10 and sell them the next year for 8 + 3 + 5 = 16, resulting in a profit of 6.

    public int tribonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;


        int first = 0;
        int second = 1;
        int third = 1;


        for (int i = 3; i <= n; i++) {
            int total = first + second + third;
            first = second;
            second = third;
            third = total;
        }

        return third;
    }


    public int maxLength(int[] nums) {
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            int curProd = nums[i];
            int curGcd = nums[i];
            int curLcm = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                curProd = curProd * nums[j];
                curGcd = gcd(curGcd, nums[j]);
                curLcm = lcm(curLcm, nums[j]);

                if (curProd == curLcm * curGcd)
                    res = Math.max(res, j - i + 1);

            }

        }

        return res;

    }

    public static int lcm(int a, int b) {
        int result = a * b / gcd(a, b);
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;

        }
        return a;

    }

    public static int gcdOfAllNumbers(int[] a) {
        int result = a[0];

        for (int i = 1; i < a.length; i++) {
            result = gcd(result, a[i]);
        }
        return result;
    }

    public static int lcmOfAllNumbers(int a[]) {
        int result = a[0];

        for (int i = 1; i < a.length; i++) {
            result = lcm(result, a[i]);
        }
        return result;
    }


    public void duplicateZeros(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                a[index++] = arr[i];
                a[index++] = 0;
            } else
                a[index++] = arr[i];
        }

    }


    public int findLengthOfLCIS(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            while (i < nums.length - 1 && nums[i] < nums[i + 1]) {

                count++;
                i++;

            }


            if (max < count) {
                max = count;
            }


        }

        return max;
    }

    public static int findLengthOfLCIS1(int[] nums) {
        return dfs(nums, 0, 0, 0);
    }

    public static int dfs(int[] nums, int max, int curr, int maxl) {
        if (curr == nums.length)
            return Math.max(max, curr);

        if (curr == 0 || nums[curr] < nums[curr + 1])
            return dfs(nums, max + 1, curr + 1, Math.max(curr, maxl));

        else {
            return dfs(nums, 1, curr + 1, Math.max(curr, maxl));
        }
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        Integer[] result = new Integer[nums.length];
        int j = 0;
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
            result[j++] = i;
        }

        Arrays.sort(result, (a, b) ->
        {
            if (m.get(a) != m.get(b)) {
                return m.get(a) - m.get(b);
            } else
                return b - a;

        });

        int[] out = new int[nums.length];
        int k = 0;
        for (int i : result) {
            out[k++] = i;
        }
        return out;
    }


    public boolean circularArrayLoop(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {

                int slow = i;
                int fast = i;
                boolean isForward = nums[i] >= 0;
                while (true) {
                    slow = findNextIndex(nums, isForward, slow);
                    if (slow == -1) {
                        break;
                    }
                    fast = findNextIndex(nums, isForward, fast);
                    if (fast == -1) {
                        break;
                    }
                    fast = findNextIndex(nums, isForward, fast);
                    if (fast == -1) {
                        break;
                    }
                    if (fast == slow) {
                        return true;
                    }
                    visited[slow] = true;
                    visited[fast] = true;
                }
            }
        }
        return false;
    }

    int findNextIndex(int[] arr, boolean isForward, int curr) {
        boolean direction = arr[curr] >= 0;
        if (direction != isForward) {
            return -1;
        }
        int nextIndex = (arr[curr] + curr) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length;
        }
        if (nextIndex == curr) {
            return -1;
        }
        return nextIndex;
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Add valid candidate j (i - j <= r)
            if (i - l >= 0) {
                int j = i - l;
                // Maintain increasing order of prefix[j]
                while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[j]) {
                    dq.pollLast();
                }
                dq.offerLast(j);
            }

            // Remove j if window is too large (i - j > r)
            while (!dq.isEmpty() && dq.peekFirst() < i - r) {
                dq.pollFirst();
            }

            // Compute answer
            if (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] > 0) {
                ans = Math.min(ans, prefix[i] - prefix[dq.peekFirst()]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //    Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//    Output: 91
    //
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int max = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize > boxTypes[i][0]) {
                max = max + boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
            } else {
                while (truckSize-- > 0) {
                    max = max + boxTypes[i][1];
                }

            }

        }


        return max;
    }

    public static int[] getSum(int a[], int target) {
        Arrays.sort(a);
        int start = 0;
        int end = a.length - 1;
        int mindiff = Integer.MAX_VALUE;
        int result[] = new int[2];

        while (start < end) {
            int sum = a[start] + a[end];
            int diff = target - sum;

            if (diff < mindiff) {
                mindiff = diff;
                result[0] = a[start];
                result[1] = a[end];
            }
            if (sum < target)
                start++;

            else
                end--;


        }
        return result;

    }


    public long splitArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        long lsum = 0, rsum = 0;
        // strictly increasing from left
        while (l < n - 1 && arr[l] < arr[l + 1]) {
            lsum += arr[l];
            l++;
        }
        // strictly decreasing from right
        while (r > 0 && arr[r - 1] > arr[r]) {
            rsum += arr[r];
            r--;
        }
        // single peak element
        if (l == r) {
            long option1 = Math.abs((lsum + arr[l]) - rsum);
            long option2 = Math.abs(lsum - (rsum + arr[l]));

            return Math.min(option1, option2);
        }
        // flat peak with two equal middle elements
        else if (arr[l] == arr[r] && r - l == 1) {
            long option1 = Math.abs((lsum - rsum));
            return option1;
        }
        // invalid mountain
        else return -1;
    }

    public static int[] moveK(int a[], int k) {

        int left = 0;
        int right = a.length - 1;
        int idx = 0;
        while (left < right) {
            if (a[left] != k)
                a[left++] = a[idx++];

            else
                a[right++] = a[idx++];


        }
        return a;
    }


//    Input: height = [1,8,6,2,5,4,8,3,7]
//    Output: 49
    public int maxArea(int[] height)
    {
        int start = 0;
        int end = height.length  - 1;
        int maxArea = Integer.MIN_VALUE;

        while(start < end)
        {
            int length = end - start ;
           int maxLength = length * Math.min(height[start],height[end]);
            maxArea = Math.max(maxArea,maxLength * maxLength);

            if(height[start] < height[end])
                start ++;

            else
                end--;


        }

return maxArea;

    }

   }
