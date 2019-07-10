import java.util.*;
public class leap3{

    static boolean leapyear(int n){
        boolean k = false;
        if(n%4==0 || n%400==0){
            k = true;           
            }
         
        return k;
    }

    public static void main(String[] args){

        boolean k = leapyear(2011);
        System.out.println(k);

    }
}