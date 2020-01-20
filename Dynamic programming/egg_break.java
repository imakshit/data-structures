import java.util.*;
public class egg_break{

    public static int egg(int n , int e){
        int[][] strg = new int[n][e];
        for(int i =0 ; i<n ; i++){
            strg[i][1] = i;
        }
        int max = 0;
        for(int i =0 ; i<e ; i++){
            for(int j = i-1 ; j>=0 ; j--){
                if(strg[i-1][j]>max){
                    max = strg[i-1][j];
                }
            }
            strg[1][i] = max;
        }

        return strg[n-1][e-1]+1;

    }

    public static void main(String[] args){
        System.out.println(egg(10 ,2));
    }
}