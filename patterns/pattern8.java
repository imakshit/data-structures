import java.util.*;
public class pattern8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n: ");
        int n = sc.nextInt();
        int row =1;
        int nst =1;
        int nsp = (n/2)+1;
        int sp = 1;
        while(row<=n){

            int csp1 = 1;
            while(csp1<=nsp){
               System.out.print(" ");
               csp1++; 
            }

            int cst = 1;
            int val = sp;
            while(cst<=nst){
                System.out.print(val);
               
                if(cst<=nst/2){
                val++;}
                else{
                    val--;
                }
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
                sp++;
            }else{nsp++;
            nst-=2;
            sp--;

            }

            System.out.println();
            row++;
        }
    }
}