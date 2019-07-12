import java.util.*;
public class coincomb{

    public static void comb(int[] coin , int cs , int ts , int lib , String asf){
        if(cs==ts){
            System.out.println(asf);
            return;
        }


    for(int i = lib ; i<coin.length ; i++){
        if(cs+coin[i]<=ts){
            comb(coin , cs+coin[i] , ts , i , asf+coin[i]);
        }
    }

    }

    public static void main(String[] args){
        int[] coin = {2,3,5,6};
        comb(coin , 0 , 7 , 0 , "");

    }
}