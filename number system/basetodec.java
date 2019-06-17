import java.util.*;
public class basetodec{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int base = sc.nextInt();
        int m = 1;//base^0
        double sum = 0;
        while(n>0){
            int rem = n%10;
            n = n/10;
            int p = rem*m;
            m = m*base;
            sum =sum+p;
        }System.out.println(sum);
    }
}