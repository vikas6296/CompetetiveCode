package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Matrix
{
//    Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
//    Output: "A"
//    Explanation: A wins, they always play first.

    public static void main(String [] a)
    {
        //System.out.println(tictactoe(new int [][]{{0,0},{2,0},{1,1},{2,1},{2,2}}));

     //   System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int [][]{{9,1,7},{8,9,2},{3,4,6}})));
        rotate(new int [][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public static String tictactoe(int[][] moves)
    {
        int rows [] = new int [3];
        int col [] = new int [3];
        int diagonal = 0 ;
        int antidiagonal = 0 ;

        for(int i = 0 ; i < moves.length ; i++)
        {
            int r = moves[i][0];
            int c = moves[i][1];

            int player = i % 2 == 0 ? 1 : -1;

            rows[r] = rows[r] + player;
            col[c] = col[c] + player;

            if(r == c)
                diagonal = diagonal + player;

            if(r + c == 2)
                antidiagonal = antidiagonal + player;


            if( rows[r] == 3 || col[c] == 3 || diagonal == 3 || Math.abs(antidiagonal) == 3)
                return player == 1 ? "A" : "B";


        }


             return moves.length == 9 ? "DRAW" : "PENDING";

    }



    public static int[] findMissingAndRepeatedValues(int[][] grid)
    {
        int a [] = new int [2];
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(set.contains(grid[i][j]))
                {
                    a[0] = grid[i][j];
                }

                set.add(grid[i][j]);

            }


        }

        int totalSum = 0 ;

        for(int j : set)
        {
            totalSum += j;

        }
        int n = grid.length * grid.length;

        int missingNumber = Math.abs(n * (n + 1) / 2 - totalSum);
        a[1]= missingNumber;


        return new int []{a[0],a[1]};


    }

    public static void rotate(int[][] matrix) {

        // transposing the matrix first

        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[0].length ; j++)
            {
                int temp = matrix[i + 1][j];
                matrix[i + 1][j] = matrix[i][j + 1];
                matrix[i][j + 1] = temp;

            }

        }
// reversin the array

        for(int [] i: matrix)
        {
                int start = 0 ;
                int end = i.length;

                while(start < end)
                {
                    int temp = i[start];
                    i[start] = i[end];
                    i[end] = temp;

                    start++;
                    end--;

                }

        }


        System.out.println(Arrays.toString(matrix));
    }
}
