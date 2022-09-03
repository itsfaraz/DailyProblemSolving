package qps.array;

public class CountAndSay {

    public static void main(String[] args) {

//        System.out.println(compress("3322251"));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        String rr = countAndSay(n-1);
        return compress(rr);
    }
    public static String compress(String str){
        int count = 1;
        char val = 'a';
        String compress = "";
        for (int idx = 0; idx < str.length()-1; idx++){
            char first = str.charAt(idx);
            char second = str.charAt(idx+1);
            if (first == second){
             count++;
            }else{
                compress = compress+count+str.charAt(idx);
                count = 1;
            }
        }

        compress = compress+count+str.charAt(str.length()-1);
        return compress;
    }

}
