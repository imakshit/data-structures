import java.util.*;
public class pattern6{
    public static void main(String[] args){
    System.out.println("enter the value of n: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int row = 1;
    int nsp = 1; //no. of spaces
    int nst = (n/2)+1; //no. of stars
    
    while(row<=n){
        //print star
        //print spaces
        //print star

        int cst1 = 1;  //logic to print stars
        while(cst1<=nst){
            System.out.print("*");
            cst1++;
        }

        int csp = 1; //logic to print spaces
        while(csp<=nsp){
            System.out.print(" ");
            csp++;
        }

        int cst2 = 1; //logic to print stars
        while(cst2<=nst){
            System.out.print("*");
            cst2++;
        }

        if(row<=n/2) //going down to mid , stars dec by 1 and spaces inc by 2
        {
            nst--;
            nsp+=2;
        }
        else //going down after mid , stars inc by 1 and spaces dec by 2
        {
            nst++;
            nsp-=2;
        }

        System.out.println();
        row++;

    }

    }
}