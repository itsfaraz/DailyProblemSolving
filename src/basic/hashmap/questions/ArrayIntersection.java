package basic.hashmap.questions;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayIntersection {


    /*
        Two Unsorted array find out the intersection between them
        What is Intersection ?
        Intersection means the elements which are common in both array

        input
            array1 = [10,20,50,5,60,20,50,50,3,50,10]
            array2 = [2,10,70,10,50,5,80,3,1,3,50]

        Output
            [10,50,5,50,3,10]


        Time Complexity  :- M+N
        Space Complexity :- M Or N
     */

    public static void main(String[] args) {
        int []first = {10,20,50,5,60,20,50,50,3,50,10};
        int []second = {2,10,70,10,50,5,80,3,1,3,50};
        ArrayList<Integer> output = arrayIntersection(first,second);
        System.out.println(output);
    }

    public static ArrayList<Integer> arrayIntersection(int []first,int[]second){
        ArrayList<Integer> output = new ArrayList<>();
        int []bigArray = null;
        if (first.length >= second.length)
            bigArray = first;
        else
            bigArray = second;


        HashMap<Integer,Integer> myMap = new HashMap<>();
        for (int value : bigArray){
            if (myMap.containsKey(value)){
                int freq = myMap.get(value)+1;
                myMap.put(value,freq);
            }else
                myMap.put(value,1);
        }

        for (int value : second) {
            if (myMap.containsKey(value) && myMap.get(value) > 0) {
                output.add(value);
                myMap.put(value,myMap.get(value)-1);
            }
        }

        return output;
    }



}
