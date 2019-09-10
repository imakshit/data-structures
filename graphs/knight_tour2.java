import java.util.*;


public class knight_tour2{
static int counter;


public static void knight_tour(int[][] chess, int r , int c , int move){

if(r< 0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]!=0){
    return;
}
else if(move==chess.length*chess.length){
    counter++;
    chess[r][c] = move;
    System.out.println("**********"+counter+"**********");
    for(int i =0 ; i<chess.length ; i++){
        for(int j =0 ; j<chess.length ; j++){
            System.out.print(chess[i][j]+" ");
        }
        System.out.println();
    }
     System.out.println("**********"+counter+"**********");
    chess[r][c] = 0;
    return;
}


chess[r][c] = move;

knight_tour(chess , r-2 , c+1 , move+1);
knight_tour(chess , r-1 , c+2 , move+1);
knight_tour(chess , r+1 , c+2 , move+1);
knight_tour(chess , r+2 , c+1 , move+1);
knight_tour(chess , r+2 , c-1 , move+1);
knight_tour(chess , r+1 , c-2 , move+1);
knight_tour(chess , r-1 , c-2 , move+1);
knight_tour(chess , r-2 , c-1 , move+1);


chess[r][c] = 0;
}
public static void main(String[] args){
    int n = 5;
    int[][] chess = new int[n][n];
    knight_tour(chess , 1 , 3 , 1);


}
}
