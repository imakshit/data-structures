
import java.util.*;
public class queencom {

public static void printcom(boolean[] boxes, int ci, 
                                 int ti, int lib , String asf){
									 //last item in box == lib
        if(ci > ti)
        {
            System.out.println(asf);
            return;
        }
		//for sorted input i = lib+1
        for(int i = lib+1 ; i < boxes.length; i++)
        {
            if(boxes[i] == false)
            {
                boxes[i] = true;
                printcom(boxes, ci + 1, ti, i , asf + ci + "[" + i + "] ");
                boxes[i] = false;
            }
        }

        
    }

    public static void main(String[] args){
        boolean[] boxes = new boolean[4];
        int objects = 2;
        printcom(boxes, 1, objects, -1 ,  "");
		//lib  = -1 to consider first item too
    }
}