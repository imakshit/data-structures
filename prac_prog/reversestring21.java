import java.util.*;
public class reversestring21{
    public static void rev(String a , String b){
        for(int i =a.length()-1; i>=0 ; i--){
            b = b+a.charAt(i);

        }System.out.println(b);
    }
    public static void main(String[] args){
        rev("pots" , "");
        
    }
}