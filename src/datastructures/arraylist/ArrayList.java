package datastructures.arraylist;

public class ArrayList<T>{

    private T[]list;
    private final int capacity;
    private int size;

    public ArrayList(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.list = (T[]) new Object[capacity];
    }

    public ArrayList(){
        this.capacity = 5;
        this.size = 0;
        this.list = (T[]) new Object[capacity];
    }

    public void add(T element){
        if (size >= list.length-1){
            reListing(element);
            return;
        }

        list[size] = element;
        size ++;
    }

    public T remove(int index){
        try {
            if (index > list.length || index < 0)
                throw new Exception("Index out of bound Exception "+index);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        T remove = list[index];
        list[index] = null;
        size--;
        return remove;
    }

    public T get(int index){
       try {
           if (index > list.length || index < 0)
               throw new Exception("Index out of bound Exception "+index);
           if (list[index] == null)
               throw new Exception("Index not valid!");
       }catch (Exception e){
           e.printStackTrace();
       }
       return list[index];
    }

    private void reListing(T element){
        T tempList[] = (T[]) new Object[size*2];
        for (int idx = 0; idx < list.length; idx++)
            tempList[idx] = list[idx];
        list = tempList;
        add(element);
    }

    public void clear(){
      list = (T[]) new Object[capacity];
      size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T val : list){
            if (val != null)
                result.append(val+", ");
        }
        return result.toString().substring(0,result.length()-2)+"]";
    }

    public boolean contains(T element){
        if (size <= 0)
            return false;
        for(T ele : list){
            if (ele != null && ele == element)
                return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
