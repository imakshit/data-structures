import java.util.*;
public class inverse{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       // System.out.println("enter the number : ");
        int n = 215634;
        int counter = 0;
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            counter+=1;
            int num =(int) Math.pow(10 , rem-1);
            n=n/10;
            int p = num*counter;
             sum= sum+p;
            
        }
        System.out.println("inverse is: ");
        System.out.println(sum);
    }
}