import java.util.*;
public class spiraldisplay{
    public static void main(String[] args){
        int[][] arr = {
            {11,12,13,14},
            {21,22,23,24},
            {31,32,33,34},
            {41,42,43,44},
        };

        int rmin = 0;
        int cmin = 0;
        int rmax = arr.length-1;
        int cmax = arr[0].length-1;
        int counter = 0;
        int total_elements = arr.length * arr[0].length;

    while(counter<=total_elements){
        //LEFT WALL
        for(int row = rmin ; row<=rmax ; row++){
            System.out.print(arr[row][cmin]+" ");
            counter++;
        }
        cmin++;
       




        //BOTTOM WALL
        for(int col = cmin ; col<=cmax ; col++){
            System.out.print(arr[rmax][col]+" ");
            counter++;    
        }
        rmax--;
    


        //RIGHT WALL
        for(int row = rmax ; row>=rmin ; row--){
            System.out.print(arr[row][cmax]+" ");
            counter++;
        }
        cmax--;

        

        //TOP WALL
        for(int col = cmax ; col>=cmin ; col--){
            System.out.print(arr[rmin][col]+" ");
            counter++;
        }rmin++;
    }

    }
}
