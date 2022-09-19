package qps.array.slidingwindow.dynamicsize;

public class LargestSubarrayOfSumK {

    /*
        Given an array find out Largest Subarray Of Sum
        Input   :
            arr     = [4, 1, 1, 1, 2, 3, 5]
            size    = 7
            k       = 5
        Output  :
            4
            explain :- [1, 1, 1, 2]
    */


    public static void main(String[] args) {
        int []arr = {4, 1, 0, 1, 1, 1, 1 ,2, 3, 5};
        int size = arr.length;
        int k = 5;
        System.out.println(largestSubarrayOfSumK(arr,k,size));
    }

    public static int largestSubarrayOfSumK(int []arr,int k,int size){
        int max = 0;
        int i = 0;
        int j = 0;

        int sum = 0;
        while (j < size){
            sum += arr[j];
            if (sum < k){
                j++;
            }else if(sum == k){
                max = Math.max(max,(j-i)+1);
                j++;
            }else{
                while(sum > k) {
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        return max;
    }

}
