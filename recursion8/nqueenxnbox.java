import java.util.*;
public class nqueenxnbox{

    static int counter = 0;

    public static boolean isqueensafe(boolean[][] chess , int r , int c){
        //north
        for(int i = r-1  ; i>=0 ; i--)
        {
            if(chess[i][c]==true){
                return false;
            }
        }

        for(int j = c-1   ; j>=0 ; j--)
        {
            if(chess[r][j]==true){
                return false;
            }
        }


        for(int i = r-1 , j = c-1   ; i>=0&& j>=0 ; i-- , j--)
        {
            if(chess[i][j]==true){
                return false;
            }
        }


        for(int i = r-1  ,j = c+1 ; i>=0 && j<chess.length ; i-- , j++)
        {
            if(chess[i][j]==true){
                return false;
            }
        }






        

        return true;


    }

    public static void nqueen(boolean[][]chess , int cq , int lqi ,int lqj ,  String asf){

        //queen level
        //box option
        if(cq==chess.length){
            
            System.out.println(++counter+". "+ asf);
            return;
        }

        for(int i = lqi ; i<chess.length ; i++){
            for(int j = (i==lqi?lqj+1:0); j<chess[0].length ; j++){
                if(chess[i][j]==false && isqueensafe(chess, i , j)){
                    chess[i][j]=true;
                    nqueen(chess , cq+1 , i , j , asf+i+j);
                    chess[i][j]=false;
                }
            }
        }



    }

    public static void main(String[] args){

        boolean[][] chess= new boolean[4][4];
        nqueen(chess , 0 , 0 , -1 , "");


    }
}