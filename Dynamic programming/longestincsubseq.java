import java.util.*;
public class longestincsubseq{

    public static int lis(int[] arr){
        int[] strg = new int[arr.length];

        strg[0] = 1;      

        for(int i =1 ; i<arr.length ; i++){
            int imax = 0; //local max or initial max
            
            for(int j = 0 ; j<i ; j++){
                if(arr[j]<arr[i]){
                    if(strg[j]>imax){
                        imax = strg[j];
                    }
                }
            }    
            strg[i] = imax+1;
        }

        int max = strg[0];
        for(int i =1 ; i<strg.length; i++){
            if(strg[i]>max){
                max = strg[i];
            }
        }
        return max;
    }


    public static void main(String[] args){
        int[] arr = {10 , 21 , 9 , 33 , 22 , 50, 41 , 60 , 80 , 1};
        System.out.println(lis(arr));
        
    }
}
