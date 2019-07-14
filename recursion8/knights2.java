import java.util.*;
public class knights2{

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


    public static void nkights(boolean[][] chess , int i ,  int j , int ksf , String asf){

        if(i==chess.length && j==0)//board over
        {

            if(ksf==chess.length)//selecting r!
            {
                System.out.println(++counter+". "+asf);
                return;
            }return;



        }else if(j==chess.length-1)//column end reached
        {
            //no
            nkights(chess , i+1 , 0 , ksf, asf);
            if(isknightsafe(chess , i , j)==true){
            //yes
            chess[i][j]= true;
            nkights(chess , i+1 , 0 ,ksf+1 , asf+i+j+"");
            chess[i][j] = false;

            }
        }els
        {
            //no
            nkights(chess , i , j+1 , ksf, asf);
            if(isknightsafe(chess , i , j)==true){
            //yes
            chess[i][j]= true;
            nkights(chess , i , j+1 ,ksf+1 , asf+i+j+"");
            chess[i][j] = false;

            }

        }



    }


    public static void main(String[] args){
        boolean[][] chess = new boolean[4][4];
        nkights(chess ,0, 0, 0 , "");
    }
}