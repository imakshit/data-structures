import java.util.*;
public class maxsumadjelem{

    public static int maxsum(int[] arr){
        int[] inc = new int[arr.length];
        int[] exc = new int[arr.length];
        inc[0] = arr[0];
        exc[0] = 0;

        for(int i =1 ; i<arr.length ; i++){
            inc[i] = arr[i] + exc[i-1];
            exc[i] = inc[i-1]>exc[i-1]?inc[i-1]:exc[i-1];
        }
        int max = inc[arr.length-1]>exc[arr.length-1]?inc[arr.length-1]:exc[arr.length-1];
        return max;

    }
    

    public static void main(String[] args){
        int[] arr = {5,6,10,100,10,5};
        System.out.println(maxsum(arr));
    }
}