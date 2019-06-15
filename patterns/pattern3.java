import java.util.*;
public class pattern3{
    public static void main(String[] args)
    {
        System.out.println("enter value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row =1;
        int a=0;
        int b=1;
        int sum=0;

        while(row<=n){
            int col=1;
            while(col<=row){
                 System.out.print(a+" ");
                sum=a+b;
                a=b;
                b=sum;
                col++;
               

            }
            System.out.println();
            row++;

        }
    }
}