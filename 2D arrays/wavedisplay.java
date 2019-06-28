import java.util.*;
public class wavedisplay{
    public static void main(String[] args){
        int[][] arr = {
            {11,12,13,14},
            {21,22,23,24},
            {31,32,33,34},
            {41,42,43,44},
        };

        for(int col = 0 ; col<=arr[0].length-1 ; col++){
            if(col%2==0){
                for(int i = 0 ; i<arr.length;  i++){
                    System.out.print(arr[i][col]+" ");
                }
                System.out.println();

            }else{
                for(int k = arr.length-1 ; k>=0 ; k--){
                    System.out.print(arr[k][col]+" ");

                }
                System.out.println();

            }
        }

    }
}