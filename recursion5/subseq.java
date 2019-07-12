import java.util.*;
public class subseq{

    public static void pss(String q , String asf){

        if(q.length()==0){
            System.out.println(asf);
            return;
        }
        
        char ch = q.charAt(0);
        String ros = q.substring(1,q.length());

        pss(ros , asf+ch);
        pss(ros,asf+"-");
    }

    public static void main(String[] args){
        pss("abc", " ");

    }
}