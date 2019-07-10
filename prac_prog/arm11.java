import java.util.*;
public class arm11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        
        
    
        for(int i = n1 ; i<=n2 ; i++){
             int sum = 0;
            int n = i ;
            while(n!=0){
            int r = n%10;
            n = n/10;
            int p = (int)Math.pow(r , 3);
             sum = sum + p;}
        
        if(sum==i){
            System.out.println(i);   
        }
        
        
    }
}}