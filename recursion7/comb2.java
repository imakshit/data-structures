import java.util.*;
public class comb2{

    //box - level
    // item = options
    //n==tb
    //r = no. of choices
    public static void printcom( int cb,int n ,int bssf , int r , String asf){
        if(cb==n)///cb==tb
        {
            if(bssf==r)//box selected so far==number of boxes to be selected
            {
            System.out.println(asf);            
            }
            return;
        }

        //no loop required when number of choices are same at each level

       
        //box selected 
         printcom(cb+1 , n , bssf+1 , r , asf+cb);
        //box rejected
         printcom(cb+1 , n , bssf , r , asf);    
            
            

        
    }

    public static void main(String[] args){
        // boolean[] boxes = new boolean[4];
        // int objects = 2;
        printcom(0 , 4 , 0 , 2 , "");
    
}
}