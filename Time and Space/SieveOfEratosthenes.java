import java.util.*;
public class SieveOfEratosthenes{

    public static void Sieve(int n){
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        
        for(int i =2 ; i<=n ; i++){
            if(i*i>=n){
                break;
            }
            int k = 2;
            while(k<=n){
                int j = i*k;
                if(j>n){
                    break;
                }
                if(arr[j]!=false){
                    arr[j] = false;
                }
                k++;
            }
        }
        for(int i = 0 ; i<=n ; i++){
            if(arr[i]==true){
                System.out.print(i+" ");
            }
        }
        }

    public static void main(String[] args){
        Sieve(100);
    }
}