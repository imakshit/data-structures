import java.util.*;
public class stairdp{

    public static int psp(int src ,int[] qb){
        
        if(src==0){
          //  System.out.println(psf);
            return 1;
        }
        else if(src<0){
            return 0;
        }
        else if(qb[src]!=0){
            return qb[src];
        }
        
        int pnm1 = psp(src-1 ,  qb);
        int pnm2 = psp(src-2 , qb);
        int pnm3 = psp(src-3 , qb);
        int pn = pnm1 + pnm2 + pnm3 ; 
        qb[src] = pn;
        return pn;
        }
            
    public static void main(String[] args){
        int n = 40;
        int[] qb = new int[n+1];
        long start = System.currentTimeMillis();
        int k = psp(n , qb);
        long end = System.currentTimeMillis();
        long dur = end-start;
        System.out.println(k+" in "+dur);
    }
}