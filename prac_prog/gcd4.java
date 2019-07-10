import java.util.*;
public class gcd4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(b%a!=0){
            int c = b%a;
            b = a;
            a = c;

        }
        System.out.println("gcd is: "+a);

        int lcm = a>b?a:b;
        while(true){
            if(lcm%a==0 && lcm%b==0){
                System.out.println("lcm is: "+lcm);
                break;
            }++lcm;
        }


    }
}