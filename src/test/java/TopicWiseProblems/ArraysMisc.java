package TopicWiseProblems;

import java.math.BigInteger;
import java.util.*;

public class ArraysMisc {

    public static void main(String a[])
    {
      //  System.out.println(removeKdigits("1432219",3));

       // maxArea(new int []{1,8,6,2,5,4,8,3,7});

      //  moveZeroes(new int []{0,1,0,3,12});

       // maxProfit(new int []{7,1,5,3,6,4});
//        reversePrefix("abcdefd",'d');
//
//        findMaxAverage(new int []{1,12,-5,-6,50,3},4);


       // System.out.println(cons(new int []{5, 6, 7, 8, 9, 9}));

        //System.out.println(jump(new int []{2,3,0,1,4}));
     //   System.out.println(missingNum(new int []{1, 2, 3, 4, 6, 7, 8, 9, 10}));

      //  System.out.println(Arrays.toString(searchRange(new int []{1,4},4)));

        ///  System.out.println(Arrays.toString(rotate(new int []{-1,-100,3,99},2)));

      //  rotate1(new int []{-1,-100,3,99},2);

        //rotate3(new int []{-1,-100,3,99},2);

       // System.out.println(longestValidParentheses("{[]{}"));

       // System.out.println(longestValidParentheses1("(()"));
       // weekPrint();
       // leapYear(2024);

       // System.out.println(maxSubArray(new int []{-2,-1}));

       // System.out.println(genearte3(1));

      //  combinationSum(new int []{2,3,6,7},7);

      //  combinationSum2(new int []{10,1,2,7,6,1,5},8);

       // System.out.println(maxArea1(new int []{1,1}));

       // System.out.println(countPrimes(10));

       // System.out.println(Arrays.toString(plusOne(new int []{9,8,7,6,5,4,3,2,1,0})));


        //combine(1,1);

        //System.out.println(permute(new int []{1,2,3}));

        //System.out.println(groupAnagrams(new String []{"eat","tea","tan","ate","nat","bat"}));

       // System.out.println( getSubset(new int []{1,2,3}));

        //  System.out.println( climbStairs(3));

      //  System.out.println(longestCommonPrefix(new String []{"abab","aba","abc"}));

       // System.out.println(permuteUnique(new int []{1,1,2}));

       // System.out.println(reverseWords("  hello world  "));

      //  System.out.println(fourSum(new int []{2,2,2,2,2},8));

      //  System.out.println( getFour(new int []{1,0,-1,0,-2,2},0));

       // palindromeInteger(321);

       // System.out.println(balancedString("QQQW"));

      //  System.out.println(fib(2));

       // System.out.println(coinChange(new int []{1,2,5},11));

       // System.out.println( reverse(1534236469));

     //   System.out.println(removeDuplicates(new int []{0,0,1,1,1,2,2,3,3,4}));

        //System.out.println( removeDuplicatesss(new int []{0,0,1,1,1,2,2,3,3,4}));

        //System.out.println(longestMountain(new int []{2,1,4,7,3,2,5}));

       // System.out.println(Arrays.toString(productExceptSelf(new int []{1,2,3,4})));

       // System.out.println(numJewelsInStones("z","ZZ"));

        //System.out.println(lemonadeChange(new int []{5,5,10,10,20}));


        //rotatetheArray(new int []{1,2,3,4,5,6,7});

       // System.out.println(generate3(5));

      //  starProgram(5);

     //  print();

       // System.out.println(countFrequence());

        //System.out.println(Arrays.toString(checkDuplicate()));

       // System.out.println(canPick(new int []{3, 2, 7, 10}));

        System.out.println(longestSubstring("ababbc",2));

    }
//    Input: num = "1432219", k = 33
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//    Example 2:
//
//    Input: num = "10200", k = 1
//    Output: "200"
//    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//

//    public static String removeKdigits(String num, int k)
//    {
//        int start = 0;
//        int end  = 0;
//        ArrayList<Character> m
//
//        while(end < num.length())
//        {
//
//            if(end - start + 1 < k)
//                end++;
//
//            else if (end - start + 1 == k)
//            {
//
//
//
//
//
//            }
//
//
//
//        }
//




    //}



//    Input: height = [1,8,6,2,5,4,8,3,7]
//            Output: 49
//            Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
//            In this case, the max area of water (blue section) the container can contain is 49.


    public static void maxArea(int[] height)
    {
          int start  = 0;
          int end  = height.length -1 ;
          int max = Integer.MIN_VALUE;

          while (start < end)
          {

              max = Math.max((end - start) * Math.min(height[end],height[start]),max);
              System.out.println("value of max -->"+max);

              if (height[start] < height[end] )
                  start++;
              else
                  end--;


          }

        System.out.println("max area of water --> "+max);
    }

//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
  /*  public static int maxProfit(int[] prices)
    {
                        

    }*/

//
//    Input: nums = [0,1,0,3,12]
//    Output: [1,3,12,0,0]

    public static void moveZeroes(int[] nums)
    {
            int temp[] = new int[nums.length];
            int j = 0;

            for(int i = 0 ; i < nums.length ;i++)
            {
                if(nums[i] != 0)
                {
                    temp[j++] = nums[i];
                }

            }



            for(int i = 0 ; i < nums.length - j ; i++)
            {
                temp[j++] = 0;
            }

            for(int u : temp)
            {
                System.out.println(" "+u);
            }

            nums = Arrays.copyOf(temp,nums.length);
        for(int u : nums)
        {
            System.out.println(" "+u);
        }

        }

    //    Input: prices = [7,1,5,3,6,4]
//    Output: 5
    public static void maxProfit(int[] prices)
    {

        int currentPrice = prices[0];
        int maxPrice = 0;

        for(int i = 1 ; i < prices.length ; i++)
        {
            if(prices[i] > currentPrice )
            {
                maxPrice = Math.max(maxPrice,prices[i] - currentPrice );

            }
            else
                currentPrice = prices[i];
        }


        System.out.println("max profit --->"+maxPrice);
    }



//    public int missingNumber(int[] nums) {
//        int max = (nums.length *(nums.length - 1))/2;
//
//        int sum =  0 ;
//        for(int i = 0 ; i < nums.length ; i++)
//        {
//            sum = sum + nums[i];
//        }
//        return max - sum;
//    }


//    It contains a minimum of 3 characters.
//    It contains only digits (0-9), and English letters (uppercase and lowercase).
//    It includes at least one vowel.
//    It includes at least one consonant.


//    public boolean isValid(String word) {
//
//        if(word.length() >= 3 && word.contains())
//
//    }


//    Input: word = "abcdefd", ch = "d"
//    Output: "dcbaefd"
public static void reversePrefix(String word, char ch)
{
    int index= -1;

    for(int i = 0 ; i < word.length() ;i++)
    {
        if(word.charAt(i) == ch)
            index = i ;
    }

    String subString = word.substring(0,index);

    int start = 0;
    int end = index;
    char t [] =subString.toCharArray();
    while(start <= end)
    {
       char u = t[start];
       t[start] = t[end];
       t[end] = u;
    }

    for(int i = index + 1 ; i < word.length();i++)
    {
        subString = subString + word.charAt(i);
    }

    System.out.println("new substring-->"+subString);

}

//    Input: nums = [1,12,-5,-6,50,3], k = 4
//    Output: 12.75000
//    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

    public static void findMaxAverage(int[] nums, int k)
    {
        int sum = 0 ;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length  ;i++)
        {
            sum = sum + nums[i];

            if (sum < 0)
                sum = 0;

            max = Math.max(sum/4,max);
        }

        System.out.println("maximum sum value -->"+max);

    }
    //    Input: nums = [3,2,3]
//    Output: 3
// nums = [2,2,1,1,1,2,2]
    public static int majorityElement(int[] nums)
    {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i : nums)
        {
            if(m.containsKey(i))
                m.put(i,m.get(i) + 1);
            else
                m.put(i,1);

        }

        for(int u : m.keySet())
        {
            if( m.get(u) > nums.length / 2)
                return u;
        }

        return 0;
    }


//    Input: s = "   fly me   to   the moon  "
//    Output: 4

    public static void mergeTwoSortdArray(int a[],int b[])
    {

        int aLength= a.length;
        int bLength = b.length;
        int cLength[] = new int [aLength + bLength];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < aLength && j < bLength)
        {
            if(a[i] < b[j])
                cLength[k++] = a[i++];

            else
                cLength[k++] = b[j++];

        }

        while(i < aLength)
            cLength[k++] = a[i++];

        while(j < bLength)
            cLength[k++] = b[j++];


        for(int h : cLength)
            System.out.print(" "+h);


    }


    public static void getCentury(int i )
    {
        if(i < 0 )
            System.out.println("invalid year");
        else if (i < 100)
            System.out.println(" 1 century");
        else if (i % 100 == 0)
            System.out.println(i / 100 + " century");
        else
            System.out.println(i / 100 + 1 + " century");

    }
    // a= {1,2,3,1,2,1}

    public static void getCommonElements(int a[],int b[],int c[])
    {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0 ,j = 0,k= 0;

        while (i < a.length && j < b.length && k < c.length)
        {
            if( a[i] == b[j] && b[j] == c[k]) {
                System.out.println(a[i]);
                i++;
                j++;
                k++;
            }
            else if (a[i] < b[j])
                i++;

            else if (b[j] < c[k])
                j++;

            else
                k++;
        }

    }
    public static void findSecondLargest(int a[])
    {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0 ; i < a.length ; i++) {
            if (a[i] > max) {
                secondMax = max;
                max = a[i];
            }
            else if( a[i] > secondMax && a[i] != max)
                secondMax = a[i];
        }

        System.out.println("second max number-->"+secondMax);
    }


    public static void secondSmallestNumber(int a[])
    {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int num : a)
        {
            if( num < min)
            {
                secondMin = min;
                min = num;
            }
            else if ( num < secondMin && num != min)
            {
                secondMin = num;
            }

        }

        System.out.println("second smallest number -->"+secondMin);

    }


    public static void printPattern()
    {
        for(int i = 0 ; i < 5 ; i++)
        {
            for(int j = 0 ; j <= i ; j++)
            {
                System.out.print("*");

            }
            System.out.println();
        }
    }


    // string  i am java developer i am proud of it

    public static void getOccurence(String s)
    {
        String [] d = s.split(" ");
        HashMap<String,Integer> m = new HashMap<>();
        for(String f : d)
        {
            if(m.containsKey(f))
                m.put(f,m.get(f) + 1);
            else
                m.put(f,1);
        }

        System.out.println("value of map -->" + m);

    }


    public static void getAveragePrime(int s)
    {
        int count = 0;
        int sum = 0;

        for(int i = 0 ; i <= s ; i++)
        {
            System.out.println("prime-->"+getPrimeNumber(i));
            sum = sum + getPrimeNumber(i);
        }
        System.out.println("avreage sum -->"+sum);
    }

    // 30
    public static int getPrimeNumber(int a)
    {
        if( a < 2)
            return 0;

        for(int i = 2 ; i <= a/2 ;i++)
        {
            if(a % i == 0)
                return 0 ;

        }

        return a;

    }


//    reverse("ab89c") ➞ "cb89a"
//
//    reverse("jkl5mn923o") ➞ "onm5lk923j"
//
//    reverse("123a45") ➞ "123a45"

    public static String reverse(String str)
    {
        int start = 0 ;
        int end = str.length() - 1;

        char c[] =str.toCharArray();


        while(start < end)
        {
            if(Character.isAlphabetic(c[start]) && Character.isAlphabetic(c[end]))
            {

                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
            if(Character.isDigit(c[start]))
                start++;

            if(Character.isDigit(c[end]))
                end--;


        }



        return String.valueOf(c);

    }


//    word_rank("The quick brown fox.") ➞ "brown"
//
//    word_rank("Nancy is very pretty.") ➞ "pretty"
//
//    word_rank("Check back tomorrow, man!") ➞ "tomorrow"
//
//    word_rank("Wednesday is hump day.") ➞ "Wednesday"


    public static String word_rank(String str)
    {

        HashMap<String,Integer> m = new HashMap<>();

        int max = Integer.MIN_VALUE;
        String t[] = str.split(" ");

        for(String u : t)
        {
            max = Math.max(max,String.valueOf(u).length());
            m.put(u,String.valueOf(u).length());
        }


        for(String f : m.keySet())
        {
            if(m.get(f) == max)
                return f;
        }


        return null;
    }


//    charAtPos([2, 4, 6, 8, 10], "even") ➞ [4, 8]
//// 4 & 8 occupy the 4th & 2nd positions from right.
//
//    charAtPos(['E', 'D', 'A', 'B', 'I', 'T'], "odd") ➞ ['D', 'B', 'T']
//// D, B and T occupy the 5th, 3rd and 1st positions from right.

//    public static Object[] charAtPos(Object[] arr, String par)
//    {
//        List<Object> a = new ArrayList<>();
//
//        for(int i = 0 ; i < arr.length ; i++) {
//            if (par.contains("even")) {
//                if(i % 2 == 1 && i > 0)
//                {
//                    a.add(arr[i]);
//                }
//            }
//
//            if(par.contains("odd"))
//            {
//                if(i % 2 == 1 && i > 0)
//                {
//                    a.add(arr[i]);
//                }
//            }
//
//        }
//
//        Object b[] = new Object[a.size()];
//        for(int i = 0 ; i < a.size() ; i++)
//        {
//            b[i] = a.get(i);
//        }
//
//        return b;
//    }
//

//    Example 1:
//
//    Input: s = "()"
//
//    Output: true
//
//    Example 2:
//
//    Input: s = "()[]{}"
//
//    Output: true
//
//    Example 3:
//
//    Input: s = "(]"
//
//    Output: false
//
//    Example 4:
//
//    Input: s = "([])"
//
//    Output: true


    public static boolean isValid(String s)
    {
        char t [] = s.toCharArray();
        Stack<Character> m = new Stack<>();

        for(char y : t)
        {
            if(y == '(')
                m.push(')');
            else if ( y == '{')
                m.push('}');
            else if (y == '[')
                m.push(']');

            else if (m.isEmpty() || m.pop() != y )
                return false;


        }

        return m.isEmpty();

    }



// [3,1,3,4,2]

//    cons([5, 1, 4, 3, 2]) ➞ true
//// Can be re-arranged to form [1, 2, 3, 4, 5]
//
//    cons([5, 1, 4, 3, 2, 8]) ➞ false
//
//    cons([5, 6, 7, 8, 9, 9]) ➞ false
//// 9 appears twice


    public static boolean cons(int[] arr)
    {
        for(int i = 0 ; i < arr.length - 1 ; i++)
        {
            if(arr[i] > arr[i + 1])
            {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp ;

                i = -1;
            }

        }

        for(int i = 1 ; i < arr.length ; i++ )
        {
            if(arr[i - 1]  + 1 != arr[ i ])
                return false;

        }

        return true;

    }

//    Input: nums = [2,3,1,1,4]
//    Output: true
//    Input: nums = [3,2,1,0,4]
//    Output: false

    // [2,0,0]
    //[3,0,8,2,0,0,1]
    public static boolean canJump(int[] nums)
    {

        if(nums.length < 2 || nums[0] >= nums.length - 1)
            return true;

        for(int i = 1 ; i < nums.length ; i++)
        {

            if(nums[0] >= 1)
            {
                if(nums[i] >= nums.length - i - 1 )
                    return true;

                else if (nums[i] < 1 && nums[i] < nums.length - i - 1 )
                    return false;


            }


        }
return false;
    }

    public static boolean canJump1(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
    //Input: nums = [2,3,1,1,4]
    // Input: nums = [2,3,0,1,4]
    public static int jump(int[] nums)
    {
        if(nums.length < 2 || nums[0] >= nums.length - 1)
            return 1;

        int steps = 0;
        int target = 0 ;

        for(int i = 0 ; i < nums.length ; i++)
        {
            target = Math.max(target, i + nums[i]);
            steps++;
            if(nums[i] >= nums.length - i - 1)
            {
                return steps;
            }
        }


        return 0 ;
    }

    //Input: nums = [2,3,1,1,4]
    // Input: nums = [2,3,0,1,4]
    public int jump1(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

//    missingNum([1, 2, 3, 4, 6, 7, 8, 9, 10]) ➞ 5
//
//    missingNum([7, 2, 3, 6, 5, 9, 1, 4, 8]) ➞ 10
//
//    missingNum([10, 5, 1, 2, 4, 6, 8, 3, 9]) ➞ 7

    public static int missingNum(int[] nums)
    {
        int n = nums.length + 1;

        int sum = 0 ;
        for(int i : nums)
        {
            sum += i;
        }

        return (n * (n + 1)) / 2 - sum;

    }

//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]
//    Example 2:
//
//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]

    public static int[] searchRange(int[] nums, int target)
    {
        if(nums.length == 1 && nums[0] == target)
            return new int []{0,0};
        else if(nums.length == 1 && nums[0] != target)
            return new int []{-1,-1};

        int targetArray[] = new int[2];

        int start = 0 ;
        int end = nums.length - 1;
        boolean startVisited = false;
        boolean endVisited = false;

        while(start <= end ) {
            if (nums[start] == target) {
                targetArray[0] = start;
                startVisited = true;
            }
            if (nums[end] == target) {
                targetArray[1] = end;
                endVisited = true;
            }

            if(startVisited == false)
                start++;

            if(endVisited == false)
                end--;

            if(startVisited == true && endVisited == true )
                break;
        }

        if(startVisited == false && endVisited == false)
            return new int[]{-1,-1};



        return targetArray;
    }

//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
public static int[] rotate(int[] nums, int k)
{


    for(int i = 0 ; i < k ; i++)
    {
        int last = nums[nums.length -1];
        for(int j = nums.length - 1 ; j > 0 ; j--)
        {

            nums[j] = nums[j - 1];
        }
        nums[0] = last;
    }

return nums;
}
// 1 2 3 4
    // 4 3 2 1
    // 3 4 1 2
    public static void rotate1(int[] nums, int k)
    {
      int n = nums.length;
      k = k % n;

      if(k > n )
          return ;

        reverse(nums,0 , n - 1);
        reverse(nums,0 , k - 1);
        reverse(nums,k  , n - 1);


        for(int i : nums)
            System.out.print( " "+ i );



    }
    public static void reverse(int []nums,int k , int n)
    {


        while(k < n)
        {
            int temp = nums[k];
            nums[k] = nums[n];
            nums[n] = temp;
            k++;
            n --;

        }



    }


    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        reverse1(nums, 0, n - 1);       // Step 1
        reverse1(nums, 0, k - 1);       // Step 2
        reverse1(nums, k, n - 1);       // Step 3

        for(int i : nums)
            System.out.print( " "+ i );
    }

    private static void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


//    Input: s = "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()".
//    Example 2:
//
//    Input: s = ")()())"
//    Output: 4
//    Explanation: The longest valid parentheses substring is "()()".
//    Example 3:
//
//    Input: s = ""
//    Output: 0

// ()[]{}
    // {{}}

    //)()()) // ()(() //(()
    public static int longestValidParentheses1(String s)
    {
        if(s.isEmpty() || s.length() < 2)
            return 0;

        int visited = 0;
        Stack<Character> vp = new Stack<>();
        char t[] = s.toCharArray();
        int longestParen = 0;
        int count = 0;
        for(char u : t)
        {
            if(u == '(' && vp.isEmpty()) {
                vp.push(')');

            }
            else if(u == '(') {
                vp.push(')');
                visited = 1;
            }
            else if(visited == 1 && vp.pop() == u) {
                visited = 0;
                count = count + 2;
            }
           else if ( !vp.isEmpty() && vp.pop() == u)
            {
                count = count + 2;
                longestParen = Math.max(longestParen,count);
            }
           else
               count = 0;

        }

        return longestParen;
    }
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }


    public static void weekPrint()
    {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if(i == 1)
            System.out.println("sunday");
        else if(i == 2)
            System.out.println("monday");
        else if(i == 3)
            System.out.println("tuesday");
        else if(i == 4)
            System.out.println("wednesday");
        else if(i == 5)
            System.out.println("thursday");
        else if(i == 6)
            System.out.println("friday");
        else if(i == 7)
            System.out.println("saturday");
        else
            System.out.println("No week days");

    }

    public static void leapYear(int y)
    {

        boolean isLeap = false;

        if (y % 4 == 0) {
                if (y % 100 != 0 || y % 400 == 0) {
                    isLeap = true;
                }
            }

            if(isLeap)
                System.out.println("leap year");
            else
                System.out.println("not a leap year");
    }

//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    public static int maxSubArray(int[] nums)
    {
        if(nums.length < 2)
            return nums[0];

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0 ; i < nums.length; i++)
        {
            sum = sum + nums[i];

            max = Math.max(max,sum);

            if(sum <  0 )
                sum = 0 ;

        }

return max;
    }

//    Input: numRows = 5
//    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    public List<List<Integer>> generate(int numRows)
    { List<List<Integer>> l = new ArrayList<> ();

        for(int i = 0 ; i < numRows ; i++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = 0 ; j <= i ; j++ )
            {
                if(j == 0 || j == i)
                    a.add(1);
            }
            l.add(i,a);

        }
        return  l;
    }

    public List<Integer> genRow(int r){
        int ans = 1;
        List<Integer> row = new ArrayList<>();
        row.add(ans);
        for(int col=1; col<r; col++){
            ans *= (r - col);
            ans /= col;
            row.add(ans);
        }

        return row;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            list.add(genRow(i));
        }

        return list;

    }



    public static List<Integer> genearte3(int num)
    {
        num = num + 1;
        for(int i = 1 ; i <= num  ; i++)
        {
            if(i == num )
                return printPattern(i);

        }

        return null;
    }

    public static List<Integer> printPattern(int r)
    {
        List<Integer> l = new ArrayList<Integer>();


        l.add(1);
        long a = 1;
        for(int i = 1 ; i < r ; i++)
        {
            a = a * (r - i);
            a = a / i;

            l.add((int)a);

        }
        return l;

    }





//    Input: height = [1,8,6,2,5,4,8,3,7]
//    Output: 49

    public static int maxArea1(int[] height)
    {
        int maxHieght = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;

        while(start < end)
        {
            int area = (end - start) * Math.min(height[start],height[end]);
            maxHieght = Math.max(maxHieght,area);

            if(height[start] < height[end])
            start++;

            else
            end--;

        }

return maxHieght;

    }

//    Input: n = 10
//    Output: 4
//    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//    Example 2:
//
//    Input: n = 0
//    Output: 0
//    Example 3:
//
//    Input: n = 1
//    Output: 0
    public static int countPrimes(int n)
    {

        int count = 0 ;

        for(int i = 2 ; i < n ; i++ )
        {
            boolean notPrime = true;
            for(int j = 3 ; j < i  ; j++)
            {

                if( j % 2 == 0 )
                    notPrime = false;

            }
            if(notPrime)
                count++;


        }

return count;
    }


//    Input: digits = [1,2,3]
//    Output: [1,2,4]
//    Explanation: The array represents the integer 123.
//    Incrementing by one gives 123 + 1 = 124.
//    Thus, the result should be [1,2,4].
//    Example 2:
//
//    Input: digits = [4,3,2,1]
//    Output: [4,3,2,2]
//    Explanation: The array represents the integer 4321.
//    Incrementing by one gives 4321 + 1 = 4322.
//    Thus, the result should be [4,3,2,2].
public static int[] plusOne(int[] digits)
{
   // String s = "";
//    for(int i : digits)
//    {
//        s= s + i;
//    }
//
//    long j = Long.parseLong(s) + 1;
//    char t[] = String.valueOf(j).toCharArray();
//    int [] u = new int[t.length];
//    for(int i = 0 ; i < u.length ; i++)
//    {
//         u[i] = Character.getNumericValue(t[i]);
//    }
//
//    return u;

    String s = "";
  for(int i : digits)
    {
        s= s + i;
    }

    BigInteger b = new BigInteger(s);
   BigInteger d=  b.add(BigInteger.valueOf(1));
    char t[] = String.valueOf(d).toCharArray();
    int [] u = new int[t.length];
    for(int i = 0 ; i < u.length ; i++)
    {
         u[i] = Character.getNumericValue(t[i]);
    }
    return u;

}
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }




//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String , List<String>> m =  new HashMap<>();

        List<List<String>> result = new ArrayList<>();
       for(String s : strs)
       {
         String sortedString = getSortedString(s);

         if(m.containsKey(sortedString))
             m.get(sortedString).add(s);

         else
         {
             List<String> l = new ArrayList<>();
             l.add(s);
             m.put(sortedString,l);

         }


       }

        for(String g : m.keySet())
        {
            result.add(m.get(g));
        }
return result;

    }

    public static String getSortedString(String word)
    {
        char t [] = word.toCharArray();
        Arrays.sort(t);
        return String.valueOf(t);

    }





//    Input: strs = ["flower","flow","flight"]
//    Output: "fl"
//    Example 2:
//
//    Input: strs = ["dog","racecar","car"]
//    Output: ""


    public static String longestCommonPrefix(String[] strs)
    {
       /* for(int i = 0 ; i < strs.length - 1 ; i++)
        {
            if(strs[i].length() > strs[i + 1].length())
            {
                String temp = strs[i];
                strs[i] = strs[i + 1];
                strs[i + 1 ] = temp ;

                i = - 1;
            }

        }*/
        Arrays.sort(strs);

        System.out.println(Arrays.toString(strs));

        String smallestLengthString = strs[0];

        String largestLengthString = strs[strs.length - 1];

        String prefix = "";

        for(int i = 0 ; i < smallestLengthString.length() ; i++ )
        {
            if(smallestLengthString.charAt(i) == largestLengthString.charAt(i))
            {
                prefix = prefix + smallestLengthString.charAt(i);
            }

            else
                break;

        }


return prefix;


    }




//    Input: word1 = "horse", word2 = "ros"
//    Output: 3
//    Explanation:
//    horse -> rorse (replace 'h' with 'r')
//    rorse -> rose (remove 'r')
//    rose -> ros (remove 'e')

//    Input: s = "the sky is blue"
//    Output: "blue is sky the"
//    Example 2:
//
//    Input: s = "  hello world  "
//    Output: "world hello"
    public static String reverseWords(String s)
    {
        String d[] = s.split( " ");

        int start = 0 ;
        int end = d.length - 1;

        while(start < end )
        {
            if(d[start] == " " && d[end] == " ")
            {
                start++;
                end--;
            }
            else if (d[start] == " ")
            start++;

            else if(d[end] ==" ")
                end--;

            else
            {
                String temp = d[start];
                d[start] = d[end];
                d[end] = temp;

                start++;
                end--;

            }
        }

        System.out.println("after -->"+Arrays.toString(d));
        String newString = "";
       for(String f :d )
       {
           newString =  newString + " " + f ;
       }

       return newString.trim().replaceAll("\\s+", " ");

    }




   public static List<List<Integer>> getFour(int nums[],int target)
   {
       List<List<Integer>> result = new ArrayList<>();
       for(int i = 0 ; i < nums.length - 3 ; i++)
       {
           for(int j = i + 1 ; j < nums.length - 2 ; j++)
           {
               for(int k = j + 1 ; k < nums.length - 1 ; k++)
               {
                   for(int l = k + 1 ; l < nums.length ; l++)
                   {
                       if(nums[i] + nums[j] +nums[k] +nums[l] == target)
                       {
                           result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                       }

                   }

               }

           }
       }

       return result;

   }


 // palindrome a integer using traditional logic
    //121
    public static void palindromeInteger(int a)
    {
       int originalNumber = a;
        int sum = 0 ;

        while(a != 0 )
        {

            int remainder  = a % 10 ;

            sum = sum * 10 + remainder;

            a = a/10;

        }


        if (sum == originalNumber )
            System.out.println("palindrome");

        else
            System.out.println("not palibdrome no");


    }

//    Input: s = "QWER"
//    Output: 0
//    Explanation: s is already balanced.
//    Example 2:
//
//    Input: s = "QQWE"
//    Output: 1
//    Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
//    Example 3:
//
//    Input: s = "QQQW"
//    Output: 2
//    Explanation: We can replace the first "QQ" to "ER".

    public static int balancedString(String s)
    {
        char t[] = s.toCharArray();

        HashMap<Character,Integer> j = new HashMap<>();
        j.put('Q',1);
        j.put('W',1);
        j.put('E',1);
        j.put('R',1);

        int count = 0 ;

        for(int i = 0 ; i < t.length ; i++)
        {
            if(j.containsKey(t[i]))
                j.put(t[i],j.get(t[i]) - 1);

        }

        for(char u : j.keySet())
        {
            if(j.get(u) > 0 )
                count++;

        }

        return count;
    }


    public static int fib(int n)
    {
        int first = 0 ;
        int second = 1 ;

        for(int i = 2 ; i < n ; i++)
        {
            int third = first + second;
            first = second;
            second = third;


        }

       return first + second;
    }

//    Example 1:
//
//    Input: coins = [1,2,5], amount = 11
//    Output: 3
//    Explanation: 11 = 5 + 5 + 1
//    Example 2:
//
//    Input: coins = [2], amount = 3
//    Output: -1
public static int minCoins = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount)
    {

     backtrackForCoin(coins,amount,0,0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }


   public static void backtrackForCoin(int[] coins, int amount,int count,int totalAmount)
   {
       if(totalAmount > amount)
           return;
       if(totalAmount  == amount)
       {
           minCoins = Math.min(minCoins,count);
           return;
       }


       for(int i = 0 ; i < coins.length ; i++)

       {
           backtrackForCoin(coins, amount , count + 1,totalAmount + coins[i]);

       }


   }
    public static int reverse(int x)
    {

        int sum = 0 ;

        while(x != 0 )
        {
            int remainder = x % 10 ;
            sum = sum * 10 + remainder;

            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;

            x = x/10;

        }

        if( sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE)
            return 0 ;

        else
            return sum;

    }

//1 1 2
    public static int removeDuplicates(int[] nums)
    {
        int originalNum [] = new int [nums.length];
        Arrays.fill(originalNum,'_');

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            if(nums[ i ] + 1 == nums [ i + 1]) {

                originalNum[i] = nums[i];

                if(i == nums.length - 2)
                    originalNum[i + 1] = nums[nums.length - 1];

            }


        }

       int count= 0 ;

        for(int i : originalNum)
        {
            if(i != '_')
                count++;
        }

        for(int j = 0 ; j < nums.length ; j++)
        {
            nums[j] = originalNum[j];
        }

        Arrays.sort(nums);
        for(int j = 0 ; j < nums.length ; j++)
        {
            if( nums[j] == 95)
                nums[j] = '_';
        }


        return count ;
    }
    public static int removeDuplicatesss(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return j;
    }

//    Input: arr = [2,1,4,7,3,2,5]
//    Output: 5
//    Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
//    Example 2:
//
//    Input: arr = [2,2,2]
//    Output: 0
//    Explanation: There is no mountain.


    public static int longestMountain(int[] arr)
    {

        int start = 1 ;
        int end = arr.length - 1;
        int count = 0 ;

        while(start < end)
        {

            if(arr[start - 1] < arr[start] && arr[start] > arr[start + 1])
            {

                int left = start;
                int right = start;

                while ( left > 0 && arr[ left - 1 ] < arr[left])
                    left-- ;

                while(right < end && arr[right] > arr[ right + 1 ] )
                    right++;


                int currentLength = right - left + 1;

                count = Math.max(count,currentLength);

                start = right;
            }
            else
                start++;

        }

        return count ;

    }


//    Input: nums = [1,2,3,4]
//    Output: [24,12,8,6]
//    Example 2:
//
//    Input: nums = [-1,1,0,-3,3]
//    Output: [0,0,9,0,0]

    public static int[] productExceptSelf(int[] nums)
    {
        int getProduct[] = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++) {
            int sum = 1;
            int j = 0;
            while (j < nums.length)
            {
                if (j != i) {
                    sum = sum * nums[j];
                }
                j++;
            }

            getProduct[i] = sum;

        }

      return getProduct;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }


//    Input: jewels = "aA", stones = "aAAbbbb"
//    Output: 3
//    Example 2:
//
//    Input: jewels = "z", stones = "ZZ"
//    Output: 0


    public static int numJewelsInStones(String jewels, String stones)
    {
        int totalGems = 0 ;
        HashMap<Character,Integer> m = new HashMap<>();
        char t[] = stones.toCharArray();

        for(char g : t)
        {
            if(m.containsKey(g))
                m.put(g,m.get(g) + 1);

            else
                m.put(g,1);

        }

        char jewelsAr [] = jewels.toCharArray();

        for(char y : jewelsAr)
        {
            if(m.containsKey(y))
                totalGems = totalGems + m.get(y);

        }


        return  totalGems;
    }
//    Input: bills = [5,5,5,10,20]
//    Output: true
//    Explanation:
//    From the first 3 customers, we collect three $5 bills in order.
//    From the fourth customer, we collect a $10 bill and give back a $5.
//    From the fifth customer, we give a $10 bill and a $5 bill.
//    Since all customers got correct change, we output true.
//    Input: bills = [5,5,10,10,20]
//    Output: false
public static int balance = 0 ;
    public static boolean lemonadeChange(int[] bills)
    {
         HashMap<Integer,Integer> m = new HashMap<>();
         m.put(5,0);
         m.put(10,0);
         m.put(20,0);



         for(int i = 0 ; i < bills.length ; i++)
         {
             if(m.containsKey(bills[i]))
             m.put(bills[i],m.get(bills[i]) + 1);


             if(bills[i] < 10)
             balance = balance + bills[i];

             else if(bills[i] >= 10)
             {
                 if(!check(m,bills[i]))
                     return false;
             }

         }


return true;

    }

    public static boolean check(HashMap<Integer,Integer> m,int amount)
    {


          for(int i : m.keySet())
          {

              if(amount / 5 == 1 && i == 5 && m.get(i) >= 0)
              {
                  amount = amount - m.get(i);
                  m.put(i,m.get(i) - 1);
                  if(m.get(i) < 0 )
                      return false;

                  else
                      balance = balance - m.get(i);
              }

              else if(amount / 5 == 2 && i == 10 && m.get(i) >= 0)
              {
                  amount = amount - m.get(i);
                  m.put(i,m.get(i) - 1);
                  if(m.get(i) < 0 )
                      return false;
                  else
                      balance = balance - m.get(i);

              }
              else if(amount / 5 == 4 && i == 20 && m.get(i) >= 0)
              {
                  amount = amount - m.get(i);
                  m.put(i,m.get(i) - 1);
                  if(m.get(i) < 0 )
                      return false;

                  else
                      balance = balance - m.get(i);
              }

          }

          return true;

    }

    public boolean lemonadeChanges(int[] bills) {
        int count5 = 0, count10 = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                count5++;
            }
            else if(bills[i]==10){
                if(count5>0){
                    count5--;
                    count10++;
                }
                else{
                    return false;
                }
            }
            else{
                if(count5>0 && count10>0){
                    count5--;
                    count10--;
                }
                else if(count5>2){
                    count5-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }


// rotate the array


    public static void rotatetheArray(int a[])
    {

        swap(a,0,a.length - 1);
        swap(a,0,2);
        swap(a,3,a.length - 1   );


        System.out.println(Arrays.toString(a));


    }
    public static void swap(int a[], int start ,int end)
    {
        while(start < end)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }

    }


//    Input: numRows = 5
//    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    public static List<List<Integer>> generate3(int numRows)
    {
        List<List<Integer>> l = new ArrayList<>();

        for(int i = 1 ; i <= numRows ; i++) {
            l.add(gen(i));
        }

return l;
    }

public static List<Integer> gen(int i )
{ //  1 2 1
    // 1 3 3 1
    int ans = 1;
    List<Integer> l = new ArrayList<>();
    l.add(ans);

    for(int k = 1 ; k < i ; k++)
    {
       ans = ans * ( i - k );
       ans = ans / k;
       l.add(ans);

    }

    return  l;

}


/*
*
* *
* * *
* * * *
* * * * *
*  */

    public static void starProgram(int r)
    {
        for(int i = r ; i >= 0 ; i--)
        {
            for(int j = i  ; j >= 0 ; j--)
            {
                System.out.print("* ");

            }
            System.out.println();

        }


    }

//                      *
//                   *     *
//                 *    *   *
//               *   *   *   *


    public static void print()
    {
        int index = 1;

        for(int i = 1 ; i <= 5 ; i++ )
        {
            for(int k = 5 - i  ; k > 0 ; k--)
            {
                System.out.print("  ");
            }

            for(int j = 1 ; j <= i ; j++)
            {


                System.out.print(" "+index++ +" ");

            }

            System.out.println();

        }

    }



    public static HashMap<Integer,Integer> countFrequence()
    {
        int a[] = {1,2,3,4,2,3,4};

        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i = 0 ; i < a.length ; i++)
        {
            if(m.containsKey(a[i]))
            {
                m.put(a[i],m.get(a[i]) + 1);
            }
            else
                m.put(a[i],1);
        }

        return m;

    }

    public static int [] checkDuplicate()
    {
        int a[] = {2,3,4,6,1,2,4};

        HashSet<Integer> h = new HashSet<>();

        for(int i = 0 ; i < a.length ; i++)
        {
            h.add(a[i]);
        }

        int result [] = new int [h.size()];

       Iterator<Integer> it = h.iterator();
       int idx = 0;

       while(it.hasNext())
       {
           result[idx] = it.next();
           idx++;
       }

        return result;

    }



    public int numIslands(char[][] grid)
    {
        if(grid.length == 0 || grid == null )
             return 0 ;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int dir[][] ={{0,1},{1,0},{-1,0},{0,-1}};

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;

                    Queue<int[]> node = new LinkedList<>();
                    node.offer(new int[]{i,j});
                    grid[i][j] ='0';


                    while(!node.isEmpty())
                    {
                        int []cell = node.poll();

                        int nx = cell[0];
                        int ny = cell[1];

                        for(int t[] : dir) {
                            int x = t[0];
                            int y = t[1];

                       int x1 = x  + nx;
                       int y1 = y + ny;

                            if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == '1')
                            {
                                node.offer(new int []{nx,ny});
                                grid[x1][y1] = '0'; // mark visited
                            }

                        }





                    }


                }


            }

        }
        return count;
    }

//    Input: nums = [3, 2, 7, 10]
//    Output: 13
//    Explanation: Pick 3 + 10 = 13, cannot pick 7 because it is adjacent to 10.
//    vbnet
//    Copy code
//    Input: nums = [3, 2, 5, 10, 7]
//    Output: 15
//    Explanation: Pick 3 + 5 + 7 = 15 or 3 + 10 = 13, max is 15

    public static int canPick(int a[])
    {
        int next = 0 ;
        int current = 0;

        for(int i : a)
        {
            int temp = Math.max(i + current , next);
            current = next;
            next = temp;

        }

        return next;


    }


//    Input: nums = [3,2,1]
//    Output: 1
//    Explanation:
//    The first distinct maximum is 3.
//    The second distinct maximum is 2.
//    The third distinct maximum is 1.

    public static int getThirdMaximumNumber(int a[])
    {
        HashSet<Integer> h = new HashSet<>();

        for(int i : a)
            h.add(i);

       PriorityQueue<Integer> p = new PriorityQueue<>();

       for(int i : h)
       {
           p.offer(i);

           while(p.size() > 3)
               p.poll();

       }

        if(p.size() == 3)
            return p.peek();

        int max = 0;

         while(!p.isEmpty())
              max = p.poll();

         return max;
    }



    //System.out.println(longestSubstring("ababbc", 2));   // Output: 5 ("ababb")
    public static int longestSubstring(String a,int k)
    {
     int left = 0 ;
     HashMap<Character,Integer> m = new HashMap<>();
     int maxLength = 0;
     char t [] = a.toCharArray();

     for(int right = 0 ; right < a.length() ; right++)
     {
         m.put(t[right],m.getOrDefault(t[right], 0) + 1);

         while(m.size() > k)
         {
             int val = m.get(t[left]);
             val = val - 1;
             m.put(t[left],val);

             if(m.get(t[left]) <= 0)
                 m.remove(t[left]);

             left++;

         }

         maxLength  = Math.max(maxLength,right - left + 1);

     }

     return maxLength;
    }



    public static int longestSubstringAtK(String a,int k)
    {

       if(a.length() == 0 || k > a.length())
           return 0;

        int count [] = new int[26];

        for(char u : a.toCharArray())
             count[u - 'a']++;



        for(int i = 0 ; i < a.length() ; i++)
        {
          if(count[a.charAt(i) - 'a'] < k)
          {
              int left = longestSubstringAtK(a.substring(0,i),k);
              int right = longestSubstringAtK(a.substring(i + 1),k);

               return Math.max(left,right);

          }


        }

        return a.length();

    }

    public static int longestPalindrome(String s)
    {
        String max =s.substring(0,1);
        int maxLength = max.length();

        for(int i = 0 ; i < s.length() ; i++)
        {
            int left = sort(s,i,i);
            int right = sort(s, i, i + 1);

            if(left > right)
                maxLength = Math.max(maxLength,left);

            else
                maxLength = Math.max(maxLength,right);

        }

        return maxLength;

    }
    public static int sort(String s, int left , int right)
    {
        while(left >= 0 &&  right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        return s.substring(left + 1 , right ).length();
    }

   /* You are given an integer array nums.

    Split the array into exactly two subarrays, left and right, such that left is strictly increasing and right is strictly decreasing.

    Return the minimum possible absolute difference between the sums of left and right. If no valid split exists, return -1.



    Example 1:

    Input: nums = [1,3,2]

    Output: 2*/


//    Input: nums = [1,2,4,3]
//
//    Output: 4

    public static int getArray(int a[])
    {
        int l = 0;
        int r = a.length - 1;
        int lsum = 0;
        int rsum = 0;

        while(l < a.length - 1 && a[l] < a[l  + 1]) {
            lsum += a[l];
            l++;
        }
        while(r > 0 && a[r] > a[r - 1])
        {
            rsum += a[r];
            r--;
        }

        // peak elements
         if(l == r)
         {
             int i = Math.abs((lsum + a[l]) - rsum);
             int j = Math.abs(lsum - (rsum + a[l]));

             return Math.min(i,j);
         }

         else if(a[l] == a[r] && r - l == 1)
         {
             int i = Math.abs(lsum - rsum);

             return i;
         }

         else
             return -1;

    }


}







