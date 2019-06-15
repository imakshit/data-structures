import java.util.*;
public class pattern2{
    public static void main(String[] args)
    {
        System.out.println("enter value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row =1;
        
        int val = 1;
        while(row<=n){
           int col=1;
            while(col<=row){
                System.out.print(val+" ");
                val++;
                col++;
            }
            System.out.println();
            row++;
        }
    }
}