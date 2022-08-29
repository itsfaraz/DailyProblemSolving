package datastructures.hashmap;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

//        HashMap<String,Integer> myMap = new HashMap<>();
//        myMap.put("hello",20);
//        myMap.put("hello",10);
//        myMap.put("hello",30);
//        int value  = myMap.remove("hello");
//        System.out.println(value);
//        value  = myMap.remove("hello");
//        System.out.println(value);


        MyHashMap map = new MyHashMap();
        map.put("Faraz",10);
        System.out.println(map.get("Faraz"));
        map.put("Faisal",20);
        map.put("A",30);
        map.put("B",40);
        map.put("C",50);
        map.put("D",60);
        map.put("AA",80);
        map.put("AAA",90);
        map.put("AAAA",100);
        System.out.println(map);
    }

}
