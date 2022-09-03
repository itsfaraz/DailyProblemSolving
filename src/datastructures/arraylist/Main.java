package datastructures.arraylist;



public class Main {
    public static void main(String[] args) {



        ArrayList<String> myList = new ArrayList(10);
        myList.add("Faraz");
        myList.add("20");
        myList.add("30");
        myList.add("30");
        myList.add("20");
        myList.add("340");
        myList.add("350");
        myList.add("360");
        myList.add("970");
        myList.add("00");
        myList.add("120");
        myList.add("130Sheikh");
        String value = myList.remove(2);
        System.out.println(myList.get(0));
        System.out.println(myList.contains("10"));
        System.out.println(myList.contains("20"));
        System.out.println(myList.get(myList.size()));

        System.out.println(myList);

    }
}
