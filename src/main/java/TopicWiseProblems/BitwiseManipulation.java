package TopicWiseProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BitwiseManipulation
{
    public static void main(String []a)
    {
        System.out.println(countEvenAndOdd(new int []{1,3,4,5,6,7,8}));
    }
    public static int addSum(int a,int b)
    {
      while(b != 0)
      {
          int carry = ( a & b ) << 1 ;
          a = a ^ b;
          b = carry;

      }

      return a;

    }

    public int subarrayBitwiseORs(int[] arr) {
        // This set will store all unique OR values found across all subarrays.
        Set<Integer> resultOrs = new HashSet<>();

        // This set stores the distinct ORs of all subarrays ending at the previous position.
        Set<Integer> currentOrs = new HashSet<>();

        for (int x : arr) {
            // `nextOrs` will store the ORs of subarrays ending at the current element `x`.
            Set<Integer> nextOrs = new HashSet<>();

            // The subarray of just the element x gives an OR of x.
            nextOrs.add(x);

            // Compute new ORs by extending previous subarrays with the current element x.
            for (int y : currentOrs) {
                nextOrs.add(x | y);
            }

            // Add all newly found ORs to the main result set.
            resultOrs.addAll(nextOrs);

            // For the next iteration, the current results become the previous results.
            currentOrs = nextOrs;
        }

        return resultOrs.size();
    }

    // bitwise odd and even count

    public static HashMap<String,Integer> countEvenAndOdd(int a[])
    {
        HashMap<String,Integer> m = new HashMap<>();
       for(int i : a)
       {
           if( (i & 1) == 0)
           {
               m.put("even", m.getOrDefault("even",0) + 1);
           }
           else
               m.put("odd", m.getOrDefault("odd",0) + 1);
       }

       return m;
    }


    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long x = 1L * num1 - 1L * num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
        }
        return -1;
    }
}
