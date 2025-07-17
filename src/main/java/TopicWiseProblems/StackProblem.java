package org.example;


import java.util.*;

public class StackProblem {
    //    plaintext
//    Copy code
//    Input: [[1,3], [2,6], [8,10], [15,18]]
//    Output: [[1,6], [8,10], [15,18]]

    public StackProblem() {
    }

    int start = 0;
    int end = 0;

    public StackProblem(int start, int end) {
        this.start = start;
        this.end = end;

    }

    public static void main(String n[]) {
//       StackProblem a[] = new StackProblem[4];
//      a[1] = new StackProblem(1,3);
//      a[0] = new StackProblem(2,6);
//      a[3] = new StackProblem(8,10);
//      a[2] = new StackProblem(15,18);
//
//      interval(a);

//     // System.out.println(nonRepeating("loveleetcode"));
//
//     // System.out.println(missingLetter(new String []{"m", "o"}));
//
//      //System.out.println(luckySeven(new int []{2, 4, 3, 8, 9, 1}));
//
//  //    System.out.println(luckySeven1(new int []{2, 4, 3, 8, 9, 1}));
//
//     // System.out.println(secondLargestNumber(new int []{10,20,15,3,5,1,2}));
//
//      //System.out.println(isDisarium(135));
//
//      System.out.println(isValid("(]"));

        // System.out.println(isValid("{[]}"));

        // System.out.println(checkValidString("(*)"));

        //  System.out.println(nextGreatestLetter(new char[]{'x','x','y','y'},'z'));

        // System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));

        // System.out.println(nextGreaterToRight(new int []{6,2,3,8}));

       // System.out.println(nearestSamllerToRight(new int[]{6, 2, 3, 8}));

        System.out.println(nextSmalletToRight(new int[]{6, 2, 3, 8} ));
    }

    public static void interval(StackProblem arr[]) {
        Arrays.sort(arr, new Comparator<StackProblem>() {
            @Override
            public int compare(StackProblem o1, StackProblem o2) {

                return o1.start - o2.start;

            }


        });

        for (StackProblem i : arr)
            System.out.println("m" + " " + i.start + " " + i.end);

//    1 3
//    2 6
//    8 10
//    15 18


        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index].end >= arr[i].start) {
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            } else {
                index++;
                arr[index] = arr[i];
            }

        }

        for (int i = 0; i <= index; i++) {
            System.out.println(" " + arr[i].start + " " + arr[i].end);

        }

    }

    // s = "loveleetcode"

    public static int nonRepeating(String s) {
        LinkedHashMap<Character, Integer> m = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i)))
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);

            else
                m.put(s.charAt(i), 1);

        }


        for (char i : m.keySet()) {
            if (m.get(i) == 1) {
                for (int k = 0; k < s.length(); k++) {
                    if (i == s.charAt(k)) {
                        return k;
                    }
                }
            }
        }

        return -1;
    }


//    missingLetter(["a", "b", "c", "e", "f", "g"]) ➞ "d"
//
//    missingLetter(["O", "Q", "R", "S"]) ➞ "P"
//
//    missingLetter(["t", "u", "v", "w", "x", "z"]) ➞ "y"
//
//    missingLetter(["m", "o"]) ➞ "n"


    public static String missingLetter(String[] arr) {

        int character = 0;
        for (int i = 1; i < arr.length; i++) {


            int a = (int) arr[i - 1].charAt(0);
            int b = (int) arr[i].charAt(0);
            if (a + 1 != b) {
                character = (int) arr[i].charAt(0);

                character = character - 1;
            }

        }

        char t = (char) character;

        return String.valueOf(t);

    }

//    luckySeven([2, 4, 3, 8, 9, 1]) ➞ true
//
//    luckySeven([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) ➞ true
//
//    luckySeven([0, 0, 0, 2, 3]) ➞ false
//// You cannot repeat the same number to make 2 + 2 + 3 = 7
//
//    luckySeven([4,, 3]) ➞ false
// You need three different numbers.

    public static boolean luckySeven(int[] r) {
        if (r.length < 3)
            return false;

        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r.length; j++) {
                for (int k = 0; k < r.length; k++) {
                    if (i != j && j != k && k != i && r[i] + r[j] + r[k] == 7)
                        return true;

                }
            }
        }

        return false;
    }

    public static boolean luckySeven1(int[] r) {
        if (r.length < 3)
            return false;

        for (int i = 0; i < r.length; i++) {
            for (int j = i + 1; j < r.length; j++) {
                for (int k = j + 1; k < r.length; k++) {
                    if (r[i] + r[j] + r[k] == 7)
                        return true;

                }
            }
        }

        return false;
    }

    // second largest number
    // a[] = {3,5,1,2}

    public static int secondLargestNumber(int a[]) {
        int max = 0;
        int secondLargest = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                secondLargest = max;
                max = a[i];
            } else if (a[i] > secondLargest && a[i] != max)
                secondLargest = a[i];

        }

        return secondLargest;

    }

//    isDisarium(75) ➞ false
//// 7^1 + 5^2 = 7 + 25 = 32
//
//    isDisarium(135) ➞ true
//// 1^1 + 3^2 + 5^3 = 1 + 9 + 125 = 135
//
//    isDisarium(544) ➞ false
//
//    isDisarium(518) ➞ true


    public static boolean isDisarium(int n) {
        int resulted = 0;
        int k = 1;
        char t[] = String.valueOf(n).toCharArray();
        for (int i = 0; i < t.length; i++) {
            resulted = (int) (resulted + Math.pow(Character.getNumericValue(t[i]), k));
            k++;

        }

        if (resulted == n)
            return true;

        return false;
    }


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


    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length() < 2)
            return false;

        for (char t : s.toCharArray()) {
            if (t == '(')
                st.push(')');

            else if (t == '{')
                st.push('}');

            else if (t == '[')
                st.push(']');

            else if (st.isEmpty() || st.pop() != t)
                return false;

// {[]}
        }

        return st.isEmpty();
    }


//    xample 1:
//
//    Input: s = "()"
//    Output: true
//    Example 2:
//
//    Input: s = "(*)"
//    Output: true
//    Example 3:
//
//    Input: s = "(*))"
//    Output: true


    public static boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int countAsterisk = 0;

        char t[] = s.toCharArray();
        for (char y : t) {
            if (y == '(')
                st.push(')');
            else if (y == ')' && !st.isEmpty())
                st.pop();
            else if (y == '*') {
                countAsterisk++;
                continue;
            } else if (countAsterisk == 0 && st.isEmpty() && st.pop() != y)
                return false;

        }

        for (char u : st) {
            if (st.isEmpty() && countAsterisk > 0 || countAsterisk == 0)
                return true;

            if (!st.isEmpty() && countAsterisk != 0) {
                st.pop();
                countAsterisk--;
            }

        }


        return true;
    }


    // implement Queues from stack


    static Stack<Integer> input = new Stack<>();
    static Stack<Integer> output = new Stack<>();

    public static void push(int i) {
        input.push(i);

    }

    public static int pop() {
        peek();
        return output.pop();

    }

    public static int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }

        }
        return output.peek();

    }


    public static boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();

    }


    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if (k == len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }


    public static String removeDigits(String s, int k) {
        Stack<Character> st = new Stack<>();

        int length = s.length();

        if (length == k)
            return "0";


        int i = 0;

        while (i < length) {

            while (k > 0 && !st.empty() && st.peek() > s.charAt(i)) {
                st.pop();
                k--;
            }

            st.push(s.charAt(i));
            i++;

        }
        // for corner case 2222

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());

        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);


        return sb.toString();


    }


//    Input: letters = ["c","f","j"], target = "a"
//    Output: "c"
//    Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
//

    public static char nextGreatestLetter(char[] letters, char target) {
        Stack<Character> s = new Stack<>();
        for (char l : letters) {
            if (!s.isEmpty() && s.peek() > target && s.peek() < l)
                return s.peek();

            s.push(l);
        }

        return s.peek() > target ? s.peek() : letters[0];
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i : nums2) {
            while (!s.isEmpty() && s.peek() < i) {
                m.put(s.pop(), i);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            m.put(s.pop(), -1);

        }

        for (int i = 0; i < ans.length; i++) {

            ans[i] = m.get(nums1[i]);
        }

        return ans;
    }


//    Input: nums = [1,2,1]
//    Output: [2,-1,2]
//    Explanation: The first 1's next greater number is 2;
//    The number 2 can't find next greater number.
//    The second 1's next greater number needs to search circularly, which is also 2.

    public static int[] nextGreaterElements(int[] nums) {
        HashSet<Integer> m = new HashSet<>();

        for (int i : nums)
            m.add(i);

        Stack<Integer> s = new Stack<>();

        for (int i : nums) {

            int number = i + 1;

            if (m.contains(number))
                s.push(number);

            else
                s.push(-1);


        }
        System.out.println("value of stack -->" + s);

        int ans[] = new int[s.size()];

        List<Integer> k = new ArrayList<>(s);
        Collections.reverse(k);

        for (int i = 0; i < k.size(); i++) {
            ans[i] = k.get(i);
        }

        return ans;
    }

    public static ArrayList<Integer> nextGreaterToRight(int b[]) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
        Stack<Integer> s = new Stack<>();


        for (int i = b.length - 1; i >= 0; i--) {
            if (s.empty()) {
                a.add(-1);
            } else if (s.size() > 0 && s.peek() > b[i]) {
                a.add(s.peek());
            } else if (s.size() > 0 && s.peek() < b[i]) {
                while (s.size() > 0 && s.peek() <= b[i]) {
                    s.pop();
                }
                if (s.empty()) {
                    a.add(-1);
                } else {
                    a.add(s.peek());
                }
            }
            s.push(b[i]);

        }


        for (int i = a.size() - 1; i >= 0; i--) {
            e.add(a.get(i));
        }

        return e;
    }


    public static ArrayList<Integer> nearestSamllerToRight(int e[]) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        Stack<Integer> c = new Stack<>();

        for (int j = e.length - 1; j >= 0; j--) {
            if (c.isEmpty()) {
                a.add(-1);
            } else if (c.size() > 0 && c.peek() < e[j]) {
                a.add(c.peek());
            } else if (c.size() > 0 && c.peek() > e[j]) {
                while (c.size() > 0 && c.peek() > e[j]) {
                    c.pop();
                }
                if (c.isEmpty()) {
                    a.add(-1);
                } else {
                    c.add(c.peek());
                }
            }
            c.add(e[j]);
        }

        for (int i = a.size() - 1; i >= 0; i--) {
            b.add(a.get(i));
        }

        return b;
    }


    public static ArrayList<Integer> nextSmalletToRight(int a[])
    {
        ArrayList<Integer> reversed = new ArrayList<>();
        ArrayList<Integer> forward = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for(int i = a.length - 1 ; i >= 0 ; i--)
        {
            if(s.isEmpty())
                reversed.add(-1);

            else if (!s.isEmpty() && s.peek() < a[i])
                reversed.add(s.peek());

            else if(!s.isEmpty() && s.peek() > a[i])
            {
                while(!s.isEmpty() && s.peek() >= a[i])
                {
                    s.pop();
                }

                if(s.isEmpty())
                    reversed.add(-1);

                else
                    reversed.add(s.peek());

            }

            s.push(a[i]);

        }
        for(int i = reversed.size() - 1 ; i >= 0 ; i--)
        {
            forward.add(reversed.get(i));
        }

        return forward;

    }

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (visited.contains(s.charAt(i))) {
                continue;
            }

            while (!stack.isEmpty() && s.charAt(i) < stack.peek() && i < lastOccurrence.getOrDefault(stack.peek(), -1)) {
                visited.remove(stack.pop());
            }

            visited.add(s.charAt(i));
            stack.push(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }


    public int findLUSlength(String[] strs) {

        int longestLST = -1;

        for(int i = 0 ; i < strs.length - 1 ; i++)
        {
            if(strs[i].length() < strs[i + 1].length())
            {
                String s = strs[i];
                strs[i] = strs[i + 1];
                strs[i + 1] = s;

                i = -1;
            }

        }

        for(int i = 0 ; i < strs.length ; i++)
        {

            boolean isNotCommon = true;

            for(int j = 0 ; j < strs.length ; j++)
            {
                if( i != j && isSubsequence(strs[i],strs[j]))
                {
                    isNotCommon = false;
                    break;
                }
            }

            if(isNotCommon)
            {
                longestLST = Math.max(longestLST,strs[i].length());
            }






        }
        return longestLST;

    }

    public boolean isSubsequence(String a, String b)
    {
        int start = 0;
        int end = 0;

        while(start < a.length() && end < b.length())
        {

            if(a.charAt(start) == b.charAt(end))
                start++;

            end++;


        }

        return start == a.length();
    }
    public String reverseStr(String s, int k) {
        char t[] = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i = i + 2 * k) {
            if (n - i < k)
                reverse(t, i, n - 1);

            else
                reverse(t, i, i + k - 1);


        }
        return new String(t);
    }
        public void reverse(char t[],int start,int end)
        {
            while(start < end)
            {
                char temp = t[start];
                t[start] = t[end];
                t[end] = temp;
                start++;
                end--;
            }

        }

}

