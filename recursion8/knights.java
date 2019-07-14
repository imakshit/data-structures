import java.util.*;
public class knights{

    static int counter = 0;

    public static boolean isknightsafe(boolean[][] chess , int r , int c){
        if(r>=1 && c>=2 && chess[r-1][c-2]==true){
            return false;
        }else if(r>=1 && c<chess.length-2 && chess[r-1][c+2]==true){
            return false;
        }else if(r>=2 && c>=1 && chess[r-2][c-1]==true){
            return false;
        }else if(r>=2 && c<chess.length-1 && chess[r-2][c+1]==true){
            return false;
        }
        return true;

        
            }

    public static void knights(boolean[][]chess , int cq , int lqi ,int lqj ,  String asf){

        //queen level
        //box option
        if(cq==chess.length){
            
            System.out.println(++counter+". "+ asf);
            return;
        }

        for(int i = lqi ; i<chess.length ; i++){
            for(int j = (i==lqi?lqj+1:0); j<chess[0].length ; j++){
                if(chess[i][j]==false && isknightsafe(chess, i , j)==true){
                    chess[i][j]=true;
                    knights(chess , cq+1 , i , j , asf+i+j);
                    chess[i][j]=false;
                }
            }
        }



    }

    public static void main(String[] args){

        boolean[][] chess= new boolean[3][3];
        knights(chess , 0 , 0 , -1 , "");


    }
}