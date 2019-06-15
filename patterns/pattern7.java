import java.util.*;
public class pattern7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n: ");
        int n = sc.nextInt();
        int row =1;
        int nst =1;
        int nsp = (n/2)+1;
        while(row<=n){

            int csp1 = 1;
            while(csp1<=nsp){
               System.out.print(" ");
               csp1++; 
            }

            int cst = 1;
            while(cst<=nst){
                System.out.print("*");
                cst++;
            }

            int csp2 = 1;
            while(csp2<=nsp){
                System.out.print(" ");
                csp2++;
            }

            if(row<=n/2){
                nst+=2;
                nsp--;
            }else{nsp++;
            nst-=2;

            }

            System.out.println();
            row++;
        }
    }
}