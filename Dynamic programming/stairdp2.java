import java.util.*;
public class stairdp2{

    public static int stair2(int[] arr){
        //count path
        int[] strg = new int[arr.length];
        strg[strg.length-1] = 1;
        for(int i = strg.length -2 ; i>=0 ; i--){
            for(int j = i+1 ; j<= i + arr[i] && j<arr.length ; j++){
                strg[i] += strg[j];
            }
        }
        return strg[0];

    }
    public static int minpath(int[] arr){
        int[] strg = new int[arr.length];       
        strg[strg.length-1] = 0;
         for(int i = strg.length -2 ; i>=0 ; i--){
             int min = arr.length;
            
            for(int j = i+1 ; j<=i+arr[i] && j<arr.length ; j++){
               
                if(strg[j]<min){
                    min = strg[j];
                }        

            }
                   strg[i] = min+1;
        }
        return strg[0];
    }


    public static void main(String[] args){
        int[] stair  =  {4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};
        //int[] qb = new int[stair.length + 1];
        long start = System.currentTimeMillis();        
        int k = minpath(stair);
         long end = System.currentTimeMillis();
        long dur = end-start;
        System.out.println(k+" in "+dur);

    }
}