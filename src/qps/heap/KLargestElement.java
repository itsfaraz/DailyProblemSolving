package qps.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElement {

    public static void main(String[] args) {
        int [] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(Arrays.toString(kLargestElements(arr,k)));
    }

    public static int[] kLargestElements(int []arr,int k){
        int []result = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int idx = 0;idx < arr.length;idx++){
            minHeap.add(arr[idx]);
            if (minHeap.size() > k){
                minHeap.remove();
            }
        }
        for (int i = 0; i < result.length; i++){
            result[i] = minHeap.peek();
            minHeap.remove();
        }
        return result;
    }


}
