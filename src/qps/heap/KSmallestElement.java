package qps.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestElement {

    /* Given an array find Kth Smallest Element */

    public static void main(String[] args) {
        int []arr = {7,10,4,3,20,15};
        int k = 7;

        int result = kthSmallestElement(arr,k);
        System.out.println(result);
    }

    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i =0; i < arr.length; i++){
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        return maxHeap.peek();
    }

}
