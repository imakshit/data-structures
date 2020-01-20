import java.util.*;
public class countssub{

    public static int countofsubsequence(String s){
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i =0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(ch=='a'){
                a = 1 + 2*a;
            }else if(ch=='b'){
                b = a + 2*b;
            }else if(ch=='c'){
                c = b + 2*c;
            }
        }
        return c;
    }

    public static void main(String[] args){

        String s = "abcabc";
        System.out.println(countofsubsequence(s));
    }
}