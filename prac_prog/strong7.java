import java.util.*;
public class strong7{

    public static int fact(int n){
      if(n==0){
             return 1;
         }
         int factorial = n*fact(n-1);
         return factorial;
    }

    public static void strong(int n){
        int sum = 0;
        int j = n;
        while(n>0){
            int r = n%10;
            n = n/10;
            int k = fact(r);
            sum = sum+k;
        }
        if(sum==j){
            System.out.println("strong");

        }else{
            System.out.println("not strong");
        }
    }

    public static void main(String[] args){
        strong(145);
    }
}