package basic.hashmap.questions;

import java.util.ArrayList;
import java.util.HashMap;

public class ConsecutiveSequence {

    /*
        We have unsorted array in which we have to findout longest consecutive sequence and then
        print it as a output

        What is Consecutive Sequence ?
        A series of incremented value, example (1,2,3,4,5)


        ---------------------- Test Case 1 ----------------------
        Input
            array = [2,12,9,16,10,5,3,20,25,11,1,8,6]

        Output
            [8,9,10,11,12]


        ---------------------- Test Case 2 ----------------------

        Input
            array = [15,13,23,21,19,11,16]

        Output
            [15,16]

     */


    public static void main(String[] args) {

        int []input = {2,12,9,16,10,5,3,20,25,11,1,8,6};
        int []input1 = {15,13,23,21,19,11,16};
        ArrayList<Integer> output = longestConsecutiveSequence(input);
        System.out.println(output);

    }

    public static ArrayList<Integer> longestConsecutiveSequence(int []input){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Integer> myMap = new HashMap<>();

        // Fill map with zeros
        for (int value : input){
            myMap.put(value,0);
        }

        // Fill value of map with it immediate next value
        for (int value : input){
            if (myMap.containsKey(value+1)){
                myMap.put(value,value+1);
            }
        }

        System.out.println(myMap);
        int longestSequence = 0;
        for (int element : input){
            if (myMap.containsKey(element)){
                ArrayList<Integer> temporary = new ArrayList<>();
                int getSequence = getLongestSequence(element,myMap,temporary);
                if (getSequence > longestSequence){
                    longestSequence = getSequence;
                    output = temporary;
                }
            }
        }


        return output;
    }

    private static int getLongestSequence(int key1, HashMap<Integer, Integer> myMap,ArrayList<Integer> output) {
        int total = 0;
        int key = key1;
        while (myMap.containsKey(key)){
            int value = myMap.get(key);
            total += 1;
            output.add(key);
            key = value;
        }

        return total;
    }

}
