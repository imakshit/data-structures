import java.util.*;
public class fibdp{
    public static int fib(int n , int[] qb){
        if(n==0||n==1){
            return n;
        }
        else if(qb[n]!=0){
            return qb[n];
        }
        int fnm1 = fib(n-1 , qb);
        int fnm2 = fib(n-2 , qb);
        int fn = fnm1+fnm2;
        qb[n] = fn;
        return fn;
    }
    public static void main(String[] args){
        int n = 40;
        int[] qb = new int[n+1];
         long start = System.currentTimeMillis();        
        int k = fib(n , qb);
         long end = System.currentTimeMillis();
        long dur = end-start;
        System.out.println(k+" in "+dur);

    }
}