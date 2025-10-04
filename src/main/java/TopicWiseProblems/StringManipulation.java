package TopicWiseProblems;

import java.util.*;
import java.util.regex.Pattern;

public class StringManipulation {

    public static void main(String a[]) {
        // System.out.println(breakPalindrome("a"));

        //   System.out.println(Arrays.toString(productArray(new int []{1,2,3,4})));

        // System.out.println(Arrays.toString(shortestToChar("loveleetcode",'e')));

        // System.out.println(maxPalindromes("fkn"));


        // System.out.println(longestPalindrome("cbbd"));

      // System.out.println(groupAnagrams(new String []{"eat","tea","tan","ate","nat","bat"}));

        //System.out.println(lengthOfLastWord("   fly me   to   the moon  "));

        //System.out.println(isPalindrome("0p"));

        //System.out.println(findTheDifference("abcd","abcde"));

       // System.out.println(wordPattern("abba","dog cat cat dog"));

     //   System.out.println(summaryRanges(new int []{0,1,2,4,5,7}));


       // System.out.println(clearDigits("cb34"));

      //  System.out.println(groupAnagrams1(new String []{"eat","tea","tan","ate","nat","bat"}));

        //countSegments("Hello, my name is John");

       // System.out.println(processStr("z*#"));

      //  System.out.println(solution(new String []{"is","valid","right"},"isValid"));

      //  System.out.println(checkSubsequenceCount("abcde",new String []{"aa","acd","abd","ace","bde"}));
        //System.out.println(isSubsequenceArr("abcde",new String []{"aa","acd","abd","ace","bde"}));
        //System.out.println(removeDigit("1231",'1'));

      //  System.out.println(characterFreq("vikasa","sakiv"));

       // System.out.println(fractionToDecimal(4,333));

        System.out.println(minimumOps("race"));
    }

    //    Input: palindrome = "abccba"
//    Output: "aaccba"
//    Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
    public static String breakPalindrome(String palindrome) {
        if (checkPalindrome(palindrome)) {
            char t[] = palindrome.toCharArray();
            for (int i = 0; i < palindrome.length() / 2; i++) {
                if (t[i] != 'a') {
                    t[i] = 'a';

                    return String.valueOf(t);

                }


            }

            t[t.length - 1] = 'b';
            return String.valueOf(t);


        } else
            return "";


    }

    public static boolean checkPalindrome(String p) {
        if (p.length() < 2)
            return false;

        char t[] = p.toCharArray();
        int start = 0;
        int end = p.length() - 1;


        while (start < end) {
            if (t[start] != t[end])
                return false;

            else {
                start++;
                end--;
            }

        }

        return true;
    }

    // 1 2 3 4 tokenization
    // 24 12 8 6
    // 1 2 6 24
    //

    public static int[] productArray(int a[]) {
        int n = a.length - 1;
        int left[] = new int[a.length];
        int right[] = new int[a.length];

        left[0] = 1;
        right[n] = 1;

        for (int i = 1; i < a.length; i++) {

            left[i] = a[i - 1] * left[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = a[i + 1] * right[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = left[i] * right[i];
        }


        return a;
    }

    //    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]
//    Explanation:
//    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//    The distinct triplets are [-1,0,1] and [-1,-1,2].
//    Input: s = "loveleetcode", c = "e"
//    Output: [3,2,1,0,1,0,0,1,2,2,1,0]
    public static int[] shortestToChar(String s, char c) {
        int response[] = new int[s.length()];

        int pos = -s.length();

        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i))
                pos = i;

            response[i] = Math.abs(pos - i);

        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (c == s.charAt(i))
                pos = i;

            response[i] = Math.min(response[i], Math.abs(pos - i));
        }


        return response;

    }

    public String gcdOfStrings(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    // 3 length palindromes
    public static int maxPalindromes(String s) {
        HashMap<Character, Integer> m = new HashMap<>();

        char t[] = s.toCharArray();

        for (char c : t) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int pairs = 0;
        for (int i : m.values()) {
            pairs = pairs + i / 2;
        }

        int total = s.length();

        return Math.min(pairs, total / 3);


    }

    //    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
//        Example 2:
//  JGSGJGSGJGSG
//    Input: s = "cbbd"
//    Output: "bb"
    public static String longestPalindrome(String s) {
        char t[] = s.toCharArray();
        int start = 0;
        int end = t.length - 1;

        String max = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String d = s.substring(i, j);

                if (isPalindromic(d) && d.length() > max.length())
                    max = d;

            }

        }

        return max;

    }

    public static boolean isPalindromic(String a) {
        char t[] = a.toCharArray();
        int start = 0;
        int end = t.length - 1;

        while (start < end) {
            if (t[start] != t[end])
                return false;

            else {

                start++;
                end--;
            }


        }

        return true;
    }

// expand from centre


    public String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


// String.substring(start, endExclusive) uses the end index as exclusive, so:
    // thats why s.substring(left + 1, right)
//    start = left + 1;
//    end = right - 1;


    public static String expandFromCenterQues(String a) {
        if (a.length() <= 1)
            return a;

        String maxString = a.substring(0, 1);

        for (int i = 0; i < a.length(); i++) {
            String odd = getExpandFromCenter(a, i, i);
            String even = getExpandFromCenter(a, i, i + 1);

            if (odd.length() > maxString.length())
                odd = maxString;

            if (even.length() > maxString.length())
                even = maxString;


        }

        return maxString;

    }

    public static String getExpandFromCenter(String a, int i, int j) {
        while (i >= 0 && j < a.length() && a.charAt(i) == a.charAt(j)) {
            i--;
            j++;
        }

        return a.substring(i, j + 1);

    }

    //    Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
//    Output: [true,false,false,true,true]
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
       List<Boolean> li = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {

            int a[] = new int[queries[0].length];
            for(int j = 0 ; j < queries[0].length ; j++) {
                a[j] = queries[i][j];

            }
            if (checkCanBePalindrome(a,s))
                li.add(true);
        }
 return null;
    }

    public static boolean checkCanBePalindrome(int[] a,String s)
    {
        String operate = s.substring(a[0],a[1]);

        HashMap<Character,Integer> m = new HashMap<>();
        char t[] = operate.toCharArray();

        for(char y : t)
            m.put(y , m.getOrDefault(y,0) + 1);

        int checkPairs = 0 ;

        checkPairs = checkPairs + a[2];

        if(operate.length() == checkPairs)
            return true;

        if(operate.length() > checkPairs)
        {
            int balanceChar = operate.length() - checkPairs;
            if(balanceChar == a[2])
                return true;

        }

        return true;
    }

   // Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        List<Boolean> res = new ArrayList();

        for (int[] query : queries) {
            res.add(canMakePal(s, query[0], query[1], query[2]));
        }

        return res;
    }

    private boolean canMakePal(String s, int start, int end, int max) {
        if (max >= 13) return true;
        Set<Character> set = new HashSet();
        for (int i = start; i <= end; i++) {
            if (!set.add(s.charAt(i))) set.remove(s.charAt(i));
        }
        return max >= set.size()/2;
    }

//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> li = new ArrayList<>();

        for(int i = 0 ; i < strs.length ; i++)
        {
            List<String> t = new ArrayList<>();
            t.add(strs[i]);

            HashMap<Character,Integer> k = new HashMap<>();
            char p [] = strs[i].toCharArray();

            for( char y : p)
                k.put(y,k.getOrDefault(y,0) + 1);


            for(int j = 0 ; j < strs.length ; j++)
            {
                HashMap<Character,Integer> l = k;

                if( j != i && checkAnagram(l,strs[j]))
                    t.add(strs[j]);

            }

        li.add(t);

        }

        return li;
    }

   public static boolean checkAnagram(HashMap<Character,Integer> m , String s)
   {
       char t [] = s.toCharArray();
       for( char y : t)
       {
           if(m.containsKey(y))
               m.put(y,m.get(y) - 1);

       }

       for(int val : m.keySet())
       {
           if(val != 0)
               return false;

       }

       return true;

   }

//    Input: s = "   fly me   to   the moon  "
//    Output: 4
//    Explanation: The last word is "moon" with length 4.

    public static int lengthOfLastWord(String s)
    {
        String d [] = s.trim().split("\\s+");
        return d[d.length - 1].length();

    }


//    Input: s = "A man, a plan, a canal: Panama"
//    Output: true
//    Explanation: "amanaplanacanalpanama" is a palindrome.

    public static boolean isPalindrome(String s)
    {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        System.out.println("value of string -->"+ s);

        char t[] = s.toCharArray();

        int start = 0 ;
        int end = t.length - 1;

        while(start < end)
        {
            if(t[start] != t[end])
                return false;

            start++;
            end--;

        }

return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> ransom = new HashMap<Character,Integer>();

        char t[] = magazine.toCharArray();

        for(char u : t)
            ransom.put(u,ransom.getOrDefault(u,0) + 1);

        char o [] = ransomNote.toCharArray();

        for(char d : o)
        {
            if(ransom.containsKey(d) && ransom.get(d) > 0)
                ransom.put(d, ransom.get(d) - 1);

            else
                return false;

        }

        return true;
    }


    public static char findTheDifference(String s, String t) {
       // HashMap<Character,Integer> m = new HashMap<>();

        int freq[] = new int[128] ;

        for(char y : t.toCharArray())
        {
            freq[y]++;
        }

        for(char u : s.toCharArray())
        {

            freq[u]--;
        }

        for (int i = 0; i < 128; i++)
        {
            if( freq[i] == 1)
                return (char)i;
        }

        return '0';
    }


    public static boolean wordPattern(String pattern, String s) {
        HashMap<String,Integer> m = new HashMap<>();
        String d[] = s.split("\\s");
        System.out.println("value of string-->"+Arrays.toString(d));

        for(String f : d)
            m.put(f,m.getOrDefault(f,0) + 1);

        char t [] = pattern.toCharArray();

        for(char y : t)
        {
            m.put(String.valueOf(y),m.getOrDefault(String.valueOf(y),0) - 1);
        }

        System.out.println("value of hashmap-->"+ m);
        for(int j : m.values())
        {
            if(m.get(j) > 0 || m.get(j) < 0)
                return false;
        }

        return true;

    }

    public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");

        // If lengths don't match, it's not a valid pattern
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check character → word mapping
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) return false;
            } else {
                charToWord.put(ch, word);
            }

            // Check word → character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) return false;
            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }


    public static int firstUniqChar(String s)
    {
        int ch[]=new int[26];
        char sChar[]=s.toCharArray();
        for (char i: sChar)
        {
            ch[i-'a']++;
        }
        for (int i=0;i<sChar.length;i++)
        {
            if (ch[sChar[i]-'a']==1)
            {
                return i;
            }
        }
        return -1;

    }


    public int arrangeCoins(int n) {
        int origin = n;
        for(int i = 1 ; i <= n ; i++)
        {
            int rem = origin - i;

            if(rem < 0)
                return i - 1;

            else if(rem == 0)
                return i;

            origin = origin - i;
        }
return -1;
    }

    public boolean detectCapitalUse(String word) {
        return Pattern.matches("([A-Z]+|[a-z]+|[A-Z][a-z]*)", word);
    }



    public static List<String> summaryRanges(int[] nums)
    {
        List<String> result = new ArrayList<>();

        int lastUnMatched = 0;

        for(int i = 1 ; i < nums.length ; i++)
        {

            if(nums[i - 1] != nums[i] - 1)
            {
                String data = "";

                if(lastUnMatched == i)
                {
                    data = ""+nums[i];
                    result.add(data);
                }

                else
                {
                    data = ""+lastUnMatched+"->"+nums[i];
                    result.add(data);
                    lastUnMatched = i;
                }

            }


        }

return result;
    }



    public static  String clearDigits(String s) {

        char t [] = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0 ; i < t.length - 1 ; i++)
        {

            if(Character.isLetter(t[i]) && Character.isDigit(t[i + 1]))
            {
                sb.delete(i,i + 1);


            }



        }

   return sb.toString();
    }


    public int strStr(String haystack, String needle)
    {
        int lengthHayStack = haystack.length();
        int lengthNeedle = needle.length();

        for(int i = 0 ; i <lengthHayStack; i++ )
        {
            if(haystack.substring(i,lengthNeedle).equals(needle))
                return i;

        }


        return -1;


    }


    public static List<List<String>> groupAnagrams1(String[] strs)
    {
        HashMap<String , List<String>> result = new HashMap<>();

        for(String d : strs)
        {
            String original = d;
            sort(d);

            if(result.containsKey(d))
            {
                result.put(d, result.get(original));

            }
            else
            {
                result.put(d,new ArrayList<>());

            }

        }

        List<List<String>> res = new ArrayList<>();

     for(List<String> f : result.values())
     {
         res.add(f);
     }


     return res;
    }

    public static String sort(String s)
    {
        char t [] = s.toCharArray();
         Arrays.sort(t);
         return String.valueOf(t);

    }

//    public static void countSegments(String s)
//    {
//        String c[] = s.trim().split("\\s+");
//
//        return c.length;
//
//    }


//    Input: S = "geeksforgeek"
//    Output: "gksforgk"
//    Explanation: g(ee)ksforg(ee)k -> gksforgk
//
//    Input: S = "abccbccba"
//    Output: ""
//    Explanation: ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->"" (empty string)

//    Input: k = 5
//
//    Output: "b"
//
//    Explanation:
//
//    Initially, word = "a". We need to do the operation three times:
//
//    Generated string is "b", word becomes "ab".
//    Generated string is "bc", word becomes "abbc".
//    Generated string is "bccd", word becomes "abbcbccd"

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int size = sb.length();
            for (int i = 0; i < size; i++) {
                sb.append((char) ('a' + ((sb.charAt(i) - 'a') + 1) % 26));
            }
        }
        return sb.charAt(k - 1);
    }

    public int minMaxDifference(int num) {
        // This is the main function. It takes a number and finds the difference
        // between the largest and smallest numbers you can make by replacing digits.
        String s = String.valueOf(num); // Convert the number to a string so we can easily work with its digits
        return getMax(s) - getMin(s);   // Call helper functions to find max and min, then subtract
    }

    private int getMax(String s) {
        // This function finds the largest number you can make by replacing one digit with '9'.
        int n = s.length(); // Get the length of the string
        for (int i = 0; i < n; i++) {
            // Loop through each digit in the string
            char c = s.charAt(i); // Get the current digit
            if (c < '9') {
                // If the digit is less than '9', we can replace it to make a bigger number
                return Integer.parseInt(s.replace(c + "", "9")); // Replace all occurrences of the digit with '9' and return the new number
            }
        }
        return Integer.parseInt(s); // If all digits are '9', return the original number
    }

    private int getMin(String s) {
        // This function finds the smallest number you can make by replacing one digit with '0'.
        int n = s.length(); // Get the length of the string
        for (int i = 0; i < n; i++) {
            // Loop through each digit in the string
            char d = s.charAt(i); // Get the current digit
            if (d > '0') {
                // If the digit is greater than '0', we can replace it to make a smaller number
                return Integer.parseInt(s.replace(d + "", "0")); // Replace all occurrences of the digit with '0' and return the new number
            }
        }
        return Integer.parseInt(s); // If all digits are '0', return the original number
    }

    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length(); i++)
        {
            if(Character.isLetter(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == '*')
            {
                sb.deleteCharAt(sb.length() - 1);
            }
            else if(s.charAt(i) == '#')
            {
                sb.append(sb);
            }
            else if(s.charAt(i) == '%')
            {
                sb.reverse();
            }

        }

        return sb.toString();
    }
    public String reverse(String d)
    {
        char t [] = d.toCharArray();
        int start = 0;
        int end = t.length - 1;

        while(start < end)
        {
            char temp = t[start];
            t[start] = t[end];
            t[end] = temp;
        }

        return String.valueOf(t);
    }

    public boolean backspaceCompare(String s, String t) {
       Stack<Character> sb = new Stack<>();
       Stack<Character> st = new Stack<>();

       for(char o  : s.toCharArray())
       {
            if(!sb.isEmpty() && o == '#')
                sb.pop();
            else
                sb.push(o);
       }


        for(char o  : t.toCharArray())
        {
            if(!st.isEmpty() && o == '#')
                st.pop();
            else
                st.push(o);
        }

        while(!sb.isEmpty() && !st.isEmpty())
        {
            if(sb.pop() != st.pop())
                return false;
        }

        return true;

    }



    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;




    }


    public static boolean solution(String[] words, String variableName) {
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word.toLowerCase());
        }

        List<String> tokens = splitCamelCase(variableName);
        for (String token : tokens) {
            if (!wordSet.contains(token.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private static List<String> splitCamelCase(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                }
                current = new StringBuilder();
                current.append(Character.toLowerCase(c)); // Normalize to lowercase
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            tokens.add(current.toString());
        }

        return tokens;
    }

    public int maxRepeating(String sequence, String word) {
        int k = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(word);
            if (sequence.contains(sb.toString())) {
                k++;
            } else {
                break;
            }
        }


        return k;
    }
// String s = "abcde"
   // String words []={"aa","acd","abd","ace","bde"}

   public static int checkSubsequenceCount(String s, String words[])
   {
       int count=0;

       for(int i = 0 ; i < words.length ; i++)
       {
           int index = 0 ;
           int j = 0;

           while(index != s.length() && j != words[i].length())
           {
               if(s.charAt(index) == words[i].charAt(j) )
               {
                   j++;
               }
               index++;
           }

           if(j == words[i].length())
               count++;


       }

       return count;
   }

   public static int isSubsequenceArr(String s, String words[])
   {
       int count = 0;

       HashMap<Character,List<Integer> > m = new HashMap<>();

       for(int i = 0 ; i < s.length() ; i++)
       {
           m.computeIfAbsent(s.charAt(i),k -> new ArrayList<>()).add(i) ;
       }

       for(String word : words)
       {
           if(isSubsequenceStr(word,m))
           count++;
       }

return count;

   }

    public static boolean isSubsequenceStr(String word,HashMap<Character,List<Integer> > m)
    {
      int prevIndex = -1;

        for(char t : word.toCharArray())
        {
            if(!m.containsKey(t))
                return false;

            int nextIndex =findNextIndex(m.get(t),prevIndex);
            if(nextIndex == -1)
                return false;

            prevIndex = nextIndex;

        }

        return 2 > 1;
    }

    public static int findNextIndex(List<Integer> positions,int prevIndex)
    {
        int start = 0;
        int right = positions.size() - 1;
        int nextIndex = -1;
        while(start <= right)
        {
            int mid = start + (right - start) /2;

            if(positions.get(mid) > prevIndex)
            {
                nextIndex  = positions.get(mid);
                right = mid - 1;

            }
            else
                start = mid + 1;


        }
        return nextIndex;
    }

//    Example 1:
//
//    Input: number = "123", digit = "3"
//    Output: "12"
//    Explanation: There is only one '3' in "123". After removing '3', the result is "12".
//    Example 2:
//
//    Input: number = "1231", digit = "1"
//    Output: "231"
//    Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
//    Since 231 > 123, we return "231".

    public String removeDigit(String number, char digit) {
        String maxString = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                StringBuilder sb = new StringBuilder(number);
                sb.deleteCharAt(i);
                String candidate = sb.toString();

                if (maxString.isEmpty() || candidate.compareTo(maxString) > 0) {
                    maxString = candidate;
                }
            }
        }

        return maxString;
    }




    public String removeDuplicates(String s) {
        String result = "";
        Stack st = new Stack();

        for(char t : s.toCharArray())
        {
            if(!st.isEmpty() && st.peek().equals(t))
                st.pop();

            else
                st.push(t);


        }

        while(!s.isEmpty())
        {
            result += st.pop();
        }

        return reversed(result);


    }

    public String reversed(String s)
    {
        char t [] = s.toCharArray();
        int start = 0;
        int end = t.length -1;

        while(start < end)
        {
            char temp = t[start];
            t[start] = t[end];
            t[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(t);
    }







    public String reverseOnlyLetters(String s) {
        char r[] = s.toCharArray();
        int start = 0;
        int end = r.length - 1;

        while(start < end)
        {

            if(Character.isUpperCase(r[start]) || Character.isLowerCase(r[start]) || Character.isUpperCase(r[end]) ||
                    Character.isLowerCase(r[end]))
            {
                char temp = r[start];
                r[start] = r[end];
                r[end] = temp;
                start++;
                end--;

            }



        }

        return String.valueOf(r);



    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Store banned words in a set for fast lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Count word frequencies
        Map<String, Integer> freq = new HashMap<>();
        for (String word : paragraph.split("\\s+")) {
            if (word.isEmpty() || bannedSet.contains(word)) continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Find the most frequent non-banned word
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public int secondHighest(String s) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();


        for(char r : s.toCharArray())
        {
            if(Character.isDigit(r))
                p.offer(Integer.parseInt(String.valueOf(r)));

            if(p.size() > 2)
                p.poll();

        }

        return p.isEmpty() ? -1 : p.peek();
    }

      public static boolean characterFreq(String s,String u)
      {
          int [] freq = new int[26];

          for(char t : s.toCharArray())
          {
              int val = t - 'a';
              freq[val]++;
          }

          for(char o : u.toCharArray())
          {
              int val = o - 'a';
              freq[val]--;
          }

          for(int i : freq)
          {
              if(i == 1)
                  return false;
          }

  return true;

      }

// STring permutation if s1 is permutation of s2 

    // s1 = "ab", s2 = "eidbaooo"
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s1Count.equals(s2Count)) {
            return true;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            char charRight = s2.charAt(right);
            s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);

            char charLeft = s2.charAt(left);
            s2Count.put(charLeft, s2Count.get(charLeft) - 1);
            if (s2Count.get(charLeft) == 0)
            {
                s2Count.remove(charLeft);
            }

            left++;

            if (s1Count.equals(s2Count)) {
                return true;
            }
        }

        return false;
    }


    public int minimumTimeToInitialState(String word, int k)
    {
        int c =0;
        int s = word.length();
        String copy = word;
        do
        {
            copy = copy.substring(k) + "*".repeat(k);
            c++;

        }
        while(!check(word,copy));

        return c;




    }

    public boolean check(String word, String target)
    {
        int n = word.length();

        for(int i = 0 ; i < n ; i++)
        {
            if(target.charAt(i) != '*' && target.charAt(i) != word.charAt(i))
                return false;


        }

        return true;
    }

    public int minimumTimeToInitialState1(String word, int k) {
        int c=1;
        for(int i=k;i<word.length();i+=k){
            if(check(word,i)){
                return c;
            }
            c++;
        }
        return c;
    }

    private boolean check(String word,int idx){
        for(int i=idx;i<word.length();i++){
            if(word.charAt(i-idx) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public int maxFreqSum(String s) {
        int[] c = new int[26];

        for (char t : s.toCharArray()) {
            c[t - 'a']++; // count frequency
        }

        int maxVowl = 0;
        int maxCon = 0;

        for (int idx = 0; idx < 26; idx++) {
            int freq = c[idx];
            if (freq == 0) continue;

            char ch = (char)(idx + 'a');
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVowl = Math.max(maxVowl, freq);
            } else {
                maxCon = Math.max(maxCon, freq);
            }
        }

        return maxVowl + maxCon;
    }


    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // no need to check further
                }
            }
        }
        return result;
    }

    public static String fractionToDecimal(int numerator, int denominator)
    {

        double result =  numerator / denominator;

        String ans[] = String.valueOf(result).split("//.");
        String first = ans[0];

        String second = ans[1];

        HashMap<Character,Integer> m = new HashMap<>();
         int count = 0;
         String s = "";
        for(char t : second.toCharArray())
        {
            if(!m.containsKey(t)) {
                m.put(t, 1);
                count++;

            }
            else
            {
                m.put(t,m.getOrDefault(t,0) - 1);

                if(m.get(t) == 0 ) {
                    m.remove(t);
                    s = s + t;

                }
                count--;

                if(count == 0)
                    break;

            }



        }

        return first + "(" + s + ")";

    }


//    Input:  s = "abcda"
//    Output: 2
//    Explanation: Insert 'd' and 'c' → "adcba" or "abcdcba"

    public static int minimumOps(String s)
    {
        int count = 0;
        int countOdds = 0;
        HashMap<Character,Integer> m = new HashMap<>();

        for(char t : s.toCharArray())
            m.put(t,m.getOrDefault(t, 0) + 1);


        for(char t : m.keySet())
        {
            if(m.get(t) % 2 != 0)
                countOdds++;

        }

        if(countOdds <= 1)
            return 0;

        else
        {
            for(char t : m.keySet())
            {
                if(m.get(t) % 2 != 0)
                {
                    count++;
                }

            }

        }

        return count - 1;

    }


    public static int minimumInsertions(String s) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(s, 0, s.length() - 1, memo);
    }

    private static int helper(String s, int i, int j, Map<String, Integer> memo) {
        if (i >= j) return 0; // base case

        String key = i + "," + j; // unique key for substring s[i..j]
        if (memo.containsKey(key)) return memo.get(key);

        int result;
        if (s.charAt(i) == s.charAt(j)) {
            result = helper(s, i + 1, j - 1, memo);
        } else {
            result = 1 + Math.min(helper(s, i + 1, j, memo),
                    helper(s, i, j - 1, memo));
        }

        memo.put(key, result);
        return result;
    }
}
