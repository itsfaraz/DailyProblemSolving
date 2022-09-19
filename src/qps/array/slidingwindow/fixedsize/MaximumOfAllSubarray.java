package qps.array.slidingwindow.fixedsize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubarray {

    /*
        Given an array find out maximum of in all sub-array and return array
        Input :
            arr  = [1,3,-1,-3,5,3,6,7]
            size = 8
            window = 3
        Output :
              [3, 3, 5, 5, 6, 7]

     */


    /*

        We cannot maintain max of all subarray with one variable
        for that we need some mechanism which always maintains next max value

        Queue
         *  Whenever j is increasing or sliding we need to check if Jth element is greater then
            existing element in queue if so remove all which are adhering these condition and then add
            Jth element else add Jth element
     */


    public static void main(String[] args) {
        int []arr = {2,6,3,1,8,4,9};
        int size = arr.length;
        int k = 3;
        int result [] = findAllMaximum(arr,size,k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findAllMaximum(int []arr,int size,int k){

        int []result = new int[arr.length-k+1];
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        int resultIndex = 0;
        while(j < size){
            int window = (j-i)+1;
            while (!queue.isEmpty() && queue.peek() < arr[j]) {
                queue.remove();
            }
            queue.add(arr[j]);
            if (window < k){
                j++;
            }else if(window == k){
                int start = arr[i];
                result[resultIndex] = queue.peek();
                if (queue.contains(start))
                    queue.remove(start);

                i++;
                j++;
                resultIndex++;
            }else{
                i++;
            }

        }
        return result;
    }
}
