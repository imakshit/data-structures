import java.util.*;
public class allprime{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count of numbers: ");
        int n = sc.nextInt();
        for(int i = 1 ; i<=n ; i++){
            System.out.println("enter the "+i+"th number :");
            int num = sc.nextInt();
            boolean isprime = true;
            for(int d =2 ; d*d<=num ; d++){
                if(num%d==0){
                    isprime = false;
                    break;
                }
            }
            if(isprime==false){
                System.out.println(" is not prime");

            }else{
                System.out.println("is prime");
            }

        }
    }
}