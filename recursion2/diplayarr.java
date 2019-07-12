import java.util.*;
public class diplayarr{
    public static void arrinc(int[] arr , int index){
        if(index==arr.length){
            return;
        }
        System.out.print(arr[index]+" ");
        arrinc(arr , index+1);
    }

    public static void arrdec(int[] arr , int index){
        if(index==arr.length){
            return;
        }
        arrdec(arr,index+1);
        System.out.print(arr[index]+" ");
    }


    public static int arrmax(int[] arr  , int i ){
        if(i==arr.length){
            return 1;
        }
        int max = arr[i];
        int k = arrmax(arr , i+1);
        if(max<k){
            max=k;
        }
        return max;
    }

    public static boolean linearsearch(int[] arr , int i , int data){
        if(i==arr.length){
            return false;
        }

        boolean k =  linearsearch(arr , i+1 , data);
        
        if(k){
            return true;
        }
        else if(data==arr[i]){
            return true;
        }else{
            return false;
        }           
    }

    public static int firstindex(int[] arr , int index , int data){
        
        if(index==arr.length){ //not found in array
            return -1;
        }

          if(data==arr[index]){
             return index;
        }
       
       else{
           int fisa = firstindex(arr , index+1 , data); //find in small array
           return fisa;
       }
    }


    public static int lastindex(int[] arr, int index , int data){
        if(index==arr.length){
            return -1;
        }
        int lisa = lastindex(arr , index+1 , data);
        if(lisa!=-1) // lisa has data
        {
            return lisa;
        }else if(data==arr[index])//data found
        {
            return index;
        }else//nothing found
        {
            return -1;
        }
    }


    public static int[] dupinarr(int[] arr , int index , int data , int counter){
           
        if(index==arr.length){
            return new int[counter];
            
        }
        if(arr[index]==data){
            counter++;
        }       // find the size of arr in pre
            int[] res = dupinarr(arr , index+1 , data , counter);
            //find the duplicates in post
            if(arr[index] == data){
                res[counter-1] = index;
                counter--;                
            }
            return res; 
       }        
   
   
    public static void main(String[] args){
        int[] arr = {10,20,10,30,100,40,50};

        System.out.println("array in increasing order : ");
        arrinc(arr , 0);

        System.out.println();

        System.out.println("array in reverse order : ");
        arrdec(arr,0);

        System.out.println();

        System.out.println("array max is: "+arrmax(arr , 0));

        System.out.println("linear search: "+ linearsearch(arr , 0 , 100));

        System.out.println("first index is:"+ firstindex(arr , 0 , 50));

        System.out.println("last index is:"+ lastindex(arr , 0 , 10));  

        int[] array = dupinarr(arr,0,10,0);

        System.out.println("duplicate in array indices: ");

        for(int i = 0; i<array.length ; i++){
            System.out.print(array[i]+" ");
        }

                  
    }
}
