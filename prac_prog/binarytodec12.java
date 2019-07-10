import java.util.*;
public class binarytodec12{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double sum = 0;
        int m = 1; //2^0
        while(n>0){
            int rem = n%10;
            n = n/10;
            int p = rem*m;
            m = m*2;
            sum = sum+p;

        }
        System.out.println(sum);
    
    }
}