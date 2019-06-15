import java.util.*;
public class pattern4{
    public static void main(String[] args){
        System.out.println("enter value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row =0;
        
        while(row<n){
            int col = 0;
            int value =1; //cuz nC0 is 1 , value is rowCcol
            while(col<=row){
                System.out.print(value+" ");
                int nckp1 = value*(row-col)/(col+1);
                value = nckp1;
                col++;
            }
            System.out.println();
            row++;

        }
    }
}