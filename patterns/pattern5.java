import java.util.*;
public class pattern5{
    public static void main(String[] args){
        System.out.println("enter value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = 1;
        while(row<=n){
            int col = 1;
            while(col<=n){
                if(row==col){
                    System.out.print("*");

                }else if(row+col==n+1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                col++;
            }
            System.out.println();
            row++;
        }
    }
}