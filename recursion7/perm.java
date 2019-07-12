import java.util.*;

public class perm {

    public static void printPerm(boolean[] boxes, int ci, 
                                 int ti, String asf){
        //base case on level
        if(ci > ti)
        {
            System.out.println(asf);
            return;
        }
//loop on options
//call on levels
        for(int i = 0; i < boxes.length; i++)
        {
            if(boxes[i] == false)
            {
                boxes[i] = true;
                printPerm(boxes, ci + 1, ti, asf + ci + "[" + i + "] ");
                boxes[i] = false;
            }
        }

        
    }

    public static void main(String[] args){
        boolean[] boxes = new boolean[4];
        int objects = 2;
        printPerm(boxes, 1, objects, "");
    }
}