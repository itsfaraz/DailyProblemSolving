package datastructures.hashmap;

public class MyHashMap {

    private class Node{
        String key;
        int value;
        Node next;
    }

    private int size;
    private Node bucketArray[];

    public MyHashMap(){
        this(4);
    }
    public MyHashMap(int capacity){
        this.bucketArray = new Node[capacity];
    }

    private int hashFunction(String key){
        int hashCode = key.hashCode();
        return hashCode % bucketArray.length;
    }

    public void put(String key,Integer value){
        int bucketNumber = hashFunction(key);
        Node temp = bucketArray[bucketNumber];
        while (temp!=null){
            if (temp.key.equals(key))
            {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        Node head = bucketArray[bucketNumber];
        Node nn = new Node();
        nn.key = key;
        nn.value = value;

        nn.next = head;
        bucketArray[bucketNumber] = nn;
        size++;

        // loadfactor
        double lf = (1.0 * size) / bucketArray.length;
        double threshold = 2;
        if (lf > threshold)
            rehash();

    }

    private void rehash() {
        Node []oba = bucketArray;
        Node []nba = new Node[oba.length * 2];
        bucketArray = nba;
        size = 0;
        for (Node temp : oba){
            while (temp!=null){
                put(temp.key, temp.value);
                temp = temp.next;
            }
        }
    }


    public Integer get(String key){
        int bucketNumber = hashFunction(key);
        Node temp = bucketArray[bucketNumber];
        while (temp!=null){
            if (temp.key.equals(key))
                return temp.value;
            temp = temp.next;
        }
        return null;
    }

    public Boolean containsKey(String key){
        int bucketNumber = hashFunction(key);
        Node temp = bucketArray[bucketNumber];
        while (temp!=null){
            if (temp.key.equals(key))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public Integer remove(String key){
        int bucketNumber = hashFunction(key);
        Node temp = bucketArray[bucketNumber];
        Node prev = null;
        while (temp!=null){
            if (temp.key.equals(key))
                break;
            prev = temp;
            temp = temp.next;
        }

        if (temp==null)
            return null;

        // Head Node
        if (prev == null){
            bucketArray[bucketNumber] = temp.next;
        }else{
            prev.next = temp.next;
        }
        size--;
        return temp.value;
    }

    @Override
    public String toString() {
        String str = "";
        for (Node temp : bucketArray){
            while (temp != null)
            {
                str += temp.key + "-"+ temp.value+" ";
                temp = temp.next;
            }
        }
        return str;
    }
}
