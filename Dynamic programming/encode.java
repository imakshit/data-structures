import java.util.*;
public class encode{

    public static int encode(int[] arr){
        int[] local = new int[arr.length];
        if(arr[0]==0){
            return 0;
        }
        local[0]= 1;

        //initialise
        if(arr[1]!=0){
            local[1] = local[0];
        }
        int num = arr[0]*10 + arr[1];

        if(num>=10 && num<=26){
            local[1] += 1;
        }


        for(int i =2 ; i<arr.length ; i++){          

            if(arr[i] != 0){
                local[i] = local[i-1];            
            }
            int num2 = arr[i-1]*10 + arr[i];

            if(num2>=10 && num2<=26){
                local[i] += local[i-2];
            }
    }
        return local[arr.length-1];

    }

    public static void main(String[] args){
        int[] arr = {1,2,1,3,2,6,1,2,0,1,4};
        System.out.println(encode(arr));
        
        
    }
}