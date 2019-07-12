import java.util.*;
public class toh{

    public static void towerofhanoi(int t , char s , char d , char h){
        if(t==0){
            return;
        }
        
        towerofhanoi(t-1 , s , h , d); //go from source to helper via destination
        System.out.println(t+" "+s+" "+d );//print inorder
        towerofhanoi(t-1 , h , d , s);//go from helper to destination via source
        

    }


    public static void main(String[] args){
        //toh(tower,source,destination,helper)
        towerofhanoi(3,'s','d','h');
    }
}