import java.util.*;
public class perm2{
//item selected so far = isf
//2 raise to the power n formula
//n==tb
//r==no. of objects
public static void perm(boolean[] items , int cb , int n , int isf , int r  , String asf){

    if(cb==n){
        if(isf==r){
             System.out.println(asf);
        return;
        }
        return;       
        }

        perm(items, cb+1 , n , isf , r , asf);//no item selected

        for(int i =0 ; i<items.length ; i++){
            if(items[i]==false){
                items[i] =true;
                perm(items , cb+1 , n , isf+1 , r , asf+cb+" ");//item selected
                items[i] =false;
            }
        }
 
            
        
    }

    public static void main(String[] args){
             boolean[] items = new boolean[2];

             perm(items , 0 , 4 , 0 , 2 , "");
        

    }
}