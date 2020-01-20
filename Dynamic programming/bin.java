import java.util.*;
public class bin{

    public static int binary( int n){
      int c0 = 1;
      int c1 = 1;
      for(int i =2 ; i<=n ; i++){
          int nc0 = c1;
          int nc1 = c0+c1;
          c0 = nc0;
          c1 = nc1;
      }
        return c1+c0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(binary(n));
    }
}