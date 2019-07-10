import java.util.*;
public class reverse20{
    public static void rev(int n){
        int sum = 0;
        while(n>0){
            int r = n%10;
            n = n/10;
            sum = (sum*10)+r;
        }
        System.out.println(sum);
    }
    public static void main(String[] args){
        rev(1456);
        
    }
}