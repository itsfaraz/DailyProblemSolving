package qps.array.slidingwindow.dynamicsize;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {

        String str = "bebckbrbbed";
        String str1 = "aabacbebebe";
        int k = 4;
        int size = str.length();

        int result = longestSubstringWithKUniqueCharacters(str,k,size);
        System.out.println(result);
    }

    public static int longestSubstringWithKUniqueCharacters(String str,int k,int size){
        int resultMax = 0;
        HashMap<Character,Integer> myMap = new HashMap<>();

        int i = 0;
        int j = 0;
        while(j < size){
            char c = str.charAt(j);
            if (myMap.containsKey(c)) {
                int value = myMap.get(c);
                myMap.put(c, value + 1);
            }else{
                myMap.put(c,1);
            }

            if (myMap.size() < k){
                j++;
            }else if(myMap.size() == k){
                resultMax = Math.max(resultMax,(j-i)+1);
                j++;
            }else {
                while (myMap.size() > k){
                    char key = str.charAt(i);
                    if (myMap.get(key) > 1){
                        int value = myMap.get(key);
                        myMap.put(key,value-1);
                    }else{
                        myMap.remove(key);
                    }
                    i++;
                }
                j++;
            }
        }
        return resultMax;
    }
}
