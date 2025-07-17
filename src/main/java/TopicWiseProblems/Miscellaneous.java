package org.example;



import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Miscellaneous
{


    public static void main( String[] args )
    {

      //  System.out.println(digitRoot(999888777L));

       // System.out.println(findOdd(new int []{10}));

//        int [][]a = pairs(new int []{5, 4, 4, 6, 6, 6, 4});
//
//        for(int b[] :a)
//        {
//            for(int y :b)
//            {
//                System.out.print(" "+y);
//            }
//        }

     //   System.out.println(unrepeated("WWE!!!"));

       // System.out.println(unmix("214365"));


        //System.out.println(uniquely(new String []{"s", "t", "v"},new String []{"stamina", "television", "vindaloo"}));

     //
        //  System.out.println(anagram("Justin Bieber",new String []{"injures", "ebb", "it"}));

       // System.out.println(balanced("zips"));

        //gcd(new int []{120, 105, 300, 95, 425, 625, 18});

//       String f= longestNonrepeatingSubstring("kjlmjsdeee");
//        System.out.println("length of strig -->"+f.length() + f);

     //   System.out.println(oddOneOut(new String []{"very", "to", "an", "some"}));

      //  dateAndTime();

      //  System.out.println(missingLetter(new String []{"t", "u", "v", "w", "x", "z"}));

//        int j []=characterMapping("abb");
//
//        for(int i : j)
//            System.out.print(" "+i);
       // hollowSquare();

      //  System.out.println(almostPalindrome("abccia"));

      //  noYelling("I just cannot believe it.");

       // System.out.println(memeSum(1222,30277));

       // System.out.println(sharedDigits(new int []{12, 13, 17, 19, 79}));


       // System.out.println( closingInSum(22225555));

//        String s[]=threeLetterCollection("slap");
//        for(String f : s)
//            System.out.print(" " + f  );
//
//        int y [] = returnUnique(new int []{1, 2, 1, 3, 1, 7, 1, 9, 7, 9});
//
//        for(int h : y)
//            System.out.print(" "+h);


      //  System.out.println(closestPalindrome1(27));

       // System.out.println(isAlphabeticallySorted("She sells sea shells by the sea shore."));


       // System.out.println(countLoneOnes(462));

//      String h []=  split("((())())(()(()()))");
//
//      for(String j : h)
//          System.out.print(" "+ j);

       // System.out.println(getEqualArray(new int []{ 3 , 2 , 13 , 4, 1 , 8 }));

      //  System.out.println(longestSubarray(new int []{10, -10, 20, 30},5));

        //System.out.println(missingNumber(new int []{5,6,8,9,10}));

       // System.out.println(maxWater(new int []{1,1}));

       // System.out.println(canBuild("aa", "aaa"));

       // System.out.println(primeNumbers(10));

      //  System.out.println(duplicateCount("Aa"));

//        int []a = getCoinBalances(new String []{"steal"}, new String []{"share"});
//        for(int i :a)
//            System.out.print(" "+ i);

//        int a[]=rotateArray(new int []{2,3,4,5,6,7,8,9},3);
//        for(int i : a)
//            System.out.print(" "+ i );

      //  rotateIndex(new int []{1,2,3,4,5,6,7,8},3);

       // System.out.println(Arrays.toString(rotateArray1(new int []{1,2,3,4,5,6,7,8},3)));

       // System.out.println(Arrays.toString(arrayrotate4(new int []{1,2,3,4,5,6,7,8})));

      //  System.out.println(isPalindrome(10));

        //System.out.println(findMedianSortedArrays(new int []{2,2,4,4}, new int []{2,2,2,4,4}));
      //  factorial();

       // System.out.println(firstNonRepeating("swiss"));

        rotateArray1(new int []{1, 2, 3, 4, 5},2);

    }

    //  { 3 , 2 , 13 , 4, 1 , 8 }

//    digitRoot(123) ➞ 6
//// 1 + 2 + 3 = 6
//
//    digitRoot(999888777L) ➞ 9
//
//    digitRoot(1238763636555555555L) ➞ 9

    public static int digitRoot(long n)
    {
        if(n < 10)
            return (int) n;


        long sum = 0 ;

        while(n != 0 )
        {
            long k = n % 10 ;

            sum = sum + k;

            n = n/10;

            if(n == 0 )
            {
                if(sum < 10)
                    return (int) sum;

                else {
                    n = sum;
                    sum = 0;
                }
            }

        }

        return 0 ;
    }


//    findOdd([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5]) ➞ -1
//
//    findOdd([20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5]) ➞ 5
//
//    findOdd([10]) ➞ 10


    public static int findOdd(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++)

        {

            if(m.containsKey(arr[i]))
                m.put(arr[i],m.get(arr[i]) + 1);

            else
                m.put(arr[i], 1);

        }

        for(int u : m.keySet())
        {
            if(m.get(u) % 2 == 1)
                return u;
        }

return 0;

    }


//    pairs([1, 1, 1, 1, 7, 2, 3, 2]) ➞ [[1, 2], [1, 3], [1, 2], [1, 7]]
//
//    pairs([5, 4, 4, 6, 6, 6, 4]) ➞ [[5, 4], [4, 6], [4, 6], [6, 6]]
//
//    pairs([1, 2, 3, 4, 5, 6, 7]) ➞ [[1, 7], [2, 6], [3, 5], [4, 4]]
//
//    pairs([1, 2, 3, 4, 5, 6]) ➞ [[1, 6], [2, 5], [3, 4]]


    public static int[][] pairs(int[] arr)
    {
        List<List<Integer>> li = new ArrayList<>();



        int start = 0 ;
        int end = arr.length - 1;


        while(start <= end)
        {
            if(start == end)
            {
                List<Integer> m = new ArrayList<>();
                m.add(arr[start]);
                m.add(arr[start]);
                li.add(m);
                start++;
                end--;
            }
            List<Integer> m = new ArrayList<>();
            m.add(arr[start]);
            m.add(arr[end]);
            li.add(m);
            start++;
            end--;


        }
        System.out.println("arrratlist-->"+li);

        int[][] array = new int[li.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[li.get(i).size()];
        }
        for(int i=0; i<li.size(); i++){
            for (int j = 0; j < li.get(i).size(); j++) {
                array[i][j] = li.get(i).get(j);
            }
        }

        return array;
    }





//    unrepeated("aaaaa") ➞ "a"
//
//    unrepeated("WWE!!!") ➞ "WE!"
//
//    unrepeated("call 911") ➞ "cal 91"

    public static String unrepeated(String str)
    {
//        HashSet<Character> h = new HashSet<>();
//      //  List<String> l = new ArrayList<>();
//        StringBuilder s = new StringBuilder();
//
//        for(int i = 0; i < str.length() ; i++)
//        {
//            h.add(str.charAt(i));
//        }
//
//
//        Iterator i = h.iterator();
//        while(i.hasNext())
//        {
//            s.append(i.next());
//        }

        LinkedHashMap<Character,Integer> m = new LinkedHashMap<>();
        StringBuilder s = new StringBuilder();

        int count = 0 ;
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(!m.containsKey(str.charAt(i)))
            {
                m.put(str.charAt(i),count++);
            }

        }

        for(char t : m.keySet())
        {
            s.append(t);
        }


        return s.toString();


    }



//    unmix("123456") ➞ "214365"
//
//    unmix("hTsii  s aimex dpus rtni.g") ➞ "This is a mixed up string."
//
//    unmix("badce") ➞ "abcde"


    public static String unmix(String str)
    {
        str = str + "aa";
        char u [] = str.toCharArray();
      for(int i = 0 ; i < str.length() - 2 ; i = i + 2)
      {
          char t = u[i + 1];
          u[i + 1 ] = u [i];
          u[i] = t;

      }
      String s = "";
      for(char f : u)
      {
          s = s + f;
      }
      return s.substring(0,1);

    }

//    uniquely(["ho", "h", "ha"], ["house", "hope", "happy"]) ➞ false
//// "ho" and "h" are ambiguous and can identify either "house" or "hope"
//
//    uniquely(["x", "l", "t"], ["xavier", "loves", "tesh"]) ➞ true
//
//    uniquely(["s", "t", "v"], ["stamina", "television", "vindaloo"]) ➞ true
//
//    uniquely(["bi", "ba", "bat"], ["big", "bard", "battery"]) ➞ false
//
//    uniquely(["mo", "ma", "me"], ["moment", "many", "mean"]) ➞ true


    public static boolean uniquely(String[] a, String[] w)
    {
        int min = Integer.MAX_VALUE;
        for(String d : a)
        {
            min = Math.min(min,d.length());
        }


        for(int i = 0 ; i < a.length ; i++)
        {
            int count = 0 ;
            for(int j = 0 ; j < w.length ; j++)
            {

                if(w[j].substring(0,min).contains(a[i]))
                {

                    count++;
                }
                if(count > 1)
                    return false;
            }

        }


return true;
    }


//    anagram("Tesha Xavier", ["six", "have", "rate"]) ➞ true
//
//    anagram("Natalie Portman", ["ornamental", "pita"]) ➞ true
//
//    anagram("Chris Pratt", ["chirps", "rat"]) ➞ false
//// Not all letters are used
//
//    anagram("Jeff Goldblum", ["jog", "meld", "bluffs"]) ➞ false
//// "s" does not exist in the original name
//
//    anagram("Justin Bieber", ["injures", "ebb", "it"]) ➞ true

//    public static boolean anagram(String name, String[] words)
//    {
//        HashMap<Character,Integer> m = new HashMap<>();
//        for(int i = 0 ; i < name.length(); i++)
//        {
//            if(m.containsKey(name.charAt(i)))
//                m.put(name.charAt(i),m.get(name.charAt(i)) + 1);
//
//            else
//                m.put(name.charAt(i) , 1);
//
//        }
//
//        for(String s : words)
//        {
//            for(int i = 0 ; i < s.length() ; i++) {
//                if (m.containsKey(s.charAt(i))) {
//                    if(m.get(s.charAt(i)) == 0 && m.get(Character.toUpperCase(s.charAt((i))) > 0)
//                    {
//
//                    }
//
//                    m.put(s.charAt(i), m.get(s.charAt(i)) - 1);
//                }
//            }
//        }
//
//
//        System.out.println("hashmap -->"+m);
//
//
//        for(Character d : m.keySet())
//        {
//            if(m.get(d) > 0 && m.get(d) != ' ')
//                return false;
//        }
//
//        return true;
//
//    }


//    balanced("zips") ➞ true
//// "zips" = "zi|ps" = 26+9|16+19 = 35|35 = true
//
//    balanced("brake") ➞ false
//// "brake" = "br|ke" = 2+18|11+5 = 20|16 = false

    public static boolean balanced(String word)
    {
        int start = 0 ;
        int end = word.length() - 1;

        int left = 0 ;
        int right = 0 ;
        char t [] = word.toCharArray();
        while(start < end)
        {
            left += Character.getNumericValue(t[start]);
            right += Character.getNumericValue(t[end]);

            start++;
            end --;

        }


        return left == right ? true : false;


    }




//    gcd({84, 70, 42, 56}) ➞ 14
//
//    gcd({19, 38, 76, 133}) ➞ 19
//
//    gcd({120, 300, 95, 425, 625}) ➞ 5


    public static int gcd(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ;i++)
        {
         min = Math.min(min,arr[i]);

        }
        int min1 = Integer.MIN_VALUE;


         for(int i = 2 ; i <= min ;i++)
         {

             for(int j = 0 ; j < arr.length ; j++)
             {
                 if( arr[j] % i != 0 )
                     break;
                 else if (arr[j] % i == 0 && j == arr.length - 1)
                     min1 = Math.max(min1,i);
             }
         }


         return min1 < 0 ? 1 : min1 ;

    }


//    longestNonrepeatingSubstring("abcabcbb") ➞ "abc"
//
//    longestNonrepeatingSubstring("aaaaaa") ➞ "a"
//
//    longestNonrepeatingSubstring("abcde") ➞ "abcde"
//
//    longestNonrepeatingSubstring("abcda") ➞ "abcd"

    public static String longestNonrepeatingSubstring(String str)
    {
        HashSet<Character> h = new HashSet<>();
        List<String> l = new ArrayList<>();
        //aaccddeeffb

        char t []= str.toCharArray();
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(h.contains(t[i]))
            {
                l.add(String.valueOf(h));
                h.clear();
                h.add(t[i]);
            }

            else
            {
                h.add(t[i]);
            }
           if(i == str.length() - 1)
               l.add(String.valueOf(h));

        }

        System.out.println("list -->"+l);
        System.out.println("ste ->>"+h);

        if(l.isEmpty() )
            l.add(String.valueOf(h));


        int max = Integer.MIN_VALUE;
        for(String g : l)
        {
            max = Math.max(max,g.length());
        }

     String longestString = "";
        for(String g : l)
        {
            if(g.length() == max) {
                longestString = g;
                break;

            }
        }

              longestString = longestString.replaceAll("[^a-zA-Z]","");

        return longestString;
    }



//    oddOneOut(["silly", "mom", "let", "the"]) ➞ true
//
//    oddOneOut(["swanky", "rhino", "moment"]) ➞ true
//
//    oddOneOut(["the", "them", "theme"]) ➞ false
//
//    oddOneOut(["very", "to", "an", "some"]) ➞ false

    public static boolean oddOneOut(String[] arr)
    {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++)
        {
                if(m.containsKey(arr[i].length()))
                    m.put(arr[i].length(),m.get(arr[i].length()) + 1);

                else
                    m.put(arr[i].length(),1);
        }

        if(m.size() > 2)
            return false;
        else if(m.size() == 2)
        {
            for(int i : m.keySet())
            {
                if(m.get(i) == 1)
                    return true;
            }
        }
        else if (m.size() == 1)
            return true;


        return false;



    }


//    getLuckiest([-544, 666, -645, -445]) ➞ -445
//
//    getLuckiest([5, 12, 55, 11]) ➞ 55
//
//    getLuckiest([5, 12, -55,  11]) ➞ -55
//
//    getLuckiest([515, 1255, -55,  1]) ➞ 1255
//
//    getLuckiest([44, 12, 7, 40]) ➞ 44


//    getItemsAt([2, 4, 6, 8, 10], "odd") ➞ [2, 6, 10]
//// 2, 6 & 10 occupy the 5th, 3rd and 1st positions from right.
//// Odd positions, hence the parity, and from the opposite.
//
//    getItemsAt(['E', 'D', 'A', 'B', 'I', 'T'], "even") ➞ ['E', 'A', 'I']
//// E, A and I occupy the 6th, 4th and 2nd positions from right.
//// Even positions, hence the parity, and from the opposite.


    public static Object[] getItemsAt(Object[] arr, String par)
    {
        List<Object> l = new ArrayList<>();
        if(par.contains("even")) {
            for (int i = arr.length - 2; i >= 0; i = i - 2)
            {
                l.add(arr[i]);

            }
        }
        else
        {
            for(int i = arr.length - 1 ; i >= 0 ; i = i - 2){
                l.add(arr[i]);
            }

        }

        Object [] a= new Object[l.size()];
        int count = 0 ;
        for(int i = l.size() - 1 ; i >= 0  ; i--)
        {
            a[count++] = l.get(i);
        }

        return a;

    }

//    numToEng(0) ➞ "zero"
//
//    numToEng(18) ➞ "eighteen"
//
//    numToEng(126) ➞ "one hundred twenty six"
//
//    numToEng(909) ➞ "nine hundred nine"

//    public static String numToEng(int n)
//    {
//
//
//    }

//    singleNumber([2, 2, 3, 2]) ➞ 3
//
//    singleNumber([0, 1, 0, 1, 0, 1, 99]) ➞ 99
//
//    singleNumber([-1, 2, -4, 20, -1, 2, -4, -4, 2, -1]) ➞ 20


    public static int singleNumber(int[] n)

    {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i =  0 ; i < n.length ; i++)
        {
            if(m.containsKey(n[i]))
                m.put(n[i],m.get(n[i]) + 1);

            else
                m.put(n[i], 1);

        }

        for(int j : m.keySet())
        {
            if(m.get(j) != 3)
                return j;
        }

        return 0;

    }


    // bBsGSg
    // sbgBGS

    public static boolean kitchenDoor(String s)
    {
        HashMap<String,String> m = new HashMap<>();

        m.put("b","bronze");
        m.put("s","silver");
        m.put("g","gold");
        m.put("B","bronze");
        m.put("S","silver");
        m.put("G","gold");

       int start = 0 ;
       int end = s.length() - 1;

       while (start <= end )
       {
           if(Character.isLowerCase(s.charAt(start)) && Character.isUpperCase(s.charAt(end)) ||
           Character.isLowerCase(s.charAt(end)) && Character.isUpperCase(s.charAt(start)))
           {
               start++;
               end--;

           }
           else
               return false;

       }

return true;

    }

//    5 5 5 10 20
//    5 5 10 10 20
//    public static boolean muffins()
//    {
//
//
//    }


        public static void dateAndTime() {


            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            String time = dtf.format(now);

            char t[] = time.toCharArray();
            t[10] = 'T';
            System.out.println(String.valueOf(t));

        }

//    missingLetter(["a", "b", "c", "e", "f", "g"]) ➞ "d"
//
//    missingLetter(["O", "Q", "R", "S"]) ➞ "P"
//
//    missingLetter(["t", "u", "v", "w", "x", "z"]) ➞ "y"
//
//    missingLetter(["m", "o"]) ➞ "n"

    public static String missingLetter(String[] arr)
    {

        for(int i = 0 ; i < arr.length - 1 ; i++)
        {

            if((int)arr[i].charAt(0) + 1 != (int)arr[i + 1].charAt(0) )
            {
                int j = (int)arr[i].charAt(0) + 1;
                return String.valueOf((char) j );
            }
        }

return null;

    }


//    characterMapping("abcd") ➞ [0, 1, 2, 3]
//
//    characterMapping("abb") ➞ [0, 1, 1]
//
//    characterMapping("babbcb") ➞ [0, 1, 0, 0, 2, 0]
//
//    characterMapping("hmmmmm") ➞ [0, 1, 1, 1, 1, 1]

    public static int[] characterMapping(String str)
    {
        HashMap<Character,Integer> m = new HashMap<>();
        int a[]= new int[str.length()];
        char t [] = str.toCharArray();
        int count = 0 ;
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(m.containsKey(t[i]))
            {
                a[i] = m.get(t[i]);
            }
            else
            {
                m.put(t[i],count++);
                a[i] = m.get(t[i]);
            }

        }

        return a;

    }


    public static void hollowSquare()
    {
        for(int i = 0 ; i < 6 ; i++)
        {
            for(int j = 0 ; j < 6 ; j++)
            {
                if(i == 0 || i == 5)
                    System.out.print(" *");

                else if ( i != 0 || i != 5)
                {
                    if(j == 0 || j == 5)
                        System.out.print(" *");
                    else
                        System.out.print(" ");
                }


            }
            System.out.println();
        }

    }


//    isCurzon(5) ➞ true
//// 2 ** 5 + 1 = 33
//// 2 * 5 + 1 = 11
//// 33 is a multiple of 11
//
//    isCurzon(10) ➞ false
//// 2 ** 10 + 1 = 1025
//// 2 * 10 + 1 = 21
//// 1025 is not a multiple of 21
//
//

    public static boolean isCurzon(int n)
    {
        double square = Math.pow(2,n) + 1;
        double remainder = (2 * n )+ 1;

        if(square%remainder == 0 )
            return true;
        else
            return false;


    }


//    almostPalindrome("abcdcbg") ➞ true
//// Transformed to "abcdcba" by changing "g" to "a".
//
//    almostPalindrome("abccia") ➞ true
//// Transformed to "abccba" by changing "i" to "b".
//
//    almostPalindrome("abcdaaa") ➞ false
//// Can't be transformed to a palindrome in exactly 1 turn.
//
//    almostPalindrome("1234312") ➞ false

    public static boolean almostPalindrome(String str)
    {

        int start = 0 ;
        int end = str.length() - 1;
        int count = 0 ;
        char c[] = str.toCharArray();

        while( start <= end )
        {

            if( c[start] != c[end])
                count ++;

            start ++;
            end --;


        }

        if( count != 1)
            return false;

        return true;


    }

//    noYelling("What went wrong?????????") ➞ "What went wrong?"
//
//    noYelling("Oh my goodness!!!") ➞ "Oh my goodness!"
//
//    noYelling("I just!!! can!!! not!!! believe!!! it!!!") ➞ "I just!!! can!!! not!!! believe!!! it!"
//// Only change repeating punctuation at the end of the sentence.


    public static String noYelling(String phrase)
    {

        String s[] = phrase.split(" ");

        String f = s[s.length - 1];

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < f.length() ; i++)
        {

            if(f.charAt(i) == '!' ) {
                sb.append("!");
                break;

            }else if (f.charAt(i) == '?') {
                sb.append("?");
                break;
            }

            sb.append(f.charAt(i));
        }

      StringBuilder d= new StringBuilder();

        for(int i = 0 ; i < phrase.length() - f.length() ; i++)
        {
            d.append(phrase.charAt(i));
        }

        d = d.append(sb);


        return d.toString();

    }

//    memeSum(26, 39) ➞ 515
//// 2+3 = 5, 6+9 = 15
//// 26 + 39 = 515
//
//    memeSum(122, 81) ➞ 1103
//    // 1+0 = 1, 2+8 = 10, 2+1 = 3
//// 122 + 81 = 1103
    public static int memeSum(int a, int b)
    {
        String s= "";
        int aCount = String.valueOf(a).length() - 1;
        int bCount = String.valueOf(b).length() - 1;

        char A[] = String.valueOf(a).toCharArray() ;
        char B[] = String.valueOf(b).toCharArray();
        while(aCount >= 0 && bCount >= 0  )
        {
            int sum = Character.getNumericValue(A[aCount]) + Character.getNumericValue(B[bCount]);

            s =  sum + s;

            aCount--;
            bCount--;
        }


        for(int i = aCount ; i >= 0 ; i--)
        {
            s = Character.getNumericValue(A[i]) + s;
        }

        for(int i =  bCount ; i >= 0 ; i--)
        {
            s = Character.getNumericValue(B[i]) + s;
        }

        int unauthorizedTransactionsCount60d = 0;
        int nsfOverdraftTransactionsCount90d = 1;

        if((unauthorizedTransactionsCount60d * 100 ) <= 1 && (nsfOverdraftTransactionsCount90d >= 300 ))
        {

        }



return Integer.parseInt(s);
    }



//    sharedDigits([12, 13, 17, 19, 79]) ➞ true
//// 12 and 13 share 1, 13 and 17 share 1 and etc.
//
//    sharedDigits([33, 53, 6351, 12, 2242, 44]) ➞ true
//// 33 and 53 share 3, 53 and 6351 share 3 and 5, etc.
//
//    sharedDigits([33, 44, 55, 66, 77]) ➞ false
//
//    sharedDigits([1, 11, 12, 13, 14, 15, 16]) ➞ true
//
//    sharedDigits([1, 12, 123, 1234, 1235, 6789]) ➞ false


    public static boolean sharedDigits(int[] num)
    {

        for(int i = 1 ; i < num.length ; i++)
        {
            if(!String.valueOf(num[i - 1 ]).contains(String.valueOf(num[i])))
                return false;

        }



        return true;

    }



//    closingInSum(121) ➞ 13
//// 11 + 2
//
//    closingInSum(1039) ➞ 22
//// 19 + 3
//
//    closingInSum(22225555) ➞ 100
//// 25 + 25 + 25 + 25
//

    public static int closingInSum(long num)
    {
        int start = 0 ;
        int end = String.valueOf(num).length() - 1;

        int sum = 0;
        char t[] =String.valueOf(num).toCharArray();

        String s ="";

        if(String.valueOf(num).length() % 2 == 0) {

            while (start < end) {

                s = String.valueOf(t[start]);
                s = s + String.valueOf(t[end]);
                sum = sum + Integer.parseInt(s);

                start++;
                end--;

                s = "";

            }
        }
        else
        {

            while (start < end) {

                s = String.valueOf(t[start]);
                s = s + String.valueOf(t[end]);

                sum = sum + Integer.parseInt(s);


                start++;
                end--;

                s = "";

            }
            int d = String.valueOf(num).length() / 2;

            sum = sum + Character.getNumericValue(t[d]);

        }


        return sum ;
    }


//    threeLetterCollection("tesha") ➞ ["esh", "sha", "tes"]
//
//    threeLetterCollection("click") ➞ ["cli", "ick", "lic"]
//
//    threeLetterCollection("cat") ➞ ["cat"]
//
//    threeLetterCollection("hi") ➞ []
//
//    threeLetterCollection("slap") ➞ ["lap", "sla"]

    public static String[] threeLetterCollection(String s)
    {
        if(s.length() < 3)
            return new String []{};

        else if(s.length() == 3)
         return new String []{s};

         ArrayList<String> a =new ArrayList<>();

         char t[] = s.toCharArray();

        for(int i = 0 ; i < s.length() - 2 ; i++)
        {
            String f = "";

                  for(int j = i ; j < i + 3 ; j++)
                  {
                        f = f + t[j];

                  }

                  a.add(f);
                  f = "";
        }


        String e [] = new String[a.size() ];

       for(int i = 0 ; i < e.length ; i++)
       {
           e[i] = a.get(i);
       }


       for(int i = 0 ; i < e.length - 1 ; i++)
       {


           if( e[i].charAt(0) > e[i + 1].charAt(0))
           {
                String temp = e[i];
               e[i] = e[i + 1];
               e[i + 1] = temp;

               i = - 1;
           }


       }

       return e;

    }

//    returnUnique([5, 4, 5, 1, 4, 3, 4, 6, 6, 6]) ➞ [1, 3]
//
//    returnUnique([1, 2, 1, 3, 1, 7, 1, 9, 7, 9]) ➞ [2, 3]
//
//    returnUnique([9, 5, 6, 8, 7, 7, 1, 1, 1, 1, 1, 9, 8]) ➞ [5, 6]

    public static int[] returnUnique(int[] n)
    {
        HashMap<Integer,Integer> m = new HashMap<>();
        ArrayList<Integer> k = new ArrayList<>();
        int [] r = new int[2];

        for(int i : n)
        {
            if(m.containsKey(i))
                m.put(i,m.get(i) + 1);
            else
                m.put(i,1);

        }

        for(int j : m.keySet())
        {
            if(m.get(j) < 2)
                k.add(j);

        }

        for(int i = 0 ; i < k.size(); i++)
        {
            r[i] = k.get(i);
        }


        return r;

    }

//    closestPalindrome(887) ➞ 888
//
//    closestPalindrome(100) ➞ 99
//// 99 and 101 are equally distant, so we return the smaller palindrome.
//
//    closestPalindrome(888) ➞ 888
//
//    closestPalindrome(27) ➞ 22

    public static  int closestPalindrome(int num)
{

    for(int i = num , j = num ; i < num + num && j > 0 ; i++ , j-- )
    {
        if(String.valueOf(j).equals(String.valueOf(new StringBuilder(String.valueOf(j)).reverse().toString())))
            return j;
        else if(String.valueOf(i).equals(String.valueOf(new StringBuilder(String.valueOf(i)).reverse().toString())))
            return i;
    }

    return -1;


}

public static int closestPalindrome1(int num)
{
    int i = num;
    int j = num;
    while( i < num + num && j > 0 )
    {
        if(reversePalindrome(j))
            return j;
        else if (reversePalindrome(i))
            return i;

        i++;
        j--;

    }

    return -1;
}

public static boolean reversePalindrome(int k )
{
    int start = 0 ;
    int end = String.valueOf(k).length() - 1;

    char t [] = String.valueOf(k).toCharArray();

    while(start < end)
    {
        if(t[start] != t[end])
            return false;

        start++;
        end--;

    }

    return true;
}


//    isAlphabeticallySorted("Paula has a French accent.") ➞ true
//// "accent" is alphabetically sorted.
//
//    isAlphabeticallySorted("The biopsy returned negative results.") ➞ true
//// "biopsy" is alphabetically sorted.
//
//    isAlphabeticallySorted("She sells sea shells by the sea shore.") ➞ false

// Although "by" is alphabetically sorted, it is only 2 letters long.


    public static boolean isAlphabeticallySorted(String sentence)
    {
        sentence = sentence.replace(".","");
  String [] s = sentence.split(" ");
        for( String h : s)
        {
                if(alphaOrdered(h))
                return true;
        }

        return false;

    }

    public static boolean alphaOrdered(String s)
    {

        for(int i = 0 ; i < s.length() - 1 ; i++)
        {
            if( s.charAt(i) > s.charAt(i + 1))
                return false;

        }

        if(s.length() > 2)
            return true;


        return false;
    }

//    countLoneOnes(101) ➞ 2
//
//    countLoneOnes(1191) ➞ 1
//
//    countLoneOnes(1111) ➞ 0
//
//    countLoneOnes(462) ➞ 0

    public static int countLoneOnes(long n)
    {
        char t [] = String.valueOf(n).toCharArray();
        int count = 0 ;
       if(t.length % 2 == 0 )
       {
           for (int i = 0; i < t.length - 1; i = i + 2) {
               if ((t[i] != t[i + 1]) && (t[i] == '1' || t[i + 1] == '1'))
                   count++;

           }
       }
      else {
           for (int i = 0; i < t.length - 1; i++) {
               if ((t[i] != t[i + 1]) && (t[i] == '1' || t[i + 1] == '1'))
                   count++;

           }
       }
return count;
    }

//    split("()()()") ➞ ["()", "()", "()"]
//
//    split("((()))") ➞ ["((()))"]
//
//    split("((()))(())()()(()())") ➞ ["((()))", "(())", "()", "()", "(()())"]
//
//    split("((())())(()(()()))") ➞ ["((())())", "(()(()()))"]

    public static String[] split(String str)
    {
            ArrayList<String> a =new ArrayList<>();
            StringBuilder s =new StringBuilder();
            int openingCount = 0;

            for(int i = 0 ; i < str.length() ; i++)
            {
                if(str.charAt(i) == '(') {
                    s.append(str.charAt(i));
                    openingCount++;

                }else {
                    s.append(str.charAt(i));
                    openingCount--;
                }

                if(openingCount == 0 ) {
                    a.add(s.toString());
                    s.delete(0,s.length());

                }


            }

            String h []= new String[a.size()];

            for(int i = 0 ; i < a.size() ; i++)
            {
                h[i] = a.get(i);
            }

            return h;
    }


    //    array[]={-40,-5,1,3,6,7,8,20};
//    The pair whose sum is closest to 5 :  1 and 3

    public static void closestSum(int n[], int m )
    {
        int sum[] = new int[2];
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n.length ; i++)
        {

        }
        

    }


//    Input: arr[] = { 2, 1, 6, 4 }
//    Output: 1
//    Explanation:
//    Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
//    Therefore, the required output is 1.
//
//
//    Input: arr[] = { 1, 1, 1 }
//    Output: 3
//    Explanation:
//    Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]






    public static int getEqualArray(int a[])
    {
        int elements = a.length - 1;
        int passingArray []= new int [elements];
        int countTimes = 0;

        for(int i = 0 ; i < a.length ; i++)
        {
               int count = 0 ;
            for(int j = 0 ; j < a.length ; j++)
            {
                if(j != i) {
                    passingArray[count++] = a[j];
                }
            }

            if(checkEquality(passingArray))
                countTimes++;

            count = 0;

        }

        return countTimes;
    }
public static boolean checkEquality(int n [])
{
    int oddCount = 0 ;
    int evenCount = 0 ;

    for(int i = 0 ; i < n.length ; i++)
    {
        if(i % 2 == 0)
        {
            evenCount = evenCount + n[i];
        }
        else
        {
            oddCount = oddCount + n[i];
        }
    }

    if(oddCount == evenCount)
        return true;

    return false;

}

    public static int longestSubarray(int[] arr, int k)
    {
       int length = 0;

        for(int i = 0 ; i < arr.length ; i++)
        {
            int count = 0 ;
            count = count + arr[i];
            for(int j = i + 1 ; j < arr.length ; j++)
            {

             count = count + arr[j];

                if(count == k ) {
                    length = length + (j - i + 1);
                    break;

                }

            }



        }

        return length;
    }


// 1 2 4 5
    // 5,6,8,9,10  --> 38  21 -17
    public static void missingNumber(int n[])

    {
        int arrayLength = n.length;
        int newArray[] = new int[arrayLength + 1];

        for(int i = 0 ; i < newArray.length - 1 ; i++)
        {
            newArray[i] = n[i];

        }

//  int expectedSum = n * (first + last) / 2; AP arithmetic progression
        
    }

//    Input: arr[] = [1, 5, 4, 3]
//    Output: 6
//    Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2. Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.
//    Input: arr[] = [3, 1, 2, 4, 5]
//    Output: 12
//    Explanation: 5 and 3 are 4 distance apart. So the size of the base is 4. Height of container = min(5, 3) = 3. So, total area to hold water = 4 * 3 = 12.
//    Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
//    Output: 25  JG SG

    public static int maxWater(int arr[]) {

            int maxWater = Integer.MIN_VALUE;
            int maxContained = Integer.MIN_VALUE;

    //        for(int i = 0 ; i < arr.length ; i++)
    //        {
    //            for(int j = 0 ; j < arr.length ; j++)
    //            {
    //                maxWater = Math.min(arr[i],arr[j]);
    //                maxWater = maxWater * (Math.abs(j - i ));
    //
    //                maxContained = Math.max(maxContained,maxWater);
    //
    //            }
    //
    //        }
            int start = 0 ;
            int end = arr.length - 1;

            while ( start < end)
            {
                maxWater = Math.min(arr[start],arr[end]) * (end - start);

                maxContained = Math.max(maxContained,maxWater);

                if(arr[start] < arr[end])
                 start++;
                else
                    end--;

            }

    return maxContained;

    }


//    Input: s = "geeksforgeeks"
//    Output: 7
//    Explanation: "eksforg" is the longest substring with all distinct characters.
//    Input: s = "aaa"
//    Output: 1
//    Explanation: "a" is the longest substring with all distinct characters.
//    Input: s = "abcdefabcbb"
//    Output: 6
//    Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.

//    public static int longestUniqueSubstr(String s)
//    {
//      int start = 0 ;
//      int end = 0 ;
//      HashMap<Character,Integer> m = new HashMap<>();
//      char t[] = s.toCharArray();
//      int max = Integer.MIN_VALUE;
//
//      while(end < s.length())
//      {
//          if(m.containsKey(t[end]))
//              m.put(t[end],m.get(t[end]) + 1);
//          else
//              m.put(t[end], 1);
//
//           if(m.size() < end + start - 1)
//           {
//               while(m.size() < end - start + 1)
//               {
//                   int value = m.get(t[start]);
//                    value = value - 1;
//
//                    m.put(t[start], value);
//
//
//               }
//           }
//
//
//
//      }
//
//
//
//    }

//    anaStrStr("car", "race") ➞ true
//
//    anaStrStr("nod", "done") ➞ true
//
//    anaStrStr("bag", "grab") ➞ false


//    public static boolean anaStrStr(String needle, String haystack)
//    {
//   HashMap<Character,Integer> m = new HashMap<>();
//
//      for(int i = 0 ; i < needle.length() ; i ++)
//      {
//          if(m.containsKey(needle.charAt(i)))
//              m.put(needle.charAt(i),m.get(needle.charAt(i) + 1));
//          else
//              m.put(needle.charAt(i), 1);
//
//      }
//      for(int i = 0 ; i < haystack.length() ;i++)
//      {
//          if(haystack.charAt(i) )
//      }
//
//
//
//    }


//    canBuild("aPPleAL", "PAL") ➞ true
//
//    canBuild("aPPleAL", "apple") ➞ false
//
//    canBuild("a", "") ➞ true
//
//    canBuild("aa", "aaa") ➞ false


    public static boolean canBuild(String str1, String str2)
    {
        HashMap<Character,Integer> m = new HashMap<>();
        if(str2.isEmpty() && !str1.isEmpty())
            return true;


        for(int i = 0 ; i < str1.length() ; i++)
        {
            if(m.containsKey(Character.isUpperCase(str1.charAt(i))))
                m.put(str1.charAt(i),m.get(str1.charAt(i)) + 1);

            else if(Character.isUpperCase(str1.charAt(i)))
                m.put(str1.charAt(i),1);

        }
        for(int i = 0 ; i < str2.length() ; i++)
        {
            if(m.containsKey(str2.charAt(i)))
                m.put(str2.charAt(i),m.get(str2.charAt(i)) - 1);

            else
                m.put(str2.charAt(i),1);

        }

        for(char i : m.keySet())
        {
            if(m.get(i) > 0 || m.isEmpty() || m.get(i) < 0 )
                return false;

        }


        return true;
    }

//    lcmThree([9, 18, 27]) ➞ 54
//
//    lcmThree([23, 46, 2]) ➞ 46
//
//    lcmThree([5, 7, 13]) ➞ 455

    public static int lcmOfThree(int[] arr) {

        int maxValue = 0;
        for(Integer i: arr){
            if(i> maxValue){
                maxValue = i;
            }
        }

        int theValue = 0;
        int i = 1;
        while (true) {
            if((maxValue * i) % arr[0] == 0 &&  (maxValue * i) % arr[1] == 0 &&  (maxValue * i) % arr[2] == 0){
                theValue = maxValue * i;
                return theValue;
            }
            i++;
        }
    }

    public static int lcmOfThree1 (int[] arr) {
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            n = lcm(arr[i], n);
        }
        return n;
    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

//    primeNumbers(10) ➞ 4
//// 2, 3, 5 and 7
//
//    primeNumbers(20) ➞ 8
//// 2, 3, 5, 7, 11, 13, 17 and 19
//
//    primeNumbers(30) ➞ 10
//// 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29

    public static int primeNumbers(int num)
    {
        int count = 0 ;

       for(int i = 2 ; i < num ; i++)
       {
              if(isPrime(i))
                  count++;
       }
       return count;

    }


    public static boolean isPrime(int j )
    {
        boolean prime = true;
        for(int i = 2 ; i <= j/2 ; i++)
        {
            if( j % i == 0 )
                prime = false;

        }

        return prime ? true : false;

    }


//    duplicateCount("abcde") ➞ 0
//
//    duplicateCount("aabbcde") ➞ 2
//
//    duplicateCount("Indivisibilities") ➞ 2
//
//    duplicateCount("Aa") ➞ 0
//// Case sensitive

    public static int duplicateCount(String str)
    {
        HashMap<Integer,Integer> m = new HashMap<>();
        int count = 0;

        for(int i = 0 ; i < str.length() ; i++)
        {
            if(m.containsKey((int )str.charAt(i)))
                m.put((int )str.charAt(i),m.get(( int )str.charAt(i)) + 1);

            else
                m.put((int )str.charAt(i),1);


        }


        for(int i : m.keySet())
        {
            if(m.get( i ) > 1)
                count++;
        }


        return count ;
    }

//    getCoinBalances(["share"], ["share"]) ➞ [5, 5]
//// Both people spend one coin, and receive 3 coins each.
//
//    getCoinBalances(["steal"], ["share"]) ➞ [6, 2]
//// Person 1 gains 3 coins, while person 2 loses a coin.
//
//    getCoinBalances(["steal"], ["steal"]) ➞ [3, 3]
//// Neither person spends any coins and so no one gets rewarded.
//
//    getCoinBalances(["share", "share", "share"], ["steal", "share", "steal"]) ➞ [3, 11]


    public static int[] getCoinBalances(String[] r, String[] b)
    {
        int share = 1;
        int steal = 3;
        int left = 3;
        int right = 3;
        int bonus = 3;

        for(int i = 0 ; i < r.length ; i++)
        {
            if(r[i] == "share" && b[i] == "share" ) {
                left = left - share + bonus;
                right = right - share + bonus;
            }
            else if(r[i] == "steal" && b[i] == "steal") {
                left = left + steal;
                right = right + steal;

            }
          else if(r[i] == "share" && b[i] =="steal")
            {
                left = left - share;
                right = right + steal;
            }
          else if (r[i] == "steal" && b[i] =="share")
            {
                left = left + steal;
                right = right - share;
            }


        }


        return new int []{left,right};
    }

    public static int[] getCoinBalances1(String[] r, String[] b) {
        int profit = 3;
        int loss = 1;
        int coins[] = new int[]{3, 3};

        for (int i = 0; i < r.length; i++) {
            if (r[i].contains("share") && b[i].contains("share")) {
                coins[0] = coins[0] + profit - 1;
                coins[1] = coins[1] + profit - 1;
            } else if (r[i].contains("share") && b[i].contains("steal")) {
                coins[0] = coins[0] - 1;
                coins[1] = coins[1] + 3;
            } else if (r[i].contains("steal") && b[i].contains("share")) {
                coins[0] = coins[0] + 3;
                coins[1] = coins[1] - 1;
            }

        }

        return coins;
    }

    // 2,3,4,5,6,7,8
    public static int[] rotateArray(int a[], int index)
    {
        int start = index;
        int end = a.length - 1;

        while(start < end)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

        return a;
    }


 //   1,2,3,4,5,6,7

    public static void rotateIndex(int a[], int index)
    {
        int end = a[a.length - 1];
        for(int i = index ; i < a.length - 1 ; i++)
        {
            int temp = a[index + 1];
            a[index + 1] = a[index];

        }
        a[index] = end;



        for(int i: a)
            System.out.print(" "+ i);
    }

    public static int [] arrayrotate4(int a[]) {
        for (int j = 0; j < 3; j++) {
            int first = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];

                System.out.println("-->"+Arrays.toString(a));
            }
            a[a.length - 1] = first;
        }
        return a;
    }


        public static int[] rightRotated5(int a[], int n) {
            for (int i = 0; i < n; i++) {
                int last = a[a.length - 1];

                for (int j = a.length - 1; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = last;

            }
            return a;
        }



        // 1 .2 3 4 5 6 7

    public static void rightRotatedArray(int a[])
    {
        for(int i = 0 ; i < 3 ; i++)
        {
            int last = a[a.length - 1];
            for(int j = a.length - 1 ; j > 0 ; j--)
            {

                a[j] = a[j - 1];
            }

            a[0] = last;
        }
    }


//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]

    public int[] twoSum(int[] nums, int target)
    {
        int sum = 0 ;

        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {

                sum = target - nums[i];

                if(m.containsKey(sum))
                    return new int []{m.get(sum),i};
                else
                m.put(nums[i],i);

        }

        return new int []{};

    }



//    Input: x = -121
//    Output: false
//    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    public static boolean isPalindrome(int x)
    {
        int start = 0 ;
        int end = String.valueOf(x).length() - 1;

        char t[] = String.valueOf(x).toCharArray();
        while(start < end)
        {
            if(t[start] != t[end])
                return false;
            else
                start++;
               end--;
        }

        return true;
    }



    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
      int firstArray = 0 ;
      int secondArray = 0;
      int mergedArray[] = new int[nums1.length + nums2.length];
      int k = 0;
      while (firstArray < nums1.length && secondArray < nums2.length)
      {
          if(nums1[firstArray] < nums2[secondArray])
          {
              mergedArray[k++] = nums1[firstArray];
              firstArray++;
          }
          else if(nums1[firstArray] > nums2[secondArray])
          {
              mergedArray[k++] = nums2[secondArray];
              secondArray++;

          }
          else
          {
              mergedArray[k++] = nums1[firstArray];
              mergedArray[k++] = nums2[secondArray];
              firstArray++;
              secondArray++;
          }


      }

      while( firstArray != nums1.length) {
          mergedArray[k++] = nums1[firstArray];
          firstArray++;
      }
        while( secondArray != nums2.length) {
            mergedArray[k++] = nums2[secondArray];
            secondArray++;
        }

        System.out.println("new merged array -->"+Arrays.toString(mergedArray));
        double median  = 0;
        double sum = 0 ;

        if(mergedArray.length % 2 != 0  )
        {
             return mergedArray[Math.round(mergedArray.length / 2)];
        }
        else
        {
            double first = mergedArray[mergedArray.length / 2  - 1];
            double middle = mergedArray[mergedArray.length / 2];


            return (first + middle )/ 2;


        }




    }

public static void factorial()
{
    Scanner s = new Scanner(System.in);
    long j = s.nextLong();
    BigInteger fact = BigInteger.ONE;

        if(j == 0) {
            System.out.println(1);
            return;
        }
        else if (j < 0 ) {
            System.out.println("not defined");
            return ;
        }
    for(int i = 1 ; i <= j ; i++)
    {
     fact = fact.multiply(BigInteger.valueOf(i));
    }
    System.out.println(String.valueOf(fact));
}


public static int factorailRecur(int i )
{

    if(i == 0 )
        return 1 ;

    int fact = 1 ;

    return i * factorailRecur( i - 1);

}

//    Input: "swiss"
//    Output: "w"

    public static char firstNonRepeating(String s)
    {
        HashMap<Character,Integer> m = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++)
        {
            if(m.containsKey(s.charAt(i)))
                m.put(s.charAt(i),m.get(s.charAt(i)) + 1);
            else
                m.put(s.charAt(i),1);
        }

        for(char t : m.keySet())
        {
            if(m.get(t) == 1)
                return t;
        }

        return ' ';
    }

//    Input: [1, 2, 3, 4, 5], k = 2
//    Output: [4, 5, 1, 2, 3]

    public static void rotateArray1(int a[], int k )
    {
        for(int i = 0 ; i < k ; i++)
        {
            int end = a[a.length - 1];

            for(int j = a.length - 1 ; j > 0 ; j--)
            {
                 a[j] = a[j - 1];

            }
            a[0] = end;

        }

        System.out.println(Arrays.toString(a));


    }


//    plaintext
//    Copy code
//    Input: [[1,3], [2,6], [8,10], [15,18]]
//    Output: [[1,6], [8,10], [15,18]]




}



