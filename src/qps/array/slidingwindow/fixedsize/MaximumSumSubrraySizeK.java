package qps.array.slidingwindow.fixedsize;

public class MaximumSumSubrraySizeK {

    public static void main(String[] args) {
        int []arr = {2,5,1,8,2,9,1};
        System.out.println(maximumSubarrraySum(arr,3));
    }

    /*

        Given an array for example[2,5,1,8,2,9,1] find maximum sub-array sum
        k size of sub-array
        intput : arr = {2,5,1,8,2,9,1}, k = 3
        output : 19
    * */

    public static int maximumSubarrraySum(int []arr,int k){
        int maxResult = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < arr.length){
            int windowsSize = (j-i)+1;
            sum += arr[j];

            if (windowsSize < k )
                j++;
            else if (windowsSize == k) {
                if(sum > maxResult)
                    maxResult = sum;
                sum = sum - arr[i];
                i++;
                j++;
            }else i++;
        }
        return maxResult;
    }

}
