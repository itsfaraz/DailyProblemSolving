package basic.hashmap.questions;

import java.util.HashMap;

public class HighestFrequencyString {

/*
    Find highest frequency character in a String

    abcaabccdeac

    Complexity
    Time is N
    Space is N
 */
    public static void main(String[] args) {
        char output = highestFrequencyCharacter("abbbebecaeabecceddeeace");
        System.out.println(output);
    }

    public static char highestFrequencyCharacter(String input){
        char highFrequencyChar = '-';
        HashMap<Character,Integer> myMap = new HashMap<>();
        int highFrequncyTotal = 0;
        for (char ch : input.toCharArray()){
            if (myMap.containsKey(ch)){
                int prev = myMap.get(ch);
                myMap.put(ch,prev+1);
            }else {
                myMap.put(ch,1);
            }

            if (myMap.get(ch) > highFrequncyTotal){
                highFrequncyTotal = myMap.get(ch);
                highFrequencyChar = ch;
            }
        }

        System.out.println(myMap);
        return highFrequencyChar;
    }

}
