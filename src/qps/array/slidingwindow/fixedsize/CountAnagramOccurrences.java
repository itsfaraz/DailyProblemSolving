package qps.array.slidingwindow.fixedsize;

import java.util.HashMap;

public class CountAnagramOccurrences {

    public static void main(String[] args) {


        String str = "aabaabaa";
        String anagram = "aaba";

//        int result = countAnagramV1(str, anagram, anagram.length());
//        System.out.println(result);
        System.out.println(countAnagramV2(str,anagram,anagram.length()));
    }

    public static int countAnagramV1(String inputStr, String inputAnagram, int sizeOfAnagram) {

        int occurrenceCounter = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int variationCounter = 0;
        for (char c : inputAnagram.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
                variationCounter += 1;
            }
        }




        int copy =  variationCounter;
        HashMap<Character, Integer> copyMap =new HashMap<>(map);

        for (int i = 0; i <= inputStr.length() - sizeOfAnagram; i++) {
            for (int j = i; j < i + sizeOfAnagram; j++) {
                char key = inputStr.charAt(j);
                if (map.containsKey(key))
                {
                    int value = map.get(key);
                    map.put(key,value-1);
                    if (map.get(key) == 0)
                        variationCounter -= 1;

                }


                if (j == i+sizeOfAnagram-1) {
                   if (variationCounter == 0){
                       occurrenceCounter += 1;
                   }

                    variationCounter = copy;
                    map = new HashMap<>(copyMap);
                }
            }

        }


        return occurrenceCounter;
    }


    public static int countAnagramV2(String str,String anagram,int size){
        HashMap<Character,Integer> myMap = new HashMap<>();
        int totalOccurrence = 0;
        int variationCounter = 0;

        for (char c : anagram.toCharArray()){
            if (!myMap.containsKey(c)) variationCounter += 1;
            myMap.put(c, myMap.getOrDefault(c,0)+1);
        }

        int i = 0;
        int j = 0;
        while(j < str.length()){

            char data = str.charAt(j);
            if (myMap.containsKey(data)){
                int value = myMap.get(data);
                myMap.put(data,value-1);
                if (value-1 == 0)
                    variationCounter -= 1;
            }

            int window = i+size-1;
            if (j < window){
                j++;
            }else if(j == window){
                if (variationCounter == 0){
                    totalOccurrence +=1;
                }
                char start = str.charAt(i);
                if (myMap.containsKey(start)){
                    int value = myMap.get(start);
                    myMap.put(start,value+1);
                    if (myMap.get(start) == 1)
                        variationCounter+=1;
                }


                i++;
                j++;
            }else{
                i++;
            }

        }

        return totalOccurrence;
    }
}
