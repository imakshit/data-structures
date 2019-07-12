import java.util.*;
public class permu{
    //co = current object
    //to = total object

    public static void printperm(boolean[] boxes , int co , int to , String asf){
        if(co>to){
            System.out.println(asf);
            return;
        }  
        
        for(int cb = 0 ; cb<boxes.length ; cb++){
            if(boxes[cb]==false){
                boxes[cb] = true;
                printperm(boxes , co+1 , to  ,asf+co+"["+cb+"]");

                boxes[cb] = false;
            }
        }




    }


    public static void main(String[] args){
        boolean[] boxes = new boolean[5];
        int objects = 2;
        printperm(boxes , 1 , objects , "");
    }
}