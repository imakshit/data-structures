import java.util.*;
public class mm{
    public static void main(String[] args){
        int[][] m1 = {
            {10,1,0},
            {1,0,1},

        };


          int[][] m2 = {
            {2,1,0,1},
            {1,1,0,0},
            {0,1,0,1},

        };

        int r1 = m1.length;
        int c1 = m1[0].length;
        int r2 = m2.length;
        int c2 = m2[0].length;

        int[][] prod = new int[r1][c2];

        if(c1!=r2){
            System.out.println("cannot be multiplied!!!");
        }
        else{
            for(int i = 0 ;  i<r1 ; i++){
                for(int j = 0 ; j< c2; j++){
                    for(int k =0  ; k<c1 ; k++){
                        prod[i][j] += m1[i][k]*m2[k][j];
                    }
                }
            }

        }


         for(int i = 0 ;  i<r1 ; i++){
                for(int j = 0 ; j< c2 ; j++){
                    System.out.print(prod[i][j]+" ");
                }System.out.println();
    }
}
}