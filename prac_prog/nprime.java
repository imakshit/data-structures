import java.util.*;
public class nprime{
    public static boolean primeis(int n){
        for(int i =2 ; i<n ; i++){
            if(n%i==0){
                return false;
            }
        }return true;
    }

    public static void prime(int n){
        for(int i =1 ; i<n ; i++){
            if(primeis(i)){
                System.out.println(i);
            }

        }
    }
public static void main(String[] args){
    prime(20);
}
}