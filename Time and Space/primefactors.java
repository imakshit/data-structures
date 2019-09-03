import java.util.*;
public class primefactors{

    static int[] getspf(int n){
        int[] res = new int[n+1];
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr , true);
        arr[0] = false;
        arr[1] = false;
        for(int i =0 ; i<res.length ; i++){
            res[i] = i;
        }
        for(int i = 2 ; i*i<=n ; i++){
            if(arr[i]==true){
                for(int j = i ; i*j<=n ; j++){
                    if(arr[i*j]==true){
                        arr[i*j]=false;
                        res[i*j] = i;
                    }
                }
            }
        }
        return res;
    }

    static void factorisation(int[] spf , int x ){
        System.out.print(x + " = ");
        while(x>1){
            System.out.print(spf[x] + " * ");
            x = x / spf[x];
        }
        System.out.println(1);
    }


    public static void main(String[] args){
       int[] ar =  getspf(100);
       factorisation(ar, 100);
       //System.out.println(Arrays.toString(ar));
      //  factorisation(spf, x);

    }
}