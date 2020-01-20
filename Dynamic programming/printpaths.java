import java.util.*;
public class printpaths{

    public static int allpath(int[][] garr , int[][] larr){
        for(int i = garr.length-1; i>=0 ; i--){
            for(int j = garr[0].length-1 ; j>=0 ; j--){
                
                if(i==larr.length -1 && j==larr[0].length-1){
                    garr[i][j] = larr[i][j];
                }
                else if(i==larr.length-1){
                    garr[i][j] = larr[i][j]+garr[i][j+1];

                }
                else if(j==larr[0].length-1){
                    garr[i][j] = larr[i][j] + garr[i+1][j];
                }
                else{
                    garr[i][j] = larr[i][j] + Math.min(garr[i][j+1] , garr[i+1][j]);

                }

            }
        }
        
        return garr[0][0];
    }

    public static void main(String[] args){
        int[][] larr = {
            {2,7,3,8,0,3,7},
            {4,0,1,2,4,3,4},
            {3,8,5,9,0,8,1},
            {1,6,0,4,5,5,2},
            {6,2,9,5,7,0,6},
            {0,8,7,9,6,3,0},
            {1,3,5,0,5,1,0},
        };

        int[][] garr = new int[larr.length][larr[0].length];

        long start = System.currentTimeMillis();        
        int res = allpath(garr , larr);
        long end = System.currentTimeMillis();
        long dur = end-start;
        System.out.println(res+" in "+dur+"ms");


    }
}