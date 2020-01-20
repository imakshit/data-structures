import java.util.*;
public class rodcutting{

    public static int rodcut(int[] arr){
        int[] strg = new int[arr.length];
        strg[0] = 0;
        strg[1] = arr[1];
        for(int i =2 ; i<arr.length ; i++){
            int left = 1;
            int right = i-1;
            int max = arr[i];
            while(left<=right){
                if(strg[left]+strg[right]>max){
                    max = strg[left]+strg[right];
                }     
                left++;
                right--;
            }
            strg[i] = max;
        }
        return strg[strg.length-1];
    }

    public static void main(String[] args){
        int[] arr = {0,3,5,6,15,10,25,12,24};
        System.out.println(rodcut(arr));
    }
}