import java.util.*;
public class reverse_arr{
    public static int[] rev(int[] arr , int index , int counter){
        if(index==arr.length){
            return arr;
        }
      
        rev(arr , index+1 , counter+1);
        
        if(index<arr.length){
            arr[counter] = arr[index];
            //counter--;
            return arr;
            
        }
        return arr;

    }

    public static void main(String[] args){
       int[] arr = {10,20,30,40,50};
        int[] arrrev =rev(arr , 0 , 0);
        for(int i= 0 ; i<arrrev.length ; i++){
        System.out.print(arrrev[i]+" ");
        }
    }
}