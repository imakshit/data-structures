import java.util.*;
public class exitpoint{
    public static void main(String[] args){
        int[][] arr = {
            {0,0,1,0},
            {1,0,0,0},
            {0,0,0,0},
            {1,0,1,0}
        };
    
    int i = 0;
    int j= 0;
    int dir = 0;

    while(i>=0 && i<arr.length &&  j >=0 && j<arr[0].length){

        dir = (dir+arr[i][j])%4;        

        if(dir==0){
            j++;
        }
        if(dir==1){
            i++;
        }
        if(dir==2){
            j--;
        }
        if(dir==3){
            i--;
        }      


    }
    //to deduct the value of exit box , extra pair of loop is added

    if(dir==0){
            j--;
    }   
    else if(dir==1){
        i--;

    }else if(dir==2){
        j++;

    }else if(dir==3){
        i++;
    }


    System.out.print(i+" "+j);

    }
}