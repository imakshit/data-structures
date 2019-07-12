import java.util.*;
public class kpc{

           static String[] codes= {
    ".",
    "abc",
    "def",
    "ghi",
    "jklm",
    "no",
    "pqrs",
    "tu",
    "vwxy",
    "z"
};


public static void pkpc(String q , String asf){
 
        if(q.length()==0){
            System.out.println(asf);
            return;
        }    

        char ch = q.charAt(0);
        String ros = q.substring(1,q.length());

        String chcode = codes[ch-48];
        for(int i = 0 ; i<chcode.length() ; i++){
            pkpc(ros , asf + chcode.charAt(i));
        }

}
        public static void main(String[] args){

            pkpc("835" , " ");

    }
}