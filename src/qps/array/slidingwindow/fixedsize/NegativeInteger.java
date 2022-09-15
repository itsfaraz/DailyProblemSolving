package qps.array.slidingwindow.fixedsize;

import java.util.LinkedList;
import java.util.Queue;

public class NegativeInteger {

    /*
        Given an array find out first negative integer in
        k size of sub-array and print
        Example :
        Input  : arr = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
        Output : -1 -1 -7 -15 -15 0
        Note : If some sub-array does not contain negative integer print 0
     */

    public static void main(String[] args) {

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
//        kNegativeIntegersBrute(arr,k);
//        kNegativeIntegersAverage(arr, k);
        kNegativeIntegerOptimized(arr,k);
    }

    public static void kNegativeIntegersBrute(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < i + k; j++){
                if (j == (i+k)-1 && j < arr.length){
                    System.out.println(findNegativeInteger(i,j,arr));
                }
            }
        }
    }

//    Time Complexity :- O(n+k)
    public static void kNegativeIntegersAverage(int[] arr, int k) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            int windowSize = (j - i) + 1;
            if (windowSize < k) {
                j++;
            } else if (windowSize == k) {
                System.out.print(findNegativeInteger(i, j, arr) + " ");
                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    public static void kNegativeIntegerOptimized(int[] arr, int k){
        int i = 0;
        int j = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        while (j < arr.length) {
            int windowSize = (j - i) + 1;
            if (arr[j] < 0){
                queue.add(arr[j]);
            }
            if (windowSize < k) {
                j++;
            } else if (windowSize == k) {
                int result = 0;
                if (queue.isEmpty())
                    result = 0;
                else{
                    result = queue.peek();
                    if (queue.contains(arr[i]))
                        queue.remove(arr[i]);
                }
                System.out.print(result+" ");

                i++;
                j++;
            } else {
                i++;
            }
        }

    }

    public static int findNegativeInteger(int start, int end, int[] arr) {
        for (int i = start; i < end; i++) {
            if (arr[i] < 0)
                return arr[i];
        }
        return 0;
    }

}
