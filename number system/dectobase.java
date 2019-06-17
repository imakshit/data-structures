import java.util.*;
public class dectobase{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int base = sc.nextInt();
        int m = 1; //10^0
        double sum = 0;
        while(n>0){
            int rem = n%base;
            n = n/base;
            int p = rem*m;
            m = m*10;
            sum = sum+p;
        }
        System.out.println(sum);
    }
}