import java.util.*;
public class sumprime19{

    public static boolean isprime(int n){
        for(int i = 2 ; i<=n/2 ; i++){
            if(n%i==0){
                return false;
            }
        }return true;
    }


    public static void prime_sum(int n1 , int n2){
        int sum = 0;
        for(int i = n1 ; i<=n2 ; i++){
            if(isprime(i)){
                sum = sum+i;
                 System.out.println(i);
                            }
        }
        System.out.println("sum is: "+sum);

    }


    public static void main(String[] args){
        prime_sum(1,10);
    }
}