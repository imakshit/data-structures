import java.util.*;
public class unboundknapsack{

    public static int knap(int[] wt , int[] price, int size){
        int[] strg = new int[size+1];
        strg[0] = 0;
        for(int i =1 ;i<strg.length ; i++){
            int max = 0;
            for(int j =0 ; j<wt.length ; j++){
               if(wt[j]<=i){
                   max= Math.max(max, strg[i-wt[j]]+price[j]);
               }
            }
            strg[i] = max;
        }
        return strg[size];
    }



    public static void main(String[] args){
        int size = 7;
        int[] wt = {2,5,1,3,4};
        int[] price = {15,14,10,45,30};
        System.out.println(knap(wt, price, size));
    }
}