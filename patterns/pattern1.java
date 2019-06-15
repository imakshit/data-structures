import java.util.*;
public class pattern1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value of n: ");
        int n = sc.nextInt();
        int row = 1;
        while(row<=n){
        int col = 1;
        while(col<=row){
            System.out.print("* ");
            col++;

        }
        System.out.println();
        row++;
        }
    }
}