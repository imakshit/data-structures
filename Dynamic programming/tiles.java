import java.util.*;
public class tiles{
    public static int tile(int n , int m){
        int[] strg = new int[n+1];
        strg[0] = 0;
        for(int i =1 ; i<=n ; i++){
            strg[i] = strg[i-1]+strg[i-m];
        }
    }


    public static void main(String[] args){

        System.out.println(tile(10,2));

    }
}