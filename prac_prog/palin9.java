import java.util.*;
public class palin9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = "";
        for(int i = a.length()-1 ; i>=0 ; i--){
            b = b + a.charAt(i);
        }
        // System.out.println(b);
        if(a.equals(b)){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
            }
    }
}