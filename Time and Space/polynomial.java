import java.util.*;
public class polynomial{
    static int func(int x , int n){
        int sum = 0;
        int p = 1;
        for(int i  = n ; i>=1 ; i--){
            sum+=i*x*p;
            p = p*x;        
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(func(2,3));

    }
}