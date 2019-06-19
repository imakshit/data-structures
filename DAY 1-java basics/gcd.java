import java.util.*;
public class gcd{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i =b ; i>0; i--){
            if(a%i==0 && b%i==0){
                System.out.println("GCD is:" +i );
                break;
            }
        }   
    }
}