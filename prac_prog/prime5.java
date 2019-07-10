import java.util.*;
public class prime5{

    public static boolean isprime(int n){
        for(int i =2 ; i<n/2 ; i++){
            if(n%i==0){
                return false;
            }
        }return true;
    }

    public static void main(String[] args){
        boolean k = isprime(5);
        System.out.println(k);

    }
}