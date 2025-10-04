package TopicWiseProblems;

import java.util.Arrays;

public class SortingAlgos {
    public static void sSort(int[] arr) {
        // loop over each element of array
        for (int i = 0; i < arr.length; i++) {
            int mIndex = i;
            int min = arr[i];

            // find smallest index
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    mIndex = j;
                }
            }

            // swap the values of i and smallest element.
            int tmp = arr[i];
            arr[i] = arr[mIndex];
            arr[mIndex] = tmp;
        }
    }

    /**
     * Bubble Sort
     * In bubble sort we push the biggest elements to the end of array by switching pairs of elements
     * if they are not in correct order.
     */
    public static void bSort(int[] arr) {
        // set swapCounter to a non-zero value
        int swapCounter = -1;

        // repeat till the swap counter is not 0
        while (swapCounter != 0) {
            // reset swapCounter to 0
            swapCounter = 0;

            // Look at each adjacent pair
            for (int i = 0; i < arr.length - 1; i++) {
                // if two elements are not sorted swap them and add one to swapCounter
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapCounter++;
                }
            }
        }

    }

// insertion sort in very easy way

    public static int[] insertionSort(int a[])
    {
        for(int i = 1 ; i < a.length ; i++)
        {
            int current = a[i];
            int next = i - 1;

            while(next >= 0 && a[next] > current)
            {
                a[next + 1] = a[next];
                next --;
            }

            a[next + 1] = current;

        }

        return a;
    }

    public static void main(String []a)
    {

        mergeSort(new int []{5,4,1,3,2},0,4);
        //System.out.println(Arrays.toString(insertionSort(new int []{5,2,1,6,3})));
    }

    public static void mergeSort(int a[] ,int left, int right)
    {
        if(left < right)
        {
        int mid = left + right / 2;

        mergeSort(a,left,mid);
        mergeSort(a,mid + 1,right);

        merge(a,left,right,mid);

        }


    }

    public static void merge(int a[],int left , int right , int mid)
    {
       int [] leftHalf = new int [mid - left + 1];
       int [] rightHalf = new int [right - mid];


       for(int i = 0 ; i < leftHalf.length ; i++)
         leftHalf[i] = a[left + i];

       for(int j = 0 ; j < rightHalf.length ; j++)
           rightHalf[j] = a[mid + 1 + j];


       int leftIndex = 0;
       int rightIndex = 0;
       int k = left;

       while(leftIndex < leftHalf.length && rightIndex < rightHalf.length)
       {
           if(leftHalf[leftIndex] <= rightHalf[rightIndex])
               a[k++] = leftHalf[leftIndex++];

           else
               a[k++] = rightHalf[rightIndex++];

       }

       while(leftIndex < leftHalf.length)
       {
           a[k++] = leftHalf[leftIndex++];
       }

       while(rightIndex < rightHalf.length)
       {
           a[k++] = rightHalf[rightIndex++];
       }

    }


    // simple algo quick sort.........
    public static void quickSort(int a[], int low, int high)
    {
        if( low < high)
        {
            int pivot = partitions(a, low , high);

            quickSort(a,low, pivot - 1);
            quickSort(a,pivot + 1, high);


        }

    }

    public static int partitions(int a[], int low, int high)
    {
        int pivot  = a[high];
        int i = low - 1;

        for(int j = low ; j < high ; j++)
        {
            if(a[j] <= pivot) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }
        }

        int temp  = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;

    }


    public int dominantIndex(int[] nums)
    {
        int max = 0 ;
        int secondMax = 0;

        for(int i : nums)
        {
            if(i > max)
            {
                secondMax = max;
                max = i;
            }
            else if(i >= secondMax && i != max)
            {
                secondMax = i;
            }
        }


        if(max / 2 >= secondMax)
        {
            for(int i = 0 ; i < nums.length ; i++)
            {
                if(max == nums[i])
                    return i;
            }

        }

        return -1;

    }

}
