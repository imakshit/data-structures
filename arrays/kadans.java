import java.util.*;

public class kadans{
    

public static void main(String[] args){
    int[] arr = {2,4,3,-6,-4,1,7,-2,6,4,-3,2,3,-9,-6,-4,4,8};


    int ci = 0;
    int cj = 0;
    int csum = arr[0];

    int besti = 0;
    int bestj = 0;
    int bestsum = arr[0];

    for(int i = 1 ; i<arr.length ; i++){
        if(csum>0){
            cj++;
            csum = csum+arr[i];

        }else{
            ci = i;
            cj = i;
            csum = arr[i];

        }
         
         if(csum>bestsum){
             besti = ci;
             bestj = cj;
             bestsum = csum;
         }




    }

    for(int i = besti ; i<=bestj ; i++){
        System.out.print(arr[i]+" ");
    }

}
}