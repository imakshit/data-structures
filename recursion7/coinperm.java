import java.util.*;
public class coinperm{

    public static void perm(int[] coins , int cs , int ts  , String asf){

        if(cs==ts){
            System.out.println(asf);
            return;
        }
        for(int i =0 ; i<coins.length ; i++){
            if(cs+coins[i]<=ts){
                
                perm(coins , cs+coins[i] , ts , asf+coins[i]+" ");
                

            }



        }

    }

    public static void main(String[] args){
        int[] coins ={2,3,5,6};
        perm(coins , 0 , 7 , "");

    }
}