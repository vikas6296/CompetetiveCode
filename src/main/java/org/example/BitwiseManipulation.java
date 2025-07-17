package org.example;

public class BitwiseManipulation
{
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
}
