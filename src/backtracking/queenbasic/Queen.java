package backtracking.queenbasic;

public class Queen {
    public static void main(String[] args) {
        queenPermutation(new boolean[4],2,0,"");
    }

    public static int counter = 0;
    public static void queenPermutation(boolean []boxes,int noOfQueens,int queenPlacedSoFar,String ans){
        if (queenPlacedSoFar == noOfQueens) {
            counter++;
            System.out.println(counter+").\t "+ans) ;
        }

        for (int index = 0; index < boxes.length;index++){
           if (!boxes[index]){
               boxes[index] = true;
             queenPermutation(boxes,noOfQueens,queenPlacedSoFar+1,ans+"q"+queenPlacedSoFar+"b"+index);
               boxes[index] = false;
           }
        }
    }


}
