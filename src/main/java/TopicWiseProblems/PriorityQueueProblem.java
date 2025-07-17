package org.example;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class PriorityQueueProblem
{
    public static void main(String []a)
    {
        //System.out.println(findKthLargest(new int []{3 ,4 ,1 ,5 , 7, 2 ,9},2));

       // System.out.println(Arrays.toString(topKFrequent(new int []{4, 4, 4,4, 6, 6, 1, 1, 2, 2, 2},2)));

       // System.out.println(Arrays.toString(maxSubsequence(new int []{-1,-2,3,4},3)));
    }

//  3 ,4 1 ,5 , 7, 2 9
    public static int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int i : nums)
        {
            p.add(i);

            if(p.size() > k)
            {
                p.poll();
            }


        }

        return p.peek();
    }


    // 1 2 ,3 ,3 ,3 ,3 ,4 ,5,7


//    nums = [4, 4, 4, 6, 6, 1, 1, 2, 2, 2]
//    k = 2
//
//    Expected Output:
//        [4, 2] (or [2, 4]) → since 4 and 2 have highest frequencies

    public static  int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i : nums)
        {
            m.put(i , m.getOrDefault(i,0) + 1);
        }




        System.out.println("value of hashmap of m --> "+ m);




        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });


        System.out.println("value of min heap --> " + pq);

        for(Map.Entry<Integer,Integer> mp : m.entrySet())
        {
            pq.offer(mp);
               if( pq.size() > k)
               {
                   pq.poll();
               }


        }

        int count = 0;
        int a[] = new int[pq.size()];

        while(!pq.isEmpty())
        {
            a[count] = pq.poll().getKey();
            count++;

        }



        System.out.println("value of min heap --> " + pq);


        return a;

    }


//    public static void checkArrays()
//    {
//        int a[]={4,1,3,7,2,9};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//
//        Arrays.sort(a,Collections.reverseOrder());
//
//    }
    public int thirdMax1(int[] nums) {
        Set<Integer> set=new TreeSet<>();
        for(int i:nums)
            set.add(i);
        int n=set.size();
        List<Integer> list=new ArrayList<>(set);
        if(n>=3)
            return list.get(n-3);
        else
            return list.get(n-1);
    }


    public int thirdMax(int[] nums) {
        HashSet<Integer> s = new HashSet<>();

        for(int i : nums)
        {
            s.add(i);
        }
        int j [] = new int[s.size()];

        Iterator<Integer> it = s.iterator();
        int index = 0;

        while(it.hasNext())
        {
            j[index++] = it.next();
        }


        Arrays.sort(j);

        return j.length >= 3 ? j[j.length - 3] : j[j.length - 1];


    }
    public static int[] maxSubsequence(int[] nums, int k) {

        int result [] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();


        for(int i : nums)
        {
            pq.offer(i);

            if(pq.size() > k)
            {
                pq.poll();
            }

        }
        int index = 0;
        while(!pq.isEmpty())
        {
            result[index] = pq.poll();
            index++;

        }



        return result;

    }




}
