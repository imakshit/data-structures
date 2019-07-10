import java.util.*;
public class palindrome8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n;
        int t = (int)Math.pow(10,3);
        int sum = 0;
        while(n>0){
            int r = n%10;
            n = n/10;
             sum = (sum*10)+r;
        }
        if(sum==k){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }
    }
}