import java.util.*;
public class subseq{

    public static ArrayList<String> getss(String s){
         
        if(s.length()==0){
            //when on top of tree , return blank
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = s.charAt(0); //ch=a
        String ros = s.substring(1,s.length()); //bc
        ArrayList<String> rres = getss(ros); //recursion result = [-- , b- , -c , bc]
        ArrayList<String> mres = new ArrayList<>(); // my result
       
        for(int i =0; i<rres.size() ; i++){
          String rstr = rres.get(i); //[first string from rres ie --]
          mres.add("-" + rstr); //add -
          mres.add(ch+rstr); // add a

        }
        return mres; //return myres

    }


    public static void main(String[] args){
        ArrayList<String> list = getss("abc");
        System.out.println(list);

    }
}