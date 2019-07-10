import java.util.*;
public class armstrong10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n;
        int counter = 0;
        int sum = 0;
        // while(n>0){
        //     n=n/10;
        //     counter++;
        // }
        // System.out.println(counter);
        while(n!=0){
            int r = n%10;
            n = n/10;
            int p = (int)Math.pow(r , 3);
             sum = sum + p;
        }
        if(sum==k){
            System.out.println("armstrong");
        }else{
             System.out.println("not armstrong");
            
        }
        
    }
}