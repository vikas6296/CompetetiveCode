package org.example;

import java.util.*;


public class Misc {

    public static void main(String s[]) {
       // generateString(4, new String[]{"x", "t"});


      //  collect("intercontinentalisationalism",6);

       // lcmOfThree(new int []{2,4});

        //memeSum(122,81);

        //check();

       // characterMapping("hohoho");

       // System.out.println(sentenceSearcher("For the love of Tesh. She is the love of my life. I am all hers.","LOVE"));

       // System.out.println( canBuild("aa","aaa"));

       // System.out.println(allTruthy(new Object[]{"t", "te", "tes", "tesh", "tesha"}));

       // arrangingNumbers(new int []{4,7,0 ,-4,-1,-9,0,3,8});

        //tictactoe(new int [][]{{0,0},{2,0},{1,1},{2,1},{2,2}});

        System.out.println(threeSumClosest(new int []{-1,2,1,-4},1));
    }


    //    generateString(3, ["j", "h"]) ➞ "j, h, hj"
//
//    generateString(5, ["e", "a"]) ➞ "e, a, ae, aea, aeaae"
//
//    generateString(6, ["n", "k"]) ➞ "n, k, kn, knk, knkkn, knkknknk"
//
//    generateString(1, ["f", "g"]) ➞ "invalid"
    public static String generateString(int n, String[] s) {
        List<String> li = new ArrayList<>();
        if (n < 2)
            return "invalid";

        String o[] = new String[n];

        o[1] = s[1];
        o[0] = s[0];
        o[2] = o[1] + o[0];

        for (int i = 3; i < n; i++) {
            o[i] = o[i - 1] + o[i - 2];
        }

        String u = "";
        for (int i = 0; i < o.length; i++) {
            u = u + o[i] ;
            if(i != o.length - 1)
                u = u + ", ";
        }

        System.out.println("string -->"+u);

        return u;
    }


//    maxPossible(523, 76) ➞ 763
//
//    maxPossible(9132, 5564) ➞ 9655
//
//    maxPossible(8732, 91255) ➞ 9755


//    isNew(3) ➞ true
//
//    isNew(30) ➞ true
//
//    isNew(321) ➞ false
  //  869 is not a new number because it is just a permutation of smaller numbers, 689 and 698.

//    getLuckiest([-544, 666, -645, -445]) ➞ -445
//
//    getLuckiest([5, 12, 55, 11]) ➞ 55
//
//    getLuckiest([5, 12, -55,  11]) ➞ -55

    public static void getLuckiest(int[] r)
    {
        Map<Character, Integer> m = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < r.length ; i++)
        {
            char t [] = String.valueOf(r[i]).toCharArray();
            for(int j = 0 ; j < t.length ; j++)
            {
                if(m.containsKey(t[j]))
                    m.put(t[j],m.get(t[j]) + 1);
                else 
                    m.put(t[j],1);


            }
            if(m.get('5') >= 1)
                max = Math.max(max, t[i]);

        }


    }



//    collect("intercontinentalisationalism", 6)
//➞ ["ationa", "interc", "ntalis", "ontine"]
//
//    collect("strengths", 3)
//➞ ["eng", "str", "ths"]


    public static void collect(String s, int n)
    {
        List<String> l = new ArrayList<>();
        int j = 3 ;
        for(int i = 0 ; i < s.length() ; i = i + n)
        {
            l.add(s.substring(i,j));
            j = j + i;
        }

        String d[] = new String[l.size()];

        for(int i = 0 ; i < l.size() ; i++)
        {
            d[i] = l.get(i);
        }

        System.out.println("array before sorting --->");
        for(String f : d)
            System.out.println(" "+f);

        Arrays.sort(d);

        System.out.println("array after sorting --->");
        for(String f : d)
            System.out.println(" "+f);

        for (int i = 0; i < d.length - 1; i++) {
            if (d[i].charAt(0) > d[i + 1].charAt(0)) {
                String t = d[i];

                d[i] = d[i + 1];

                d[i + 1] = t;
                i = -1;
            }

        }

        System.out.println("array after sorting --->");
        for(String f : d)
            System.out.println(" "+f);

    }



   // lcmThree([9, 18, 27]) ➞ 54

    public static void lcmOf1Three(int[] arr)
    {

      int max = Integer.MIN_VALUE;
      for(int i = 0 ; i < arr.length ; i++)
      {
          max = Math.max(max,arr[i]);
      }

      int lcm = 1;
      int startElement = 2;
      int nextElement  = 1;
      boolean allElementsFlag = false;


      while(!allElementsFlag)
      {
          for(int i = 0 ; i < arr.length ; i++)
          {
              if(arr[i] % startElement == 0)
              {
                  arr[i] = arr[i] / startElement;
                  nextElement = startElement;
              }

          }

          for(int i =  0 ; i < arr.length ; i++)
          {
              System.out.print(" "+arr[i]);
          }

          lcm = lcm * nextElement;

         // System.out.println("lcm -->"+lcm);

          for(int i = 0 ; i < arr.length ; i++)
          {
              if(arr[i] != 1) {
                  allElementsFlag = false;
                  break;
              }
              else
                  allElementsFlag = true;
          }

          startElement++;

      }


        System.out.println("LCM of the array is :: "+lcm);
    }

    public static void lcmOfThree(int[] arr) {

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

            }
            i++;
        }
    }

    //memeSum(1222, 30277) ➞ 31499

    public static void memeSum(int a, int b)
    {
        int endFirst = String.valueOf(a).length();
        int endLast = String.valueOf(b).length();
        endFirst  = endFirst - 1;
        endLast = endLast -1;
       String sum ="" ;

        while (endFirst >= 0 && endLast >= 0 )
        {
            int i = Character.getNumericValue(String.valueOf(a).charAt(endFirst));

            int j = Character.getNumericValue(String.valueOf(b).charAt(endLast));

            int k = i + j;
            sum =  k + sum;

            endFirst--;
            endLast--;

        }

         while (endFirst >= 0)
         {
             sum =  Character.getNumericValue(String.valueOf(a).charAt(endFirst)) + sum;
             endFirst --;
         }
         while(endLast >= 0)
         {
             sum = Character.getNumericValue(String.valueOf(b).charAt(endLast)) + sum;
             endLast--;
         }


     // return Integer.parseInt(sum);
    }


    public static void check ()
    {
        String s ="";
        String v = "vikas";
        for(int i = 0 ; i < v.length() ; i++)
        {

            s =  v.charAt(i) + s;
        }

        System.out.println("value of s-->"+s);
    }


//    characterMapping("abcd") ➞ [0, 1, 2, 3]
//
//    characterMapping("abb") ➞ [0, 1, 1]


    public static void characterMapping(String str)
    {

        List<Integer> l = new ArrayList<>();
        int count = -1 ;
        HashMap<Character,Integer> m = new HashMap<>();

        for(int i = 0 ; i < str.length() ; i++) {
            if (!m.containsKey(str.charAt(i))) {
                m.put(str.charAt(i),++count);
                l.add(m.get(str.charAt(i)));

            } else {
                l.add(m.get(str.charAt(i)));


            }
        }

        int a[] = new int [l.size()];
        for(int i = 0 ; i < l.size() ; i++)
        {
            a[i] = l.get(i);
        }
        System.out.println("value of list -->"+l);
        for(int n : a)
        {
            System.out.print(" "+n);
        }
       // return a;
    }


//    closingInSum(121) ➞ 13
//// 11 + 2
//
//    closingInSum(1039) ➞ 22
//// 19 + 3



//    sentenceSearcher(str1, "LOVE") ➞ "For the love of Tesh."
//
//    sentenceSearcher(str1, "LIFE") ➞ "She is the love of my life."

    public static String sentenceSearcher(String s, String w)
    {
        HashMap<String,Integer> m = new HashMap<>();
        String h [] = s.split("[.]");
        int count = 0 ;

        for(String f : h)
        {
            m.put(f,count++);

        }

     for(String f : m.keySet())
     {

         if(f.contains(w))
             return f+".";
     }


     return "";

    }


//    canBuild("aPPleAL", "PAL") ➞ true
//
//    canBuild("aPPleAL", "apple") ➞ false
//
//    canBuild("a", "") ➞ true

    public static boolean canBuild(String str1, String str2)
    {

        if(str2.isEmpty())
            return true;

        HashMap<Character,Integer> m = new HashMap<>();


        for(int i = 0 ; i < str2.length() ; i++)
        {
            if(m.containsKey(str2.charAt(i)))
                m.put(str2.charAt(i), m.get(str2.charAt(i)) + 1);

            else
                m.put(str2.charAt(i),1);
        }

        System.out.println("value of hashmap -->"+m);

        for(int i = 0; i < str1.length() ; i++)
        {
            if(m.containsKey(str1.charAt(i)))
                m.put(str1.charAt(i),m.get(str1.charAt(i)) - 1);

        }
        System.out.println("value of hashmap -->"+m);

        for(char t : m.keySet())
        {

            if(m.get(t) > 0)
                return false;

        }

        return true;
    }

//    doesRhyme("Sam I am!", "Green eggs and ham.") ➞ true
//
//    doesRhyme("Sam I am!", "Green eggs and HAM.") ➞ true
//// Capitalization and punctuation should not matter.
//
//    doesRhyme("You are off to the races", "a splendid day.") ➞ false

    public static boolean doesRhyme(String str1, String str2)
    {
        String e[]= str1.split(" ");
        String d[]= str2.split(" ");


        HashMap<Character,Integer> m = new HashMap<>();


        for(int i = 0 ; i < str1.length() ; i++)
        {
            if(m.containsKey(str1.charAt(i)))
                m.put(str1.charAt(i), m.get(str1.charAt(i)) + 1);

            else
                m.put(str1.charAt(i),1);
        }

        System.out.println("value of hashmap -->"+m);

        for(int i = 0; i < str2.length() ; i++)
        {
            if(m.containsKey(str1.charAt(i)))
                m.put(str2.charAt(i),m.get(str2.charAt(i)) - 1);

        }
        System.out.println("value of hashmap -->"+m);

        for(char t : m.keySet())
        {

            if(m.get(t) > 0)
                return false;

        }

        return true;


    }


    //Falsy values include false, 0, "" (empty string), null,
    // POSITIVE_INFINITY,
    // NEGATIVE_INFINITY and NaN, everything
    // else is truthy.

    public static boolean allTruthy(Object... values)
    {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;




        for(int i = 0 ; i < values.length;i++)
        {
            if(values[i]=="" || (boolean)values[i] == false || (int)values[i] == 0 || values[i] == null || (int)values[i] == max
            || (int)values[i] == min || values[i] == "NaN" )
               return false;

        }

        return true;



    }


    public static void arrangingNumbers(int g [])
    {

        List<Integer> m = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        List<Integer> o = new ArrayList<>();

        for(int h : g)
        {
            if(h > 0 )
                m.add(h);
            else if( h < 0)
                n.add(h);
            else
                o.add(h);

        }

        int index = 0;

        for(int y : m)
        {
            g[index++] = y;
        }

        for(int e : o)
        {
            g[index++] = e;
        }


        for(int k : n)
        {
            g[index++] = k;

        }


        for(int u : g)
        {
            System.out.print(" "+u);
        }
    }


 //  [[0,0],[2,0],[1,1],[2,1],[2,2]]
    public static void tictactoe(int[][] moves)
    {
       /* for(int [] pair : moves)
        {
            int x = pair[0];
            int y = pair[1];

            System.out.println("x : " + x  + ", y: " + y );
        }*/

        for(int i = 0 ; i < moves.length ; i++)
        {
            for(int j = 0 ; j < moves[0].length ;j++)
            {
                System.out.print(moves[i][j] +" ");

            }
            System.out.println();
        }

        int grid [][] = new int[3][3];



    }

    public Triangle triangleType(int[] nums) {

        int firstSide = nums[0];
        int secondSide = nums[1];
        int thirdSide = nums[2];

        if(firstSide + secondSide > thirdSide && firstSide +  thirdSide > secondSide && secondSide + thirdSide > firstSide )
        {
            if(firstSide == secondSide && secondSide == thirdSide)
                return Triangle.equilateral;

            else if(firstSide == secondSide && firstSide != thirdSide || secondSide == thirdSide && firstSide != thirdSide  )
                return Triangle.isosceles;

            else if(firstSide != secondSide && secondSide != thirdSide )
                return Triangle.scalene;


        }

        else
            return Triangle.none;




return null;

    }





    public enum Triangle
    {
        equilateral,
        scalene,
        isosceles,
        none

    }


    public static  int threeSumClosest(int[] nums, int target)
    {
         Arrays.sort(nums);

         int maxDifference = Integer.MIN_VALUE;

         for(int i = 0 ; i < nums.length - 2 ; i++)
         {
             if(i > 0 && nums[i] == nums[i - 1])
                 continue;

             int start = 0;
             int end = nums.length - 1;

             while(start < end)
             {
                 int currentSum = nums[i] + nums[start] + nums[end];
                 int currentDifference = currentSum - target ;

                 maxDifference = Math.max(maxDifference,currentDifference);


                 if(currentSum > target)
                 {
                     while(nums[start] == nums[start + 1] && nums[end] == nums[end - 1])
                     {
                         start++;
                         end--;
                     }

                     end--;

                 }

                 else if(currentSum < target)
                     start++;


                 else
                     return maxDifference;


             }




         }

return -1;

    }



}