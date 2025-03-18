package BasicUnderstandign;

public class Temporary {

    public static void main(String[] args) {
        String s = "1 - 50 of 3974";
        String regex = "[ ]";
        String [] arr = s.split(regex);
        int length = arr.length;
        System.out.println(length);
        String s1 = arr[4];
        System.out.println(s1);
        for(String word: arr){
            System.out.println(word);
        }
    }
}