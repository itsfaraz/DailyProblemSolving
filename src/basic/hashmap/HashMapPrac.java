package basic.hashmap;


import java.util.HashMap;
import java.util.Set;

public class HashMapPrac {

    public static void main(String[] args) {

        HashMap<String,String> myMap = new HashMap();
        myMap.put("India","1.3 billion");
        myMap.put("Australia","25 million");
        myMap.put("China","1.4 billion");
        myMap.put("USA","1 billion");
        myMap.put("Russia","146 million");
        myMap.put(null,"Data");


        System.out.println(myMap);

        Set<String> mapKeySet = myMap.keySet();
        for (String key : mapKeySet){
            System.out.println(key+" -> "+myMap.get(key));
        }



        System.out.println(myMap.containsKey("Japan"));


    }

}
