package TopicWiseProblems;

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

    public static int getSecondHighestFreqLinear(int[] a) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int first = 0, second = 0;
        for (int freq : freqMap.values()) {
            if (freq > first) {
                second = first;
                first = freq;
            } else if (freq > second && freq != first) {
                second = freq;
            }
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == second) return entry.getKey();
        }

        return -1;
    }

    public static int getParity(String num) {



        String str = String.valueOf(num);
        int len = str.length();
        char res[] = new char[len];
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        ArrayList<Integer> evenIdxs = new ArrayList<>();
        ArrayList<Integer> oddIdxs = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int d = str.charAt(i) - '0';
            if (d % 2 == 0) {
                evenIdxs.add(i);
                even.offer(d);
            } else {
                oddIdxs.add(i);
                odd.offer(d);
            }
        }

        int evenLastIdx = evenIdxs.size() - 1;
        int oddLastIdx = oddIdxs.size() - 1;
        while (even.size() > 0) {
            int val = even.poll();
            res[evenIdxs.get(evenLastIdx)] = (char) (val + '0');
            evenLastIdx--;
        }

        while (odd.size() > 0) {
            int val = odd.poll();
            res[oddIdxs.get(oddLastIdx)] = (char) (val + '0');
            oddLastIdx--;
        }

        return Integer.valueOf(new String(res));

    }

//    Input: amount = [1,4,2]
//    Output: 4
//    Explanation: One way to fill up the cups is:
//    Second 1: Fill up a cold cup and a warm cup.
//        Second 2: Fill up a warm cup and a hot cup.
//        Second 3: Fill up a warm cup and a hot cup.
//        Second 4: Fill up a warm cup.
//    It can be proven that 4 is the minimum number of seconds needed.

    public int fillCups(int[] arr) {
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:arr){
            if(num!=0)
                pq.offer(num);
        }
        while(!pq.isEmpty()){
            while(pq.contains(0))
                pq.remove(0);
            if(pq.isEmpty()) break;
            if(pq.size() > 1){
                res++;
                int a = pq.poll();
                int b = pq.poll();
                pq.offer(a-1);
                pq.offer(b-1);
            }else if(pq.size() == 1){
                res++;
                pq.offer(pq.poll()-1);
            }
        }
        return res;
    }


    public static int[] topKFrequent1(int[] nums, int k) {
        // Step 1: Frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap of size k based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for (int num : freqMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 3: Extract result from heap
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        //window size is always k
        int len = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        Comparator<Integer> c = Comparator.comparingInt((Integer a) -> freqMap.get(a)).thenComparingInt(a -> a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(c);

        //first window
        for(int i=0;i<k;i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        } //freqMap for first window

        for(int key : freqMap.keySet()){
            minHeap.add(key);

            if(minHeap.size() > x) minHeap.poll();
        } //priorityQueue of size k

        int[] sum = new int[len+1-k];

        for(int num:minHeap){
            sum[0] += (num*freqMap.get(num));
        }

        for(int i=k;i<len;i++){//sliding the window
            int left = nums[i-k]; //element to remove
            int right = nums[i]; //element to add

            //removing element at left
            freqMap.put(left, freqMap.get(left) -1);
            if(freqMap.get(left) ==0){
                freqMap.remove(left);
            }

            //adding element at the right
            freqMap.put(right, freqMap.getOrDefault(right, 0)+1);

            //rebuilding the priority Queue
            minHeap.clear();
            for(int key : freqMap.keySet()){
                minHeap.add(key);
                if(minHeap.size() > x) minHeap.poll();
            }

            for(int num:minHeap){
                sum[i+1-k] += (num*freqMap.get(num));
            }
        }

        return sum;
    }
}
