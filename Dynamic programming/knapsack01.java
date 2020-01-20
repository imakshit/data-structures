import java.util.*;
public class knapsack01{

    public static int knap(int[] wt , int[] price ,int size){
        int[][] strg = new int[wt.length][size+1];


        for(int i = 0 ; i < strg.length ; i++){
            for(int j =0 ; j<strg[0].length ; j++){
               if(i==0 && j==0){
                strg[i][j] = 0;
               }
               
                else if(i==0){
                    if(j>=wt[i]){
                        strg[i][j] = price[i];
                    }
                    else{
                        strg[i][j]=0;
                    }
                }else if(j==0){
                    strg[i][j] = 0;

                }else{
                    strg[i][j] = strg[i-1][j];
                    if(j>=wt[i]){
                        if(strg[i-1][j]<strg[i-1][j-wt[i]]+price[i]){
                            strg[i][j]=strg[i-1][j-wt[i]]+price[i];
                        }
                    }
            }
        }
    }
       
        return strg[wt.length-1][size];

    }

    public static void main(String[] args){
        int size = 7;
        int[] wt = {2,5,1,3,4};
        int[] price = {15,14,10,45,30};
        System.out.println(knap(wt, price, size));
        

    }
}