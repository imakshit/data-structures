import java.util.*;
public class factorial1{

    static int fact(int n ){
         if(n==0){
             return 1;
         }
         int factorial = n*fact(n-1);
         return factorial;
    }

    public static void main(String[] args){
        int k = fact(5);
        System.out.print(k);
    }
}