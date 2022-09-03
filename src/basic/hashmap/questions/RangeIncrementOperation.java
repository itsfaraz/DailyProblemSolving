package basic.hashmap.questions;

/*

    Consider an array of size n with all initial values as 0, we need to perform
    following m range increment operations.
    increments(a,b,k) : Increment values from 'a' to 'b' by 'k'

    Input : n = 4, m = 4

            a = 1, b = 2, k = 603
            a = 0, b = 0, k = 286
            a = 3, b = 3, k = 882
            a = 0, b = 3, k = 10

    Output : 892


Console Input Sample
4 4
1 2 603
0 0 286
3 3 882
0 3 10
Console Output Sample
892

*/

import java.util.Scanner;

public class RangeIncrementOperation {
    public static void main(String[] args) {



//        int maxValue = findMaxValueFromRangeIncrementOperation();
        int maxValue = findMaxValueFromRangeIncrementOperationV1();
        System.out.println(maxValue);
    }


//    BruteForce Approach
    public static int findMaxValueFromRangeIncrementOperation(){

        Scanner obs = new Scanner(System.in);

        int n = obs.nextInt();
        int m = obs.nextInt();

        int []store = new int[n];

        int maxValue = 0;


        while(m-- > 0){

            int a = obs.nextInt();
            int b = obs.nextInt();
            int k = obs.nextInt();

            for (int idx = a; idx <= b; idx++){
                store[idx] += k;
            }

        }

        for (int val : store)
        {
            if (val > maxValue)
                maxValue = val;
        }


        return maxValue;
    }

//    Optimized
    public static int findMaxValueFromRangeIncrementOperationV1(){

        Scanner obs = new Scanner(System.in);

        int n = obs.nextInt();
        int m = obs.nextInt();

        int []store = new int[n+1];




        while(m-- > 0){
            int a = obs.nextInt();
            int b = obs.nextInt();
            int k = obs.nextInt();
            store[a] += k;
            store[b+1] -= k;
        }

        int maxValue = store[0];
        for (int idx = 1; idx < store.length-1 ; idx++) {
            store[idx] += store[idx-1];
            if (store[idx] > maxValue)
                maxValue = store[idx];
        }


        return maxValue;
    }

}
