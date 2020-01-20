import java.util.*;
public class mincostbtree{

    public static int mincost(int[] data , int[] freq){
        int[][] strg = new int[data.length][freq.length];


        int[] fpsa = new int[freq.length];
        fpsa[0] = freq[0];
         for(int i =1 ; i<fpsa.length ; i++){
             fpsa[i]= fpsa[i-1]+freq[i];
         }

        for(int gap = 0 ; gap<strg.length ; gap++){
            for(int i =0 ; i<strg.length-gap ; i++){
                int j = i+gap;             

                if(gap==0){
                    strg[i][j] = freq[i];           
               }
               else if(gap==1){
                   strg[i][j] = Math.min(freq[i]+ 2*freq[j]  , 2*freq[i] + freq[j]);
               }else{
                   int min = Integer.MAX_VALUE;
                   for(int k = 0 ; k<=gap ; k++){
                       int left = k==0? 0:strg[i][i+k-1];
                       int right = k == gap?0:strg[i+k+1][j];

                       min = Math.min(left+right , min);
                   }
                    strg[i][j] = min +fpsa[j];
                    if(i<0){
                        strg[i][j] -= fpsa[i-1];
                    }

               }
            }
        }
        return strg[0][strg.length-1];
    }

    public static void main(String[] args){
        int[] data = {10,20,30,40,50,60,70};
        int[] freq = {2,1,4,1,1,3,5};
        System.out.println(mincost(data , freq));
    }
    
}