import java.util.*;
public class secondsmallest26{
    public static void small(int[] arr){
        Arrays.sort(arr);
        int k = arr[1];
        System.out.println(k);
    }
    public static void main(String[] args){
        int[] arr = {2,1,3,4,6,5};
        small(arr);
        
    }
}