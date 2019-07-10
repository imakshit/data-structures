import java.util.*;
public class removedup27{

    public static void rem_dup(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int j =0;
        int counter = 0 ;
        
        
        for(int i = 0; i<arr.length-1 ; i++){
            if(arr[i]!=arr[i+1]){
                counter++;
                //temp[j++] = arr[i];
            }      }
            int[] temp = new int[counter+1];

              for(int i = 0; i<arr.length-1 ; i++){
            if(arr[i]!=arr[i+1]){
                
                temp[j++] = arr[i];
            }      }

            temp[j++]=arr[n-1];
            for(int k = 0 ; k<temp.length ; k++){
                System.out.print(temp[k]+" ");
            }
        }
    

    public static void main(String[] args){

        int[] arr = {1,1,3,2,3,2,4,6,5,4};
        rem_dup(arr);
        
    }
}