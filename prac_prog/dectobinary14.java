import java.util.*;
public class dectobinary14{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        double sum =0;
        int m = 1; //10^0
        while(n>0){
            int rem = n%2;
            n = n/2;
            int p = rem*m;
            m = m*10;
            sum=sum+p;
        }
        System.out.println(sum);
    }
}