import java.util.*;
public class nfriends{

    public static int friend(int n){
        int[] strg = new int[n+1];
        strg[0] = strg[1]=1  ;
        for(int i =2 ; i<strg.length ; i++){
            strg[i] = strg[i-1] + (i-1)*strg[i-2];
        }
        return strg[n];
        
    }

    public static void main(String[] args){
            System.out.println(friend(4));
    }
}